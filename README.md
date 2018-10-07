# spring-cloud-in-action
重拾spring-cloud
>思考：
#### 1.如何将不同语言的实现的服务注册到服务注册中心？
##### 1.1 客户端发现
- 各个服务可以自己实现一套eureka的注册客户端

##### 1.2 服务端发现
- 可以利用其他的代理客户端进行注册如`nginx`和`zookeeper`
#### 2. 服务之间的通信
##### 2.1 直接使用RestTemplate
- 直接使用restTemplate 写死url
```java
@RestController
public class MyClass {

    @GetMapping("/getProductMsg")
    public String doOtherStuff() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8081/msg", String.class);
    }
}
```
##### 2.2 注入LoadBalancerClient
- 通过LoadBalancerClient获得url的信息`host`和`port`
```java
@RestController
public class MyClass {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    
    @GetMapping("/getProductMsg")
    public String doOtherStuff() {
       // 调用
       RestTemplate restTemplate = new RestTemplate();
       ServiceInstance productInstance = loadBalancerClient.choose("PRODUCT");
       // 拼接url
       String url = String.format("http://%s:%s", productInstance.getHost(), productInstance.getPort() + "/msg");
       return restTemplate.getForObject("http://localhost:8081/msg", String.class);
    }
}
```
##### 2.3 通过配置RestTemplate和注解@LoadBalanced
- 简单，官方推荐
```java
@Configuration
public class MyConfiguration {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
@RestController
public class MyClass {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getProductMsg")
    public String doOtherStuff() {
        String results = restTemplate.getForObject("http://PRODUCT/msg", String.class);
        return results;
    }
}
```