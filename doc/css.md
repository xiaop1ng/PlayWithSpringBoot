# CSS

CSS（Cascading Style Sheets），即层叠样式表，或这级联样式表。

### CSS 的几种类型
- 内联样式表

即写在某个标签内的样式，在标签内编写的样式能影响的范围最小。
> `<div style="display: block;">Block</div>`

- 内部样式表

写在文件内部的 style 标签
> `<style type="text/css">...</style>`

- 外部样式表

使用外部链接引入的样式文件

> `<link rel="stylesheet" type="text/css" href="xxx.min.css" />`

### 选择符
- 类型选择符（Type Selectors）是以文档中的对象名作为选择符名。

> `a {text-decoration:none;}　/*无下划线*/`

- 类选择符使用文档中 `class` 属性值作为选择符名。
> `.classname {color: red;}`

- ID 选择符使用文档中 `id` 属性值作为选择符名。
> `#idname {font-weight: bold;}`

- 包含选择符为一个特定的结构创建样式
> `p a {text-decoration: line-through;} /*贯穿线*/`

- 选择符分组为一组特定的节点创建样式
> `h1, h2, h3, h4, h5, h6 {text-decoration: underline;} /*下划线*/`

- 通用选择符 `*`

- 子选择符为其子节点（不能跨级作用）创建样式
> `div > b {font-style: italic; /*斜体*/}`

- 相邻选择符为相邻的两个兄弟节点创建样式
> `div + span {overfolw: hidden; /*将超出元素框之外的内容剪裁掉*/}`

- 属性选择符为包含特定属性的节点创建样式
> `p[align="center"] {font-size: 24px;}`

### 伪类（pseudo-class）和伪元素（pseudo-element）
伪类指某个元素的某个状态，如超链接存在四个状态（未被点击，鼠标经过，鼠标点击、已访问过）。
伪元素指某个对象中某个元素的状态，如一行文字中的第一个字符等。

```
a:visited {...} /*已被访问*/
a:active {...} /*点击*/
a:hover {...} /*鼠标经过*/
a:link {...} /*未被访问*/

p:first-letter {font-size: 200%;} /*首字*/
div:first-line {text-decoration: underline;} /*首行*/
```
上面的冒号（`:`）就是伪类和伪元素的标记符

### CSS 优先级
在 css 中拥有如此之多的选择符，也就意味着很有可能一个节点被多个选择符匹配到，在CSS中为每种不同类型的样式选择符都有一个特殊性（specificity），特殊性使用相对权重（weight）（也就是优先级）来描述不同的样式选择符。CSS可以根据产生冲突的样式选择符的权重来判断使用哪种样式，通常是选择权重大的样式而忽略权重小的样式。
- 类型选择符（E）的权重为：0001。
- 类选择符（.classname）的权重为：0010。
- ID选择符（#idname）的权重为：0100。
- 通用选择符（*）的权重为：0000。
- 子选择符的权重为：0000。
- 属性选择符（[attr]）的权重为：0010。
- 伪类选择符（:pseudo-classes）的权重为：0010。
- 伪元素（:pseudo-elements）的权重为：0001。
- 包含选择符：包含的选择符权重值之和。
- 内联样式的权重为：1000。
- 继承的样式的权重为：0000。
以上权重由大到小依次是：1000、0100、0010、0001、0000。

### 文字样式
- 文字大小 `font-size`
- 设置粗体 `font-weight`
- 颜色 `color`
- 阴影效果 `text-shadow`
- 大小写转换 `text-transform`
- 文本缩进 `text-indent`
- 垂直对齐 `vertical-align`
- 文本流入方向 `direction`
- 文本修饰（下划线等）`text-decoration`
- 空格处理方式 `white-space`
- 字内换行 `word-break`
- 行高 `line-height`

![](https://ww1.sinaimg.cn/large/005YhI8igy1fv5cl4suecj30ow0bv74q)
- 字间距 `letter-spacing`
- 词间距 `word-spacing`

### 背景与边距
- 背景颜色 `background-color`
- 背景图 `background-image`
> `background-image:url(pic03.jpg)`

- 背景图滚动/固定 `background-attachment: scroll|fixed|inherit`
- 平铺方式 `background-repeat`
- 图像定位 `background-position`
- 边框样式 `border-style`
- 边框宽度 `border-width`
- 边框颜色 `border-color`
- 内边距 `margin`
- 外边距 `padding`

### 表格
- 合并表格边框 `border-collapse`
- 表格边框间距 `border-spacing`
- 表格标题位置 `caption-side`
- 表格布局样式 `table-layout`

### 列表
- 列表样式 `list-style-type`
- 使用图标作为列表样式 `list-style-image`
- 列表符号显示位置 `list-style-position`
- 列表综合样式 `list-style`

### 滚动条
- 滚动条颜色 `scrollbar-face-color`
- 滚动条边框颜色 `scrollbar-highlight-color`
- 暗边框颜色 `scrollbar-shadow-color`

### 块级元素和内联元素
块级元素生成的是一个矩形框，并且和相邻的块级元素依次竖直排列，不会排在同一行。
内联元素的显示特点就是像文本一样的显示，各个元素之间横向排列，到最右端自动换行，不会独自占据一行。

### `<div>` 元素与 `<span>` 元素
`<div>` 是一个标准的块级元素， `<span>` 是一个内联元素。他们均作为容器标记可以容纳各种 `html` 元素。

### 定位方式
`position : static | relative | absolute| inherit`
- static 静态定位
- relative 相对定位
- absolute 绝对定位
- inherit 继承父级

### 层叠次序
`z-index` 拥有更高堆叠顺序的元素总是会处于堆叠顺序较低的元素的前面

### 浮动
通常在一个网页文档里，文档流都是从上到下、由左而右流动的。对于内联元素而言，创建了一个元素之后，会在其右接着创建其他元素；对于块级元素而言，在创建了一个元素之后，会在其下方接着创建其他元素。CSS中的浮动可以让某些元素脱离这种文档流的方式。

> `float : left | right | none`
- left 左浮动
- right 右浮动
- none 不浮动（缺省值）

### 清除浮动
> `clear : none | left | right | both`

### 溢出内容与剪切
> `overflow : visible | hidden | scroll | auto | inherit`

### 垂直方向的溢出内容
> `overflow-y: visible / auto / hidden / scroll`

### 内容的剪切
> `clip : auto | rect ( 上右下左 ) | inherit`

### 对象显示与隐藏
> `visibility : visible | hidden | collapse`


