# Maven

Maven 是一个项目管理工具，可以对 Java 项目进行构建、依赖管理。

> 一个更正式的 Apache Maven 的定义： Maven是一个项目管理工具，它包含了一个项目对象模型 (Project Object Model)，一组标准集合，一个项目生命周期(Project Lifecycle)，一个依赖管理系统(Dependency Management System)，和用来运行定义在生命周期阶段(phase)中插件(plugin)目标(goal)的逻辑。

Maven 提倡一个共同的标准目录结构

- /src/main/java 项目的 java 源码

- /src/main/resources 项目的资源，如配置文件

- /src/test/java 项目的测试类，比如 Junit 代码

- /src/test/resources 测试用的资源

- /src/main/webapp/WEB-INF `web`应用文件目录

- /target 打包输出目录

- /target/classes 编译输出目录

- /target/test-classed 测试编译输出目录

### Linux 安装 Maven

1. 下载和解压
```
# wget http://mirrors.hust.edu.cn/apache/maven/maven-3/3.6.0/binaries/apache-maven-3.6.0-bin.tar.gz
# tar -xvf  apache-maven-3.6.0-bin.tar.gz
# mv -f apache-maven-3.6.0 /usr/local/
```

2. 修改 /etc/profile 文件，在 `profile` 末尾添加并保存
```
export MAVEN_HOME=/usr/local/apache-maven-3.6.0
export PATH=${PATH}:${MAVEN_HOME}/bin
```

3. 让 `profile` 重新生效
```
# source /etc/profile
```

4. 验证
> mvn -v


### Maven 生命周期

Maven 有三个标准的生命周期

1. clean 项目清理的处理

2. default 项目部署的处理

3. site 项目站点文档创建的处理


- Maven 的构建阶段

    - validate 验证项目

    - compile 执行编译

    - test 测试

    - package 打包

    - verify 检查

    - install 安装打包的项目到本地仓库

    - deploy 部署拷贝最终的工程包到远程仓库中

- Maven 的 Clean 阶段

    - pre-clean 执行一些需要在 clean 之前完成的工作

    - clean 移除上一次构建生成的文件

    - post clean 执行一些需要在 clean 之后立刻完成的工作

- Maven 的 site 阶段

    - pre-site 执行生成站点文档之前完成的工作

    - site 生成项目的站点文档

    - post-site 执行生成站点文档之后完成的工作

    - site-deploy 将生成的站点文档部署到特定的服务器上


### 构建将依赖打包

```
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-dependency-plugin</artifactId>
            <version>3.0.1</version>
            <executions>
                <execution>
                    <id>copy-dependencies</id>
                    <phase>package</phase>
                    <goals>
                        <goal>copy-dependencies</goal>
                    </goals>
                    <configuration>
                        <outputDirectory>${project.build.directory}/lib</outputDirectory>
                        <overWriteReleases>false</overWriteReleases>
                        <overWriteSnapshots>false</overWriteSnapshots>
                        <overWriteIfNewer>true</overWriteIfNewer>
                    </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```




