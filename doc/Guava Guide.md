# Use

```
<!-- Google Guava-->
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>28.1-jre</version>
</dependency>
```

# 基本工具

对于应用业务代码而言，Null 往往是导致混乱，疑难问题和模糊语义的元凶
不要在 Set 中使用 null，或者把 null 作为 map 的键。使用特殊值代表 null 会让查找操作的语义更清晰。

`Optional<T>` 表示可能为 null 的 T 型引用

`Preconditions` 提供了若干前置条件判断的方法

`Objects` 提供了一些对象基础基础方法

> Objects.equal(null, "a"); // false

这样做的好处是有效的规避了 `NullPointException`

`Ordering` 则是一个排序器

`Throwables` 异常传播，用于判断异常类型并且重新传播异常

`Forwarding` 装饰器

`PeekingIterator`、`AbstractIterator`、`AbstractSequentialIterator` 迭代器

`Functions` 函数与 `Predicates` 断言

`ListenableFuture` 并发处理 `Service` 服务框架

`Joiner` 连接器

> Joiner.on(",").skipNulls().join(Ints.asList(3, 2, 1));

`Splitter` 拆分器

>  Splitter.on(",").trimResults().omitEmptyStrings().splitToList(str);

`CharMatcher` 字符串处理

> CharMatcher.whitespace().removeFrom("    h    e llo  "); // hello

`Range` 区间

> Range.closed(0, 10); // 前闭后闭

# ref
- Source: [https://github.com/google/guava](https://github.com/google/guava)
- Wiki: [https://github.com/google/guava/wiki](https://github.com/google/guava/wiki)
- wiki 中文翻译: [https://willnewii.gitbooks.io/google-guava/](https://willnewii.gitbooks.io/google-guava/)
