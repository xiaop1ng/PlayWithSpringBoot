# 什么是 Netty
Netty 是一个利用 Java 的高级网络的能力，隐藏其背后的复杂性而提供一个易于使用的 API 的客户端/服务器框架。
Netty 已经实现了的协议就有 FTP, SMTP, HTTP, WebSocket 和 SPDY 以及其他二进制和基于文本的协议。

下面贴出[官网](http://netty.io/index.html)的介绍：
> Netty is an asynchronous event-driven network application framework 
for rapid development of maintainable high performance protocol servers & clients.

是的，Netty 是一个异步和事件驱动的网络框架，下面一起来看一下几个核心概念。

# Channel
> Channel 是 NIO 基本的结构。它代表了一个用于连接到实体如硬件设备、文件、网络套接字或程序组件,能够执行一个或多个不同的 I/O 操作（例如读或写）的开放连接。
现在,把 Channel 想象成一个可以“打开”或“关闭”,“连接”或“断开”和作为传入和传出数据的运输工具。

# Callback
> callback(回调)通常是一个方法,提供给另一种方法作为引用,这样后者就可以在某个合适的时间调用前者。
Netty 内部使用回调处理事件时。一旦这样的回调被触发，事件可以由接口 ChannelHandler 的实现来处理。

# Future
> Future 提供了另外一种通知应用操作已经完成的方式。这个对象作为一个异步操作结果的占位符,它将在将来的某个时候完成并提供结果。
JDK 附带接口 java.util.concurrent.Future ,但所提供的实现只允许您手动检查操作是否完成或阻塞了。这是很麻烦的，所以 Netty 提供自己了的实现,ChannelFuture,用于在执行异步操作时使用。
每个 Netty 的 outbound I/O 操作都会返回一个 ChannelFuture;这样就不会阻塞。这就是 Netty 所谓的“自底向上的异步和事件驱动”。

# Event & Handler
Netty 使用不同的事件来通知我们更改的状态或操作的状态。这使我们能够根据发生的事件触发适当的行为。
这些行为可能包括：
- 日志
- 数据转换
- 流控制
- 应用程序逻辑


由于 Netty 是一个网络框架,事件很清晰的跟入站或出站数据流相关。因为一些事件可能触发传入的数据或状态的变化包括:
- 活动或非活动连接
- 数据的读取
- 用户事件
- 错误


出站事件是由于在未来操作将触发一个动作。这些包括:
- 打开或关闭一个连接到远程
- 写或冲刷数据到 socket


每个事件都可以分配给用户实现处理程序类的方法。这说明了事件驱动的范例可直接转换为应用程序构建块。
Netty 的 ChannelHandler 是各种处理程序的基本抽象。想象下，每个处理器实例就是一个回调，用于执行对各种事件的响应。

# SELECTOR, EVENT & EVENT LOOP

Netty 通过触发事件从应用程序中抽象出 Selector，从而避免手写调度代码。EventLoop 分配给每个 Channel 来处理所有的事件，包括
- 注册感兴趣的事件
- 调度事件到 ChannelHandler
- 安排进一步行动

# BootStrap
Netty 应用程序通过设置 bootstrap（引导）类的开始，该类提供了一个 用于应用程序网络层配置的容器。


# ChannelHandler 
ChannelHandler 支持很多协议，并且提供用于数据处理的容器。我们已经知道 ChannelHandler 由特定事件触发。 ChannelHandler 可专用于几乎所有的动作，包括将一个对象转为字节（或相反），执行过程中抛出的异常处理。

# ChannelFuture
Netty 所有的 I/O 操作都是异步。因为一个操作可能无法立即返回，我们需要有一种方法在以后确定它的结果。出于这个目的，Netty 提供了接口 ChannelFuture,它的 addListener 方法注册了一个 ChannelFutureListener ，当操作完成时，可以被通知（不管成功与否）。

# ChannelHandler 和 ChannelPipeline
`ChannelPipeline` 是 `ChannelHandler` 链的容器。
在很多方面的 ChannelHandler 是引用程序的核心，在 Netty 中有两个方向的数据流： 
- 入站（`ChannelInboundHandler`）：数据是从用户应用程序到远程主机
- 出站（`ChannelOutboundHandler`）：数据时从远程主机到用户应用程序

这里的 `ChannelInboundHandler` 接口和 `ChannelOutboundHandler` 接口均集成自 `ChannelHandler` 接口。


# 使用 Netty 创建一个 HTTP 服务器

步骤：
 1. 一个服务端的 Handler：用于处理连接创建后和接收到信息后的业务，构建一个 FullHttpResponse 对象输出。
 2. Server：配置服务器的启动代码

# SPDY

> SPDY(读作“speedy”)是一个谷歌开发的开放的网络协议，主要运用于 web 内容传输。SPDY 操纵 HTTP 流量,目标是减少 web 页面加载延迟,提高网络安全。SPDY 达到通过压缩、多路复用和优先级来减少延迟，虽然这取决于网络和网站部署条件的组合。“SPDY”这个名字是谷歌的一个商标,不是一个首字母缩写。（摘自http://en.wikipedia.org/wiki/SPDY）






