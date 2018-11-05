# 相关的概念
为什么要使用并行程序？一，为了获得更好的性能；二，由于业务模型的需要，确实需要多个执行实体。

### 同步和异步

同步和异步通常来描述一个方法的调用

- 同步(Synchronous)：同步方法调用一旦开始，调用者必须等到方法调用返回后，才能继续后续的行为。

- 异步(Asynchronous)：异步方法调用更像一个消息的传递，调用后调用者可以继续后续的操作，而异步的方法通常在另一个线程中被执行，如果异步调用需要返回结果，那么异步方法在完成时会通知调用者。

### 并发和并行

这是两个很容易混淆的概念，都可以表示两个或多个任务一起执行，但是偏重点有些不同。

- 并发(Concurrency)：多个任务交替被执行，而多个任务之间有可能还是串行的。

- 并行(Parallelism)：是真正的多个任务同时被执行

> 由于一个 CPU 核心只能运行一条指令，所以真实的并行只可能发生在多核 CPU 的电脑上。

### 临界区

临界区表示一种公共资源或者说是共享数据，可被多个线程使用。但是每一次只能有一个线程使用它，一旦临界区的资源被占用，其他线程要想使用这个资源就必须等待。

### 阻塞和非阻塞
阻塞和非阻塞通常形容多线程间的相互影响。

- 阻塞(Blocking)：当一个线程占用了临界区的资源，其他的所有的线程都在这个临界区等待，导致线程挂起，这种情况就是阻塞。

- 非阻塞(Non-Blocking)：非阻塞强调没有一个线程可以妨碍其他线程执行，所有的线程都会尝试不断前向执行。

### 死锁、饥饿和活锁

死锁、饥饿和活锁都属于线程活跃性问题。

- 死锁(DeadLock)：死锁出现于多个线程直接所占有的资源和所等待的资源的冲突导致，如：线程A占用着记录1等待记录2，线程B占用着记录2等待记录1。

- 饥饿(Starvation)：饥饿是指一个或多个线程因为种种原因无法获得所需要的资源，导致一直无法执行。与死锁相比，饥饿还是有可能在未来一段时间内解决的。

- 活锁(LiveLock)：在两个或多个线程在秉着“谦让”的态度，主动将自己所占有的资源让给他人使用，这时资源在线程之间跳来跳去导致没有一个线程能同时拥有所有需要的资源，从而没有一个线程能顺利的执行。

### 并发的级别
由于临界区的存在，多线程之间的并发必须受到控制。根据控制并发的策略，我们可以把并发级别分类，大致上可以分为阻塞、无饥饿、无障碍、无锁、无等待几种。

- 阻塞(Blocking)：一个线程是阻塞的时候，在其他线程释放该线程所需要的资源之前，当前线程无法继续执行。当我们使用 `synchronized` 关键字，或重入锁时我们得到的就是阻塞的线程。

- 无饥饿(Starvation-Free)：如果线程间是有优先级的，那么系统总是倾向于满足优先级别高的线程。也就是说线程之间是不公平的，可能导致有的线程饥饿。如果是公平线程的话，即所有的线程都需要排队来等待资源，那么可以做到无饥饿。

- 无障碍(Obstruction-Free)：无障碍是最弱的非阻塞调度，两个或多个线程无障碍的执行，他们不会因为临界区的问题导致一方被挂起。如果出现了一起修改共享数据的情况时，以保护数据为第一优先级，对自己的修改做回滚，确保数据安全。

- 无锁(Lock-Free)：无锁的并行都是无障碍的。无锁的线程都能尝试对临界区进行访问，他会不断的尝试修改共享变量。如果没有冲突，修改成功，程序退出，否则继续尝试修改。

- 无等待(Wait-Free)：一种典型的无等待结构是 RCU (Read-Copy-Update) 基本思想为对于读操作不加控制，对于写先获取原始数据的副本，接着只修改副本数据，修改完成后，在合适的时机回写数据。

### Amdahl 定律
> 加速比定义： 加速比 = 优化前系统耗时 / 优化后系统耗时

即，所谓的加速比，就是优化前后耗时的比值。加速比越高则表明优化效果越明显。

