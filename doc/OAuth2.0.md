# OAuth

开放授权（OAuth）是一个开放标准，允许用户让第三方应用访问该用户在某一网站上的私密的资源，而无需将用户名和密码提供给第三方应用。

OAuth 允许用户提供一个 Token，而不是用户名和密码来访问他们存放在特定服务提供者的数据。每一个令牌授权一个特定的网站（例如，视频编辑网站)在特定的时段（例如，接下来的 2 小时内）内访问特定的资源（例如仅仅是某一相册中的视频）。  

> OAuth 引入了一个授权层，用来分离两种不同的角色：客户端和资源所有者。......资源所有者同意以后，资源服务器可以向客户端颁发令牌。客户端通过令牌，去请求数据。
>
> 这段话的意思就是，**OAuth 的核心就是向第三方应用颁发令牌。**



### OAuth 2.0 规定了四种获得令牌的流程 

- 授权码（authorization-code）
- 隐藏式（implicit）
- 密码式（password）：
- 客户端凭证（client credentials）



> 注意：不管是哪一种授权方式，第三方应用需要提前在系统中备案获取：客户端 ID（Client ID）和密钥（Client Secret）

Web 应用中最常见的是授权码（authorization-code）这种方式，安全性也最高



# ref

- <http://www.ruanyifeng.com/blog/2019/04/oauth-grant-types.html> 
- <https://oauth.net/2/> 
