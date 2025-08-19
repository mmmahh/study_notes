# SPI

# SpringBoot

## 自定义 `starter`

### starter 一般包含的内容
> 也可以用一个项目包含所有内容 <br>
> 一般starter不会包含springboot启动类，只有最终端项目存在启动类

1、自动配置 <br>
2、基础设施代码（你的项目功能主要代码） <br>
3、starter，用户只需要依赖该starter就能轻松开始使用 <br>

#### 自动配置
META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports <br>
该文件列出配置类，spring会读取：
```text
org.example.acme.spring.boot.AcmeAutoConfiguration
```

> 自动配置应该仅在META-INF/spring/%s.imports文件中时才能被加载 <br>
> 确保自动配置类应该在特定包中，并且永远不是组件扫描的目标 <br>
> 自动配置不应启动组件扫描查找其他组件，应该使用特定 @Import 注解

#### @AutoConfiguration

#### @Import

#### @ConfigurationProperties

#### @Conditional


## springboot启动相关

## URL


