# JWT( JSON WEB TOKENS)

<https://jwt.io/> 

### 结构

> eyJhbGciOiJIUzEiLCJ0eXAiOiJKV1QifQ.eyJ1c2VySWQiOjI1Njk0LCJyb2xlSWQiOjAsInVzZXJuYW1lIjoic3R1NCIsImV4cCI6MTU2MzM1MTUzNS40Mjh9.bG9naWptQ2d5Ni9kckhWeXhaSWtwc2hmOFRjPQ

它是一个很长的字符串，中间用点（`.`）分割成三部分：

- Header（头部）
- Payload（负载）
- Signature（签名）

也就是

> Header.Payload.Signature

#### Header 部分

Header 部分是一个 JSON 对象，用来描述 JWT 的元数据

```json
{
  "alg": "HS256",
  "typ": "JWT"
}
```

`alg` 描述签名的算法，默认是 HMAC SHA256（写成 HS256），`typ` 描述令牌的类型；最后会将该 JSON 进行 Base64URL 算法转成字符串



#### Payload 部分

Payload 部分也是一个 JSON 对象进行 Base64URL 转换，用于存放实际需要传递的数据。

JWT 规定了一些字段供选用：

```
iss (issuer)：签发人
exp (expiration time)：过期时间
sub (subject)：主题
aud (audience)：受众
nbf (Not Before)：生效时间
iat (Issued At)：签发时间
jti (JWT ID)：编号
```

我们也可以将我们需要传递的信息（如：user_id 等用于标识用户的信息）放到这个 JSON 当中。

#### Signature 部分

首先，需要指定一个密钥（secret）,这个密钥只有服务器才知道（privateKey）。

这个私钥用来计算签名，使用 Header 中指定的算法（默认 HMAC SHA256 ）来产生签名。

```
String signature = HMACSHA256(
  base64UrlEncode(header) + "." +
  base64UrlEncode(payload),
  secret);
```