### Gustafson 定律
和 Amdahl 定律一样，Gustafson 定律也试图说明处理器个数、串行比例和加速比的关系，不过 G 定律提供了一个不同的视角。

### Java 内存模型(JMM)
并行程序比串行程序复杂得多，其中一个很重要的原因是并发程序下的数据访问的一致性和安全性将会受到严重挑战。JMM 就是为了解决多线程间有效的、正确地协同工作。

> JMM 的关键技术点都是围绕着多线程的原子性、可见性和有序性来建立的。

- 原子性(Atomicity)：原子性是指一个操作是不可中断的。即使是在多个线程一起执行的时候，一个操作开始，就不会受其他的线程影响。

- 可见性(Visibility)：可见性是指当一个线程修改了某一个共享变量的值，其他线程是否能够立即知道这个修改。

- 有序性(Ordering)：有序性是最难理解的，出现的原因可能是由于指令重排。

> 注：指令重排可以保证串行语义一致，但没有义务保证多线程的语义也一致。

### 关于进程
进程(Process)是计算机中的程序关于某数据集合上的一次运动活动，是系统进行资源分配和调度的基本单位，是操作系统结构的基础。

在当代的面向线程设计的计算机结构中，进程是线程的容器。

用专业点的术语来说，线程就是轻量级的进程，是程序执行的最小单位。使用多线程而不是多进程去进行并发程序的设计，是因为线程间的切换和调度的成本远远小于进程。

### 线程的状态
线程的所有状态都在 `Thread` 中的 `State` 枚举中定义

```
public enum State {
    /**
     * Thread state for a thread which has not yet started.
     */
    NEW,

    /**
     * Thread state for a runnable thread.  A thread in the runnable
     * state is executing in the Java virtual machine but it may
     * be waiting for other resources from the operating system
     * such as processor.
     */
    RUNNABLE,

    /**
     * Thread state for a thread blocked waiting for a monitor lock.
     * A thread in the blocked state is waiting for a monitor lock
     * to enter a synchronized block/method or
     * reenter a synchronized block/method after calling
     * {@link Object#wait() Object.wait}.
     */
    BLOCKED,

    /**
     * Thread state for a waiting thread.
     * A thread is in the waiting state due to calling one of the
     * following methods:
     * <ul>
     *   <li>{@link Object#wait() Object.wait} with no timeout</li>
     *   <li>{@link #join() Thread.join} with no timeout</li>
     *   <li>{@link LockSupport#park() LockSupport.park}</li>
     * </ul>
     *
     * <p>A thread in the waiting state is waiting for another thread to
     * perform a particular action.
     *
     * For example, a thread that has called <tt>Object.wait()</tt>
     * on an object is waiting for another thread to call
     * <tt>Object.notify()</tt> or <tt>Object.notifyAll()</tt> on
     * that object. A thread that has called <tt>Thread.join()</tt>
     * is waiting for a specified thread to terminate.
     */
    WAITING,

    /**
     * Thread state for a waiting thread with a specified waiting time.
     * A thread is in the timed waiting state due to calling one of
     * the following methods with a specified positive waiting time:
     * <ul>
     *   <li>{@link #sleep Thread.sleep}</li>
     *   <li>{@link Object#wait(long) Object.wait} with timeout</li>
     *   <li>{@link #join(long) Thread.join} with timeout</li>
     *   <li>{@link LockSupport#parkNanos LockSupport.parkNanos}</li>
     *   <li>{@link LockSupport#parkUntil LockSupport.parkUntil}</li>
     * </ul>
     */
    TIMED_WAITING,

    /**
     * Thread state for a terminated thread.
     * The thread has completed execution.
     */
    TERMINATED;
}
```

### 线程的创建
- Thread()
- Thread(Runnable target)

> 注：这里执行 start()，会开启一个新线程，然后调用 run()
需要注意的是 run() 可以直接被访问到，但是直接调用他只会在当前线程中串行执行 run() 中的代码。

### 线程的终止
一般来说，线程在执行完毕后就会结束，无须手动关闭。但是凡事都有例外，有些服务端的后台线程可能常驻系统，他们的执行体本省就是个无穷循环。

