# 注解



## 糟糕的技术文档或者技术文章

我们经常在代码中看到 `@Override`, `@Service`, `@Autowired` 等注解，那么究竟这些注解是干吗的，怎么工作的。

使用专业名词来介绍专业名词。

> 可以这样理解注解：想像代码具有生命，注解就是对于代码中某些鲜活个体的贴上去的一张标签。简化来讲，注解如同一张标签。

注解用于为 Java 代码提供元数据

## 注解的定义

如同 `class` 和 `interface` 一样，注解也属于一种类型。

注解通过 `@interface` 关键字定义

```
public @interface MyAnnotation {
}
```

## 注解的使用

```
@MyAnnotation
public class Test{
}
```
我们在 cmdtest 类上面使用了 `@MyAnnotation` 注解，这个行为可以理解为我们在 cmdtest 类上贴上了 `@MyAnnotation` 这个标签

## 元注解

元注解是描述注解的注解，也就是解释标签的标签。

元标签有 `@Retention`、`@Documented`、`@Target`、`@Inherited`、`@Repeatable` 5 种。


## @Retention

Retention 的中文意思是“保留，保持”。

`@Retention` 定义被它所注解的注解保留多久，有三种策略（SOURCE, CLASS, RUNTIME）缺省值是 CLASS

- RetentionPolicy.SOURCE 编译器忽略
- RetentionPolicy.CLASS 注解保留在 class 文件中，但是运行时不被 VM 保留。
- RetentionPolicy.RUNTIME 保留至运行时。既可以在运行时通过反射去获取注解信息。

## @Documented

这个应该不用解释，它的作用是能够将注解中的元素包含到 Javadoc 中去。

## @Target

Target 是目标的意思，`@Target` 指定了注解应用的地方，当一个注解被 `@Target` 注解时，这个注解就被限定了使用场景。

- ElementType.ANNOTATION_TYPE 可以给一个注解进行注解
- ElementType.CONSTRUCTOR 可以给构造方法进行注解
- ElementType.FIELD 可以给属性进行注解
- ElementType.LOCAL_VARIABLE 可以给局部变量进行注解
- ElementType.METHOD 可以给方法进行注解
- ElementType.PACKAGE 可以给一个包进行注解
- ElementType.PARAMETER 可以给一个方法内的参数进行注解
- ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举

## @Inherited

Inherited 是继承的意思，当一个注解 `@MyAnnotation` 被 `@Inherited` 注解时，那么一个被 `@MyAnnotation` 注解的类他的所有子类都继承了该类的 `@MyAnnotation` 。
在我们现实生活中也有类似的例子，比如说： 富二代、富三代、拆二代、官二代这些标签。

## @Repeatable

Repeatable 是可重复的意思，`@Repeatable` 是 Java8 加入的，他其实算是一语法糖，看个例子：

```
@Roles({@Role(name="coder"), @Role(name="artist"), @Role(name="scientist")}) 
```

这个注解描述了一个程序员可能同时是一个艺术家，也是一个科学家。


## 注解的属性

注解的属性也叫做成员变量。注解只有成员变量，没有方法。注解的成员变量在注解的定义中以“无形参的方法”形式来声明，其方法名定义了该成员变量的名字，其返回值定义了该成员变量的类型, `default`  关键字定义了属性的缺省值。

我们看一个 Spring 里面常用的注解，一个用于映射请求路由的注解 `@RequestMapping`

```
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface RequestMapping {
    String name() default "";

    @AliasFor("path")
    String[] value() default {};

    @AliasFor("value")
    String[] path() default {};

    RequestMethod[] method() default {};

    String[] params() default {};

    String[] headers() default {};

    String[] consumes() default {};

    String[] produces() default {};
}
```

我们可以看到 `@RequestMapping` 里常用的属性 value, method 等, 我们使用他的方式：

```
@RequestMapping(value = "/", method = RequestMethod.GET)
```

## 注解的使用

我们知道注解拥有自己的属性，那么我们需要怎么来使用呢？通常情况下我们需要使用反射的方式去取出注解中的属性值。


