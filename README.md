# NACOS-DEMO

> `spring-boot` `nacos`     
>  nacos-config-spring-boot.version      0.2.7      
>  nacos-discovery-spring-boot-starter   0.2.7      

## 快速启动

 本地启动一个 `nacos` 服务, 端口用默认配置就行. 需要更换端口或IP,自行修改配置文件中的IP地址.
 默认地址为 `127.0.0.1:8848`

* server-a 启动两份
* server-b 启动一份

## 测试

* 调用接口 `GET http://localhost:8092/server/b/a`

通过服务B去远程调用服务A的 `server/a/test` 接口