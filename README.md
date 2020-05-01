# NACOS-DEMO

*依赖版本*
```xml
<spring-boot.version>2.2.5.RELEASE</spring-boot.version>
<nacos-config-spring-boot.version>0.2.7</nacos-config-spring-boot.version>
<nacos-discovery-spring-boot-starter>0.2.7</nacos-discovery-spring-boot-starter>
<spring-cloud-alibaba.version>2.2.1.RELEASE</spring-cloud-alibaba.version>
<spring-cloud-dependencies>Hoxton.SR4</spring-cloud-dependencies>
```

## 快速启动

直接启动每个模块中的 `Application` 就行了。（暂时云上的 nacos 是可用的，用的朋友的云）

接口测试在 项目的 http 下

## 云上 `nacos` 一共有三个配置文件

### `server-a.propertes`

```properties
### spring
spring.application.name=nacos-server-a
### nacos
nacos.discovery.server-addr=140.143.224.69:8848
nacos.discovery.register.enabled=true
nacos.discovery.auto-register=true
nacos.discovery.register.group-name=demo
nacos.discovery.register.port=${server.port}
nacos.discovery.register.service-name=${spring.application.name}
```

### `server-b.properties`

```properties
### server
server.port=8099
### spring
spring.application.name=nacos-server-b
### nacos

nacos.config.auto-refresh=true
nacos.discovery.server-addr=140.143.224.69:8848
nacos.discovery.register.enabled=true
nacos.discovery.auto-register=true
nacos.discovery.register.group-name=demo
nacos.discovery.register.port=${server.port}
nacos.discovery.register.service-name=${spring.application.name}
```

### `gateway.properties`

```properties
server.port=8677
spring.cloud.gateway.discovery.locator.enabled=true
spring.cloud.gateway.discovery.locator.lowerCaseServiceId=true
spring.cloud.nacos.discovery.server-addr=140.143.224.69:8848

spring.cloud.loadbalancer.retry.enabled=false
#设置路由id
spring.cloud.gateway.routes[0].id=nacos-server-a
spring.cloud.gateway.routes[0].uri=lb://nacos-server-a
spring.cloud.gateway.routes[0].predicates[0]=Path=/nacos-server-a/*
spring.cloud.gateway.routes[0].filters[0]=StripPrefix=1

spring.cloud.gateway.routes[1].id=nacos-server-b
spring.cloud.gateway.routes[1].uri=lb://nacos-server-b
spring.cloud.gateway.routes[1].predicates[0]=Path=/nacos-server-b/*
spring.cloud.gateway.routes[1].filters[0]=StripPrefix=1

spring.cloud.gateway.discovery.locator.lower-case-service-id=true
```