# Map旅游地图网

基于 SpringBoot3 + SpringCloudAlibaba2022 + Gradle 的微服务开发脚手架，整合了 SpringSecurity 并引入 JWT 设计 RBAC
动态权限系统、Nacos 做注册中心 ，Dubbo 作物服务间通信组件，GateWay 做网关采用 JPA + QueryDSL 操作 Mysql 数据库，后台运用
Redis 做缓存，Redisson 进行数据锁，ElasticSearch 作为搜索引擎，Swagger 3做 Api 文档工具

```text
map
├─map-auth-server -- 授权服务
├─map-common -- 通用服务
│─map-gateway -- 网关服务
│─map-review -- 评论服务
│─map-scenic-spot -- 景点服务
│─map-todo -- 待办事项服务
│─map-trip -- 旅游记录服务
```

- auth-server 模块：提供用户和菜单相关权限的安全校验
- common 模块：通用模块引入 ThrealLocal 和实现 Spring 的过滤器保存用户的相关信息，减少各服务中的数据交换和调用，将服务间通信的Dubbo 相关接口放在 common 模块中
- gateway模块: 作为系统的网关模块，统一处理跨域问题
- review模块: 评论模块，引入 elasticsearch 保证搜索的接口效率
- scenic-spot模块: 景点相关服务，记录景点相关信息
- todo 模块：待进行的旅游记录，引入 Redisson 将用户 id和 todoId 作为资源进行锁操作，防止信息修改时出现问题，通过延迟队列实现计划旅游的相关功能
- trip模块: 旅游记录模块，记录用户的旅游记录



前端基于 Geeker-Admin ，采用 Vue3 + Pinia+ Router + ElementUI + TS