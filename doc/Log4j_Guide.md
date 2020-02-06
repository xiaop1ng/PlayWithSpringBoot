# Log4j 2

> 在代码中插入日志语句是调试程序的一种技术含量较低的做法。但这可能也是唯一的方法，因为调试器并不总是可用或适用的，
这是在大型多线程应用和分布式应用中的通常情况。


日志的缺点：它可能让程序变慢，如果太详细，它可能导致滚动的内容太多而不可见。

### 主要的类

- LoggerContext 日志系统中的一个锚点
- Logger
- LoggerConfig
- Configuration
- Appender
- Layout

> 应用程序要使用 Log4j 2 的 API，需要从 LogManager 中获取一个有明确名称的 Logger。LogManager 将会定位到一个合适的
LoggerContext 并且从中获取 Logger。如果 Logger 必须被创建，那么它会和包含这些信息的 LogConfig 相关联：
a）与 Logger 相同的名称；b）父包的名称；c）根 LoggerConfig。LoggerConfig 对象根据配置中的 Logger 声明而创建。
LoggerConfig 与实际处理 LogEvent 事件的 Appender 关联。

### 获取 logger

> LogManger.getLogger(CLASS_NAME);

当然这是一种惯用的命名策略，Log4j 并不限制 Logger 的可能性，也可以自由命名

### 日志级别

- TRACE
- DEBUG
- INFO
- WARN
- ERROR
- FATAL
- 自定义日志级别

### Layout

输出格式

Log4j 带有很多不同的 Layout 以支持诸如 JSON、XML、HTML 等用例



