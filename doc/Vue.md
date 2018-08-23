# Vue CLI

`CLI` 提供了终端里的 vue 命令。它可以通过 `vue create` 快速创建一个新项目的脚手架，或者直接通过 `vue serve` 构建新想法的原型。你也可以通过 `vue ui` 通过一套图形化界面管理你的所有项目。

### 安装
> npm install -g @vue/cli

### 使用
> vue create hello-world

### 快速原型开发
可以使用 `vue serve` 和 `vue build` 命令对单个 `*.vue` 文件进行快速原型开发,只不过他需要一个额外的全局扩展
> npm install -g @vue/cli-service-global

### mustache 语法无法作用在 html 的属性上
Mustache 语法不能作用在 HTML 特性上，遇到这种情况应该使用 v-bind 指令

### v:bind 和 v-on 的缩写
```
<!-- 完整语法 -->
<a v-bind:href="url">...</a>

<!-- 缩写 -->
<a :href="url">...</a>
```

```
<!-- 完整语法 -->
<a v-on:click="doSomething">...</a>

<!-- 缩写 -->
<a @click="doSomething">...</a>
```

### mustache 使用函数
> {{ sayHello() }}

### 侦听器
Vue 中使用 `watch` 来响应数据的变化

### 数组语法
```
<div v-bind:class="[activeClass, errorClass]"></div>

data: {
  activeClass: 'active',
  errorClass: 'text-danger'
}
```

### v-show 与 v-if
`v-if` 是“真正”的条件渲染，因为它会确保在切换过程中条件块内的事件监听器和子组件适当地被销毁和重建。

`v-if` 也是惰性的：如果在初始渲染时条件为假，则什么也不做——直到条件第一次变为真时，才会开始渲染条件块。

相比之下，`v-show` 就简单得多——不管初始条件是什么，元素总是会被渲染，并且只是简单地基于 CSS 进行切换。

一般来说，`v-if` 有更高的切换开销，而 `v-show` 有更高的初始渲染开销。因此，如果需要非常频繁地切换，则使用 `v-show` 较好；如果在运行时条件很少改变，则使用 `v-if` 较好。

### 通过 prop 向子组件传递数据
