
### DBA 生存守则

- 备份重于一切

- 三思而后行 Think three before you act

- rm 是危险的

- 你来定制规范

### Oracle

Oracle Server 由两部分组成：Instance 和 Database。 Instance 是指一组后台进程/线程和一块内存共享区域；而 Database 是指存储在磁盘上的一组物理文件。


### Oracle 启动的三个状态

1. `nomount` 加载配置项、创建实例、分配内存、启动后台进程

查看数据库是否使用了配置文件 spfile
> show parameter spfile


2. `mount` Oracle 启动到 `nomount` 之后从配置参数中获取控制文件的位置信息。
缺省情况下会创建三个控制文件，这三个文件内容是一样的，是为了安全而采用的镜像手段，通常应该将三个控制文件放在不同的硬盘上。

查看数据库使用的控制文件
> show parameter control_files

3. `open` 检查控制文件中记录的数据库文件地址、日志存放地址，然后检查检查点及完整性检查。
如果不存在问题会启动数据库，如果存在不一致或文件丢失则需要进行恢复。


### SCN(System Change Number)
SCN 是指系统改变号，用以标识数据库在某个确切时刻提交的版本，可以被看着逻辑时钟。

SCN 的获取
> select dbms_flashback.get_system_change_number from dual;

### 检查点(Checkpoint)
检查点是一个数据库事件，他存在的根本意义在于减少崩溃恢复(Crash Recovery)时间


### 数据字典(Data Dictionary)
数据字典是元数据(Metadata)的存储地点。Oracle RDBMS ，数据字典包括以下内容：

- 所有数据库 Schema 对象的定义（表、视图、索引、聚簇、同义词、序列、过程、函数、包、触发器等）

- 数据库的空间分配和使用情况

- 字段的缺省值

- 完整性约束信息

- Oracle 用户名称、角色、权限等信息

- 审计信息

- 其他数据库信息

### 内部 RDBMS(X$) 表
X$表是 Oracle 的核心部分，这些表用于跟踪内部数据库信息，维持数据库的正常运行。X$表是加密命名的，而且 Oracle 不作文档说明。

### 查询字典表

> select * from v$fixed_table

### 内存管理

- SGA(System Global Area) 管理，是一块用于加载数据、对象保存运行状态和数据库控制信息的一块内存区域。在数据库实例启动时分配，当实例关闭时释放，每个实例都拥有自己的 SGA 区。

查看 SGA 信息
> select * from v$sgainfo;

查看各动态组件调整的时间和调整类型信息
> select * from v$sga_dynamic_components;

- PGA(Program Global Area) 管理，一块包含数据和控制信息的内存区域，PGA 是非共享的内存。通常来说，PGA 中包含私有 SQL 区和 session 信息等内容。

查看 PGA 使用情况
> select * from v$process;
> select * FROM v$pgastat;
> select * from v$pga_target_advice;

### 重做(Redo)和撤销(Undo)
重做(Redo)和撤销(Undo)是 Oracle 的重要特性，用以保证事务的可恢复性和可撤消性。

Oracle 通过 Redo 来保证数据库的事务可以被重演，从而使得在故障之后，数据可以被恢复。