Thread 类中有提供一个 stop() ，但是上面已经打上了废弃的注解并说明 `This method is inherently unsafe.`。使用 stop 方法时，会直接终止线程，并释放线程所持有的锁。而这些锁恰恰是用来维持对象一致性的。

所以不要随便使用 stop() 来终止一个线程。那么我们应该如何终止线程了，解决方法很简单，将何时结束线程的问题丢给线程自身管理，在循环体中设定一个标志位，然后提供一个 break 掉循环体的标志位

### 等待(wait) & 通知(notify)

wait() 和 notify() 是 `Object` 对象中的两个方法，作用于线程中的通讯

- 通常我们使用 `synchronized` 作用于一个对象申请为其加锁。

- `wait()` 调用加锁对象的 `wait()` 释放目标对象的锁，当前线程会进入一个对象的 wait 队列，等待被唤醒时继续执行

- `notify()` 调用对象的 `notify()` 当前线程执行完毕后会随机唤醒该对象的 wait 队列中的一个，如果使用 `notifyAll()` 则会唤醒队列中所有的线程

### 挂起(suspend) & 继续执行(resume)

和 stop 方法一样，suspend 和 resume 方法已经被打上了废弃的注解，所以我们如果需要使用到这种功能还是需要在应用层面来实现。

- suspend 暂停线程的同时，并不会去释放任何锁资源

- resume 继续执行被挂起的线程

### 等待结束(join) & 谦让(yield)

- join 等待线程工作完成后继续往下执行。join(long millis) 则表示过了最大忍耐时间后继续往下执行

- yield 表示当前线程会让出 cpu 资源，但并不表示当前线程不执行了。如果你觉得一个线程不那么重要的时候，而且又害怕它会占用太多的 cpu 资源时可以调用 `yield()`，给予其他线程更多的工作机会。

### 线程组

`ThreadGroup`

### 守护线程(Daemon)

守护线程从字面上能知道他的职责是系统的守护者，在后台提供一些服务，比如垃圾回收、JIT 线程就可以理解成守护线程。与之对应的是用户线程，用户线程可以理解为系统的工作线程。当一个 Java 应用内，只有守护线程时，Java 虚拟机就会自然退出。

> t1.setDaemon(true); // 将线程设置为守护线程， 在线程 start() 之前设置为守护线程。

### 线程优先级
先做更重要的事情！

> t1.setPriority(Thread.MIN_PRIORITY); // 1 设置优先级

### 线程安全之 synchronized

`synchronized` 关键字有多种用法
- 指定加锁对象：对给定对象加锁
- 直接作用于实例方法：对当前实例加锁
- 直接作用于静态方法：相当于对当前类加锁

除了用于线程同步、确保线程安全外，`synchronized` 还可以保证线程间的可见性和有序性。换言之，被 `synchronized` 限制的多个线程是串行执行的。

### 线程安全对象与线程不安全对象

在并发编程下：

- 使用安全的 `Vector` 替代 `ArrayList`

- 使用安全的 `ConcurrentHashMap` 替代 `HashMap`


### JDK 并发包之重入锁
`java.util.concurrent.locks.ReentrantLock` 重入锁是 `synchronized`、`wait()`、`notify()` 的替代品（或者说是加强版）

重入锁的灵活性更好，显式的调用 `lock()` 和 `unlock()` 来获取锁和释放锁，可以说让代码的可读性变强了。

- 中断响应

- 锁申请等待限时

- 公平锁

- 重入锁条件 `Condition`

- 信号量 `Semaphore`

- 读写锁 `ReadWriteLock`

- 倒计时器 `CountDownLatch`

- 循环栅栏 `CyclicBarrier`

- 阻塞工具类 `LockSupport`


### 线程池
为了避免系统频繁的创建和销毁线程，我们可以让创建的线程复用。

简而言之，使用线程池之后，创建线程变成了从线程池获得空闲线程，关闭线程变成了向线程池归还。

- JDK 对线程池的支持

`ThreadPoolExecutor` 表示一个线程池，`Executors` 扮演着线程池工厂的角色
`ThreadPoolExecutor` 类实现了 `Executor` 接口，通过这个接口，任何 `Runnable` 的对象均可被 `ThreadPoolExecutor` 线程池调度。

