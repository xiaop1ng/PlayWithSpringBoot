# 小游戏

#### 文件结构

- game.js 小游戏入口文件
- game.json 配置文件

#### 小游戏的 wx API

运行环境没有 BOM 和 DOM API，只有 wx API 来完成交互功能

#### 创建 Canvas
```
var canvas = wx.createCanvas()
```

这个 Canvas 与屏幕等宽等高

#### 全局对象 GameGlobal
window 对象是浏览器的全局变量，小游戏的运行环境没有 BOM API， 因此没有 window
对象，但是提供了 GameGlobal 对象。

> 注：小游戏的运行环境在 iOS 上是 JavaScriptCore，在 Android 上是 V8

