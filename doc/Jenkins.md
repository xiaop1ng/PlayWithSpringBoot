# JENKINS GUIDE

### Jenkins 是啥？
Jenkins 是一个开源的自动化服务器，可用于自动执行与构建，测试，交付或部署软件相关的各种任务。

### 安装
1. 下载 http://mirrors.jenkins.io/war-stable/latest/jenkins.war
2. 运行 `java -jar jenkins.war --httpPort=8080`
3. 浏览器打开 http://localhost:8080/ 根据引导视图完成安装

### 创建管道

`Pipeline` 用于“作为代码”对简单到复杂的交付管道进行建模。Jenkins管道的定义通常写入文本文件（称为a Jenkinsfile），然后将其检入项目的源代码控制存储库。

