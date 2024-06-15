# SSM框架的Web脚手架

一、工具及版本

| 工具          | 版本   |
| ------------- | ------ |
| JDK           | 17     |
| IntelliJ IDEA | 2023   |
| MySQL         | 5.7    |
| Tomcat        | 10.1.7 |
| Maven         | 3.8.8  |

------

二、项目结构

```
SSM-scaffold
    ├── src        --  核心代码
        ├── main        --  代码及资源
            ├── java     	--  启动模块
            	├── cc     	
            		├── zzzooo     	
            			├── advice     		--  aop的通知代码
            			├── controller     	--  控制层代码
            			├── mapper     		--  持久层代码
            			├── pointcut     	--  aop的切点代码
            			├── pojo     		--  实体类
            			├── service     	--  业务层代码
            				├── impl     	--  业务层实现代码
            ├── resource    --  配置资源以及映射文件
            	├── mappers     		--  持久层映射文件所在目录
            	├── spring     			--  spring框架相关配置文件
            	├── jdbc.properties     --  数据库连接信息
            	├── logback.xml     	--  日志相关配置文件
            	├── mybatis-config.xml  --  mybatis框架核心配置文件
            ├── webapp      --  Web相关文件
        ├── test     --  测试代码文件目录
        	├── java        --  测试代码
    ├── README.md   --  介绍文档
    └── pom.xml     --  maven配置和管理项目依赖文件
```
------
### 1. 什么是SSM整合？

**本质**: Spring接管一切(将框架核心组件交给Spring进行IoC管理),代码更加简洁。

- SpringMVC管理web相关组件
- Spring管理业务层、持久层、以及数据库相关(DataSource,MyBatis)的组件
- SSM整合最终就是编写IoC配置文件

SpringMVC: 扫描组件、视图解析器、mvc的注解驱动、DefaultServlet处理静态资源、拦截器、文件上传解析器

Spring: 扫描组件、其他框架整合

SpringMVC       Spring

controller  -->  service  -->  mapper
### 2. SSM技术栈总结

#### 2.1 Spring框架技术点总结

- 控制反转（IoC，Inversion of Control）和依赖注入（DI，Dependency Injection）
- Spring AOP（Aspect-Oriented Programming）面向切面编程
- Spring TX声明式事务实现

#### 2.2 Spring MVC 框架技术点总结

- 简化参数接收

  接收param / json / 文件 / 原生api / 共享域

- 简化数据响应

  响应 页面 / 转发和重定向 / json / 文件

#### 2.3 MyBatis框架技术点总结

- 映射文件及 SQL 语句编写
- MyBatis 动态 SQL
- MyBatis 多表映射
- MyBatis 逆向工程

### 3. SSM技术栈所有注解总结

- ioc/di注解: 

  `@Autowired`: 自动装配 Bean，可用于构造方法、属性和方法上，配合 `@Qualifier` 使用实现按名称注入。

  `@Qualifier`: 指定需要注入的 Bean 的名称，通常和 `@Autowired` 一起使用。

  `@Resource`: 和 `@Autowired` 类似，可以实现按名称注入，不过是 JSR-250 规范的注解。

  `@Value`: 注入 properties 文件中的属性值，还可以注入 SpEL 表达式的值。

  `@Component`: 通用的组件注解，通常用于标记 Spring 管理的 Bean。

  `@Controller`: 标记 Spring MVC 控制器，也是 `@Component` 的一种。

  `@Service`: 标记 Service 层组件，也是 `@Component` 的一种。

  `@Repository`: 标记数据访问层组件，是 `@Component` 的一种。

- aop注解: 

  `@Aspect`: 声明一个切面类。

  `@Pointcut`: 定义切入点表达式。

  `@Before`: 前置通知，在目标方法执行之前执行。

  `@AfterReturning`: 后置通知，在目标方法执行之后执行，返回结果时执行。

  `@AfterThrowing`: 异常通知，在目标方法抛出异常时执行。

  `@After`: 最终通知，在目标方法执行之后执行，无论是否发生异常都执行。

  `@Around`: 环绕通知，在目标方法执行前后执行，可以控制目标方法的执行。

- tx注解: 

  `@Transactional`: 声明一个事务方法，可以配置事务的属性，如传播行为、隔离级别、超时时间等。
 
- 控制器相关

  `@Controller`: 用于定义控制器类；

  `@RestController`: 与 `@Controller` 类似，但返回值都会被转换为 JSON 格式；

  `@RequestMapping`: 用于定义请求 URI 与控制器方法的映射关系；

  `@CrossOrigin`: 用于标注在 Controller 类或处理请求的方法上，表示允许跨域请求；

- 接收参数相关

  `@RequestParam`: 用于获取请求参数的值；

  `@RequestBody`: 用于获取 POST 请求的请求体（Request Body）；

  `@RequestHeader`: 用于获取请求头信息；

  `@CookieValue`: 用于获取 Cookie 中的值。

  `@PathVariable`: 用于获取 URI 中的参数值；

- 响应数据相关

  `@ResponseBody`: 用于将 Controller 中方法返回的对象转换成指定格式（通常是 JSON 或 XML）的对象，并将其作为响应正文返回；

- 校验注解相关

  `@Validate`: 用于开启对象的数据校验；

  `@NotNull`: 用于检验是否为 null；

  `@NotBlank`: 用于检验是否为 null 或空字符串；

  `@Size`: 用于检验字符串、数组、集合的长度范围；

  `@Min`: 用于检验数字的最小值；

  `@Max`: 用于检验数字的最大值；

  `@DecimalMin`: 用于检验 BigDecimal 和 BigInteger 的最小值；

  `@DecimalMax`: 用于检验 BigDecimal 和 BigInteger 的最大值；

  `@Pattern`: 用于检验正则表达式。

- mybatis

  `@param`: 接口方法的参数为一个或多个字面量类型,使用该注解
