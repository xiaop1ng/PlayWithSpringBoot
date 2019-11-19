# VuePress

一个极简静态文档网站生成器。

[VuePress](https://vuepress.vuejs.org/zh/guide/)

```
# 安装
yarn global add vuepress # 或者：npm install -g vuepress

# 新建一个 markdown 文件
echo '# Hello VuePress!' > README.md

# 开始写作，会将 md 解析成 html
vuepress dev .

# 构建静态文件
vuepress build .
```


### 结合 netlify 和 GitHub 托管静态文档

[netlift](https://www.netlify.com/)

在使用 vuepress 生成好静态网站之后提交到 GitHub 之后，使用 netlify 关联仓库之后，netlify 会将静态网站解析到一个地址下。

然后就可以愉悦的看到页面的效果了。


在 Netlify 中, 创建一个新的 GitHub 项目，使用以下设置：
Build Command: npm run build:docs 或者 yarn build:docs
Publish directory: docs/.vuepress/dist
点击 deploy 按钮！

## 添加插件

> npm i @vuepress/plugin-blog