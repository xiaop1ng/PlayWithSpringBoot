# Yapi

[应用网站](http://yapi.demo.qunar.com)

[说明文档](https://hellosean1025.github.io/yapi/)

# mock 响应支持

1. 正则

```
{
  "name|regexp": "[a-z0-9_]+?",
  "type|regexp": "json|text|xml"
}
```

2. 替换参数
```
{
  "name": "${query.name}", //请求的url是/path?name=xiaoming, 返回的name字段是xiaoming
  "type": "${body.type}",   //请求的requestBody type=1,返回的type字段是1

}
```

3. 内置函数

```
{
    "errcode": 0,
    "errmsg": "@word",
    "data": {
        "id": "@id", //@id 随机生成 id
        "name": "@name" //@name 随机生成用户名
    }
}
```