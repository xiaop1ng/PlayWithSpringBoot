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





