
### nginx 让 http 重定向到 https

location /
{
    proxy_redirect http:// https://;
}