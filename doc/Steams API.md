# Java 8 中的 Streams API

# 引子
在 Java 8 中加入很多新的 API，其中关于集合和数组增强功能的 API 可以说是备受好评。Streams API 很大程度上方便了 Java 开发过程中对于数据的操作和计算了。我们写一个简单的栗子对比一下在使用到 Streams API 时的便利

> 求数组 [7, 8, 4, 5, 1, 6, 4, 1, 9] 中所有的奇数的和

Java 7
```
int [] array = {7, 8, 4, 5, 1, 6, 4, 1, 9};
int sum1 = 0;
for (int i = 0; i < array.length; i++) {
	if(array[i]%2 != 0) {
		sum1 += array[i];
	}
}
System.out.println(sum1); // 23
```

Java 8 use Streams API
```
int [] array = {7, 8, 4, 5, 1, 6, 4, 1, 9};
int sum2 = Arrays.stream(array).filter(i -> i%2 != 0).sum();
System.out.println(sum2); // 23
```
可以看的出来，当使用到 Streams API 结合 Lambda 表达式来操作集合或者数组的时候，代码变得很简洁，可读性也大大的提升了。

# Streams 是啥呢
关于 `java.util.stream.Stream` 首先需要说明的是 Stream 不是集合，不保存数据，他是关于算法（计算）的，可以进行 `map`、`filter` 等操作（熟悉 JavaScript 的同学应该非常习惯对数组使用这些操作）。`Stream` 就如同一个迭代器，而和迭代器又不同的是，Stream 可以并行化操作。 `Stream` 的另一特点是，数据源本身可以是无限的。

> 我们使用一个 `Streams` 的时候，通常是三个基本步骤 1.获取数据源 -> 2.数据转换 -> 3.执行操作获取想要的结果

## 如何获取一个 Streams
常用的获取一个 `Streams` 的方法有：
- 数组或集合
> Collection.stream() // 单管
Collection.parallelStream() // 多管
Arrays.stream(T array) or Stream.of()

- 静态工厂
> java.util.stream.IntStream.range()
java.nio.file.Files.walk()

## 如何去使用一个 Streams

流的操作类型分为两种：
> Intermediate：一个流可以后面跟随零个或多个 intermediate 操作。其目的主要是打开流，做出某种程度的数据映射/过滤，然后返回一个新的流，交给下一个操作使用。这类操作都是惰性化的（lazy），就是说，仅仅调用到这类方法，并没有真正开始流的遍历。
> map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered
> Terminal：一个流只能有一个 terminal 操作，当这个操作执行后，流就被使用“光”了，无法再被操作。所以这必定是流的最后一个操作。Terminal 操作的执行，才会真正开始流的遍历，并且会生成一个结果，或者一个 side effect。
> forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator

转换大写的一个应用，`map` 操作通常也被应用在对象转换上比如在 web 开发中将数据库中查询到的数据转换为 api 中适用的对象 
```
List<String> stringList = new ArrayList<>();
stringList.add("ni");
stringList.add("Zhen");
stringList.add("mEi");
List<String> upperCaseStringList = stringList.stream().map(String::toUpperCase).collect(Collectors.toList());
for (String word : upperCaseStringList) {
	System.out.println(word); // NI ZHEN MEI
}
```
