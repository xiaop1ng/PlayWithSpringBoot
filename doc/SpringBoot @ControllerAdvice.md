# 开门见山

目的是想要利用 `@ControllerAdvice` 和 `@ExceptionHandler` 来全局捕获请求中的发生的异常，全局处理（响应）。大概的思路就是使用一个自定的异常类（包含我们需要的响应错误码、错误信息，具体看情况定义），然后请求业务中（请求处理方法、拦截器...）直接抛出异常就可以达到方便我们响应到客户端的目标。



# @ControllerAdvice

通常用于定义`@ExceptionHandler`， `@InitBinder`和 `@ModelAttribute` 适用于所有 `@RequestMapping` 方法的方法。 

