# 开门见山

目的是想要利用 `@ControllerAdvice` 和 `@ExceptionHandler` 来全局捕获请求中的发生的异常，全局处理（响应）。大概的思路就是使用一个自定的异常类（包含我们需要的响应错误码、错误信息，具体看情况定义），然后请求业务中（请求处理方法、拦截器...）直接抛出异常就可以达到方便我们响应到客户端的目标。



# @ControllerAdvice

通常配合 `@ExceptionHandler`， `@InitBinder`和 `@ModelAttribute` 使用，适用于所有 `@RequestMapping` 注解的方法。 

这里我们可以了解一下 `@InitBinder` 注解，是对入参做一系列的处理，如：时间格式的统一处理、设置不被允许的字段。

还是直奔今天的主题，使用 `@ControllerAdvice` 和 `@ExceptionHandler` 来做全局异常处理。

`@ExceptionHandler` 的 value 属性可以传入一个数组，这里我们简单粗暴的捕获 `Exception.class` ，然后去根据捕获到的 exception 的具体类型给客户端响应不同的错误信息。

```java
@ControllerAdvice
public class WebExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Rs errorHandler(HttpServletRequest req, HttpServletResponse res, Exception e) {
		logger.error("", e);
		if (e instanceof InvokeException) {
			InvokeException ex = (InvokeException)e;
			return Rs.err(ex.getErr(), ex.getMessage());
		}
		return Rs.errMsg("系统错误");
	}
}
```



这里为了更方便响应客户端，自定义了一个 `InvokeException` 继承自 `RuntimeException`，里面包含错误信息和错误码。

```java
/**
 * 业务异常类，WebExceptionHandler 中会统一处理这个异常返回到接口
 */
public class InvokeException extends RuntimeException {

    private int err;

    public int getErr(){
        return err;
    }

    public InvokeException(String msg) {
        super(msg);
        this.err = Rs.ERROR_CODE_BIZ;
    }

    public InvokeException(int err, String msg) {
        super(msg);
        this.err = err;
    }

}
```

# Use

在准备后异常捕获类和业务异常类之后，在业务代码中，当需要响应错误信息时，只需要抛异常就可以了。比如：业务中常常会做的数据校验、权限校验等。

```java
	@GetMapping("/exception")
	Rs exception() {
		throw new InvokeException("丑拒！");
	}

```

访问 `/exception`, 响应：

```json
{
    "err": -1001,
    "msg": "丑拒！",
    "data": {}
}
```



这里需要做一个说明的是：`try...catch...` 的异常不会进入异常捕获处理类中。



