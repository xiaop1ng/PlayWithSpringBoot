# 函数式编程途径
## Java 新的思维方式

关于命令式思考、声明式思考、函数式思考

> 命令式编程：关注过程，需要定义程序的每一步，告诉他迭代的每个元素，命令式编程提供了完全的控制权
```
	public static void main(String[] args) {
		List<String> pickList = Arrays.asList("Java", "Python", "Lua", "C++", "PHP", "JavaScript");
		pickBestLangue(pickList);
	}

	private static void pickBestLangue(List<String> pickList) {
		String result = "best langue not found.";
		for (String item : pickList) {
			if(item.equals("PHP")) {
				result = "PHP is the best langue."; // 嗯，PHP 是世界上最好的语言
				break;
			}
		}
		System.out.println(result);
	}
```

> 声明式编程：仍然需要告诉程序需要做什么，但是很多细节留给了底层的函数库。

```
	private static void pickBestLangue(List<String> pickList) {
		String result = "best langue not found.";
		if(pickList.contains("PHP")) {
			result = "PHP is the best langue."; // 嗯，PHP 是世界上最好的语言
		}
		System.out.println(result);
	}
```

> 函数式编程：使用高阶函数来完成任务，函数式编程在弱语言（如：JavaScript）中很普及使用。拥有更好的表达能力。
```
	private static void pickBestLangue(List<String> pickList) {
		String res = pickList.stream()
				.filter(i -> i.equals("PHP"))
				.findFirst()
				.orElse("NotFound.");
		if(res.equals("PHP")) {
			System.out.println("PHP is the best langue."); // 嗯，PHP 是世界上最好的语言
		}else {
			System.out.println("best langue not found.");
		}
	}
```


- 函数式代码比命令式代码更简洁。可读性更好。
- 函数式代码不会表现出明显的易变性，而且使用了更少的垃圾变量。

## Java 中的高阶函数
> 在 Java 中，要将对象传递给方法，在方法内创建对象，并从方法中返回对象。可以对函数执行同样的操作。也就是说，可以将函数传递给方法，在方法内创建函数，并从方法返回函数。
> 在此上下文中，方法 是类的一部分 — 静态或实例 — 但函数对于方法而言是本地函数，不能特意与类或实例关联。可以接收、创建或返回函数的函数或方法被视为高阶函数。

# 函数组合与集合管道模式

## 关于语句与表达式
如果在代码库中快速查找 for，您可能会惊奇地发现，您的代码中对 for 循环的使用非常频繁。我将这种情形称为 for重复(hammer)：只要我们需要循环，似乎就会用到 for。
在 Java 中，for 和 while 都是语句。语句执行一个操作，但不会生成任何结果。就本质而言，任何执行有用的操作的语句都会导致数据变化。这是语句表达其效果的唯一方式。而表达式则相反：它们可以得出结果而不会导致变化。

```
  IntStream.range(1, 4)
    .forEach(i -> System.out.print(i + "..."));
```

等价于
```
  for(int i = 1; i < 4; i++) {
  		System.out.print(i + "...");
  }
```

## 关于 Lambda 表达式
在许多情况下， Lambda 表达式的存在只是为了传递一个或多个形参。
在函数式编程中，常常传递 Lambda 表达式作为匿名函数，使用 Lambda 作为更高阶函数的实参。

普通函数（方法）通常有四个元素：
- 一个名称
- 返回类型
- 参数列表
- 主体

Lambda 表达式的构成： `(parameters) -> body` 这里的 `->` 将参数列表和函数主体分离。函数的主体可能是一个表达式或一个语句。
```
i -> i*2
```
在上面这个 Lambda 表达式中只有一行。信噪比很高，没有分号，也不需要 return 关键字。这是一个理想的 Lambda 表达式。

当然，有很多时候，我们的函数主体可能需要包含多行表达式或语句。在这种情况下，分号必不可少，也会需要 return 关键字，因为主体包含多行，括号(`{}`) 也是必须的。
```
i -> {
	int square = i*i;
	int number = square/2 + 1;
	return square + number;
}
```

## JDK8 中的新的内置函数接口

> 最常用的接口包括 Function<T, R>、Predicate<T> 和 Consumer<T>，它们是在 java.util.function 包中定义的。Stream 的 map 方法接受 Function<T, R> 作为参数。类似地，filter 使用 Predicate<T>，forEach 使用 Consumer<T>。该包还有其他函数接口，比如 Supplier<T>、BiConsumer<T, U> 和 BiFunction<T, U, R>。

