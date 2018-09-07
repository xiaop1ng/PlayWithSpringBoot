# Node.js

### linux(Ubuntu) 安装新版的 node

Step 1: 安装 `nvm`
> curl -o- https://raw.githubusercontent.com/creationix/nvm/v0.29.0/install.sh | bash

查看 `nvm` 版本
> nvm --version

Strp 2: 安装 `node`
> nvm ls-remote

安装一个特定版本的 `node`
> nvm install v8.2.1

查看 `node` 版本
> node --version

### 后台运行 node 程序
1. `nohup` 命令

> nohup node bin/www.js &

kill node 程序

查看进程号
> ps -ef

kill 对应程序

> kill -9 `进程号`

2. forever

3. pm2