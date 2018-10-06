# spring-cloud-in-action
重拾spring-cloud
>思考：
#### 1.如何将不同语言的实现的服务注册到服务注册中心？
##### 1.1 客户端发现
- 各个服务可以自己实现一套eureka的注册客户端

##### 1.2 服务端发现
- 可以利用其他的代理客户端进行注册如`nginx`和`zookeeper`
