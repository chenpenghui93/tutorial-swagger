# tutorial-swagger

1.引入依赖  
```
<dependency>  
     <groupId>io.springfox</groupId>  
     <artifactId>springfox-swagger2</artifactId>  
     <version>2.9.2</version>  
 </dependency>  
 <dependency>  
     <groupId>io.springfox</groupId>  
     <artifactId>springfox-swagger-ui</artifactId>  
     <version>2.8.0</version>  
 </dependency> 
```
 
2.创建配置类  
  ```
  @Configuration  
  @EnableSwagger2  
  @EnableSwaggerBootstrapUI  
  public class SwaggerAutoConfiguration {
      @Bean
      public Docket createRestApi() {
          return new Docket(DocumentationType.SWAGGER_2)
                  .apiInfo(apiInfo())
                  .select()
                  .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                  .paths(PathSelectors.any())
                  .build();
      }  
      private ApiInfo apiInfo() {
          return new ApiInfoBuilder()
                  .title("swagger测试接口文档title")
                  .description("swagger测试接口文档description")
                  .termsOfServiceUrl("http://localhost:8080/hello")
                  .version("1.0")
                  .build();
      }
  }
```
  
3.启动应用，访问`http://localhost:8080/swagger-ui.html`  

4.注解说明  
- @Api： 用于类，标识这个类是swagger的资源
- @ApiIgnore： 用于类，忽略该 Controller，指不对当前类做扫描
- @ApiOperation： 用于方法，描述 Controller类中的 method接口
- @ApiParam： 用于参数，单个参数描述，与 @ApiImplicitParam不同的是，他是写在参数左侧的。如（ @ApiParam(name="username",value="用户名")Stringusername）
- @ApiModel： 用于类，表示对类进行说明，用于参数用实体类接收
- @ApiProperty：用于方法，字段，表示对model属性的说明或者数据操作更改
- @ApiImplicitParam： 用于方法，表示单独的请求参数
- @ApiImplicitParams： 用于方法，包含多个 @ApiImplicitParam
- @ApiResponse： 用于方法，描述单个出参信息
- @ApiResponses： 用于方法，包含多个@ApiResponse
- @ApiError： 用于方法，接口错误所返回的信息

5.扩展UI  
5.1 引入依赖  
  ```
  <dependency>  
     <groupId>com.github.xiaoymin</groupId>  
     <artifactId>swagger-bootstrap-ui</artifactId>  
     <version>1.8.7</version>  
  </dependency> 
  ```
5.2 配置类上增加注解`@EnableSwaggerBootstrapUI`  
5.3 启动应用，访问 `http://localhost:8080/doc.html`

