## git add

`git add` 是将修改提交到暂存区的命令

> 而我最常使用的命令也是他， `git add -A` 添加所有的文件（已有版本和为建版本的文件）到暂存区

```shell
git add .               # 添加所有文件（不包含删除）同：git add * 
git add -u              # 添加所有存在版本的文件
git add -A              # 添加所有文件（已有版本和为建版本的文件包含删除）
git reset HEAD 文件名    # 撤销添加  
```

### 添加某种类型的文件

> git add *.md

将 md 文件添加到暂存区


### 添加文件夹

> git add doc/

将 doc 文件夹下的文件都添加到暂存区

### 添加文件

> git add doc/Git_Guide.md

将 Git_Guide.md 文件添加到暂存区


## git commit 

在将修改添加到暂存区之后，接下来的操作就是提交，所以每当 git add 完之后的操作就是 git commit

> git commit -m "添加了 git_guide"

## git pull

从 git 仓库拉取最新的代码

> git pull origin master

## git push

将修改提交到 git 仓库

> git push origin master


## git tag

在软件发布时我们通常会给代码打上一个 tag, 以便回溯

> git tag v1.0

通过 `git tag` 查看我们会看到 v1.0 这个版本标记

> git tag -a v1.1 -m "一个有备注的标记"

通过 `git show` 来查看具体的标记信息

> git show v1.1

将某个标记下的修改提交到 git 仓库

> git push origin v1.1


