## 命令（API）
- values

`incr` 加加操作， key 不存在时会先设置 key 为 0 再加加操作

`incrby` 加指定值，key 不存在时会先设置 key 为 0 再增加指定值

`decr` 减减操作，key 不存在时会先设置 key 为 0 再减减操作

`decrby` 减指定值，key 不存在时会先设置 key 为 0 再减去指定值

`append` 为 key 的值追加字符串，返回得到字符串的长度

`strlen` 获取 key 的值的长度

- hash

`hset` 设置 hash field 为指定值，key 不存在时会先创建

`hsetnx` 设置 hash field 为指定值，如果 field 已存在返回 0，nx 是 not exist 的意思

`hmset` 同时设置 hash 的多个 field

`hget` 获取指定 hash field

`hmget` 同时获取 hash 的多个 field

`hincrby` 为 hash 的 field 加指定值

`hexist` 测试 hash 是否存在 field

`hlen` 获取 hash 中 field 的数量

`hdel` 删除 hash 的 field

`hkeys` 获取 hash 中所有的 field

`hvals` 获取 hash 中所有的值

`hgetall` 获取 hash 中所有的键值对信息

- list

`lpush` 在链表左边推进一个元素

`rpush` 在链表右边推进一个元素

`linsert` 在链表某个元素之前或之后插入一个元素 `linsert mlist before "world" "hello "`

`lset` 设置 list 中指定下标的元素值（下标从 0 开始） `lset mlist 0 "first"`

`lrem` 从 list 中删除 count 个相同的值，当 count > 0 时，从头到尾的顺序删除；当 count < 0 时，从尾到头的顺序删除 `lrem mlist 1 "first"`

`ltrim` 保留指定 list 索引（下标）范围内的数据 `ltrim mlist 1 -1`

`lpop` 在链表左边弹出一个元素，返回被弹出的值

`rpop` 在链表右边弹出一个元素，返回被弹出值

`rpoplpush` 在第一个链表右边弹出一个元素推进到第二个链表中 `rpoplpush mlist mlistbak`

`lindex` 返回链表中 index 位置的元素

`llen` 返回链表的长度

- set

`sadd` 添加元素到集合

`srem` 在集合中移除元素

`spop` 随机弹出并移除一个元素

`sdiff` 找出集合1 和集合2 的差集（查找出集合1 中有而集合2 中没有的元素）`sdiff mset1 mset2`

`sdiffstore` 返回一个集合1 和集合2 的差集的集合 `sdiff retset mset1 mset2`

`sinter` 找出给定集合的交集

`sinterstore` 返回给定集合的交集的集合

`sunion` 找出给定集合的并集

`sunionstore` 返回给定集合的并集的集合

`smove` 指定元素从集合1 中移动到集合2 中 `smove mset1 mset2 fromset1`

`scard` 返回集合的元素个数

`sismember` 判断是否为集合的元素 `sismember mset1 fromset1`

`srandmember` 随机返回一个集合的元素

- zset

`zadd`

`zrem`

`zincrby`

`zrank` 返回一个元素的排名

`zrevrank`

`zrevrange`

`zrangebyscore`

`zcount`

`zcard`

`zscore`

`zremrangebyrank`

`zremrangebyscore`

- 非特定数据结构的命令

`keys` 返回满足给定 pattern 的所有 key `keys *`

`exists` 判断一个 key 是否存在

`del` 删除一个 key

`expire` 为一个 key 设置过期时间（单位： 秒）

`move` 将当前数据库中的 key 转移到其他数据库

`persist` 移除一个被设置过期时间的 key 的状态（即变为 normal 状态）

`randomkey` 随机返回一个 key

`rename` 重命名一个 key

`type` 返回一个 key 的类型

`ping`

`echo` 输出

`select` 选择数据库，数据库编号为 0~15

`quit` 退出连接

`dbsize` 返回当前数据库中 key 的数目

`info` 服务器信息

`monitor` 实时转储收到的请求

`config get` 获取服务器配置信息

`flushdb` 删除当前数据库中所有的 key

`flushall` 删除所有数据库中所有的 key

