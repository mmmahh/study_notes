# SPI
> SPI: Service Provider Interface

SPI例子
- JPA标准，Hibernate是JPA的一种实现
- JDBC标准，MySql驱动程序
- 日志

## 示例
### 接口定义方（标准定义）
定义接口，客户端直接依赖该接口
```java
public interface SpiService {
    void doSomething();
}
```

工厂方法，获取实例
```java
public class SpiServiceFactory {
    
    public static SpiService getSpiService() {
        ServiceLoader<SpiService> serviceLoader = ServiceLoader.load(SpiService.class);
        for (SpiService spiService : serviceLoader) {
            return spiService;
        }
        throw new RuntimeException("No SpiService found");
    }
}
```

### 接口实现方（标准实现）
引用接口定义方，实现接口
```java
public class SpiServiceImpl implements SpiService {
    
    @Override
    public void doSomething() {
        System.out.println("spi impl doSomething");
    }
}
```

同时在`resources`下新增文件`META-INF/services/org.example.spi.SpiService` 文件名为接口类全名，文件内容如下，即该接口实现类全名
```text
org.example.spi.impl.SpiServiceImpl
```

### 调用方（客户端）
引用接口定义，同时需要引用接口实现，即可实现调用 <br>
客户端在代码层面只依赖接口定义，不依赖具体实现。运行时才会依赖具体实现，且可以轻松更换实现。
```java
public class SpiClient {

    public static void main(String[] args) {
        SpiService spiService = SpiServiceFactory.getSpiService();
        spiService.doSomething();
    }
}
```

### 小结
1、核心：接口定义方不仅定义了接口，也提供了方法根据 `ServiceLoader` 获取该接口的实例 <br>
2、实现类除了需要实现接口，同时需要添加位于`META-INF/services`目录下的文件。从该文件信息可得知：文件名是接口全类名，文件内容是接口实现类的全类名。 <br>
3、调用方接口实现自己的逻辑


## 原理浅析
> 文件读取 <br>
> 类加载



# Type（Java中的类型）
> java中的所有数据抽象

## Type
`Type` 接口是java所有类型的父接口 <br>
其子接口有：
- TypeVariable<D>
- ParameterizedType
- GenericArrayType
- WildcardType

一个实现类：
- Class

## Class
在引入泛型之前，只有Class类型
- 基本类型，如int、double、boolean等
- 引用类型
  - Object，及其子类
    - 数组，如int[]、Integer[]
    - 类，所有通过`class`关键字定义的（enum和record也是特殊的类），如Object、String以及用户自定义的类
  - 接口，`interface`关键字定义的
  - 注解，`@interface`关键字定义的
  - null

> 1、`int.class` != `Integer.class` <br>
> 2、`int[].class` != `Integer[].class` <br>
> 3、数组都继承`Object` <br>
> 4、用户定义`enum`类型继承`Enum`类，`Enum`继承`Object` <br>
> 5、`Record`类为Java 14+正式引入 <br>
> 6、接口不继承`Object`，但可以引用`class`类型 <br>
> 7、注解不继承`Object` <br>
> 8、`Class`本身也是一个类，继承Object <br>

### 数组
数组类型可以存在类似于继承的关系
```java
// 如下赋值没问题
Object[] arr = new Integer[0];

// 如下赋值有问题
List<Object> list = new List<Integer>();
```

## TypeVariable 类型变量
> 引入泛型之后，java扩展了类型表示

TODO


# Class.getResource