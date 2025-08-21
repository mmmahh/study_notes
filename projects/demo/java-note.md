# 1、SPI
> SPI: Service Provider Interface

SPI例子
- JPA标准，Hibernate是JPA的一种实现
- JDBC标准，MySql驱动程序
- 日志

## 1.1 示例
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


## 1.2 原理浅析
> 文件读取 <br>
> 类加载



# 2、Type（Java中的类型）
> java中的所有数据抽象 <br>
> 何为类型，声明一个变量/参数时该变量/参数的数据类型 <br>

引入泛型之前，Class对象可以描述所有数据类型。<br>
引入泛型之后，Class对象无法描述元素的泛型信息，引入其他类对象，用以描述类型变量、参数化类型、泛型数组、通配符类型的数据类型信息 <br>

运行时，真正有效的数据类型只有Class对象描述的数据类型，与泛型有关的数据类型信息仅在类文件定义中存在 <br>
- 类定义的类型变量 `class A<T>`
- 成员变量使用类型变量声明变量 `T data`
- 成员变量声明参数化类型 `List<T> list` `List<String> list` `List<?>` `List<? extends T>` `List<? super T>`
- 成员变量声明泛型数组 `T[] tArr` `List<T>[]` `List<String>[]`
- 函数声明或使用类型变量，或声明返回值参数化类型，或泛型数组
- 函数参数使用类型变量声明变量，或声明参数化类型，或泛型数组

> 1、通配符类型呢？可以从参数化类型中拿到`<>`中实际的类型，可以是类型变量`<T>`，或者Class类型`<String>`，或者通配符类型`<?>`等其他可能的类型 <br>
> 2、可以看到参数化类型是一个Class类型加上的泛型信息的类型 <br>
> 3、数组类型可以是类型变量或Class类型或参数化类型加上`[]`的类型 <br>
> 4、类型变量只能声明在特定地方，在作用域内，可以用类型变量声明数据类型 <br>

> 所有这些类型信息的获取都从Class对象开始入手

## 2.1 Type
`Type` 接口是java所有类型的父接口 <br>
其子接口有：
- TypeVariable<D>
- ParameterizedType
- GenericArrayType
- WildcardType

一个实现类：
- Class

## 2.2 Class
在引入泛型之前，只有Class类型，所有的数据类型都可用Class对象描述
- 基本类型，如int、double、boolean等（void也算作基本类型）
- 引用类型
  - Object，及其子类
    - 数组，如int[]、Integer[]
    - 类，所有通过`class`关键字定义的（enum和record也是特殊的类），如Object、String以及用户自定义的类
  - 接口，`interface`关键字定义的
  - 注解，`@interface`关键字定义的
  - null（特殊）

> void也有Class对象描述。`void.class.isPrimitive()`返回`true`

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

### Class类方法
```java
/**
 * Class对象用于在java运行时表示类、接口（注解也是一种接口）、基本数据类型
 * 
 */
public final class Class<T> implements java.io.Serializable,
                              GenericDeclaration,
                              Type,
                              AnnotatedElement,
                              TypeDescriptor.OfField<Class<?>>,
                              Constable {
  
  public native boolean isInstance(Object obj);

  /**
   * 当前Class表示的类对象是否可以引用cls表示的类对象
   * 
   */
  public native boolean isAssignableFrom(Class<?> cls);


  public native boolean isInterface();
  public native boolean isArray();
  public native boolean isPrimitive();
  // 如果是注解返回true，同时它也是一个接口
  public boolean isAnnotation();
  // 
  public boolean isSynthetic();

  
  public ClassLoader getClassLoader();


  public Module getModule();

  
  public TypeVariable<Class<T>>[] getTypeParameters();
    
}
```

#### GenericDeclaration
> 所有能声明类型变量（VariableType）的元素的公共接口。以下元素可以声明类型变量：
> - Class
> - Constructor
> - Method
> - Executable (Constructor和Method的父类)

#### AnnotatedElement
>

## 2.3 TypeVariable 类型变量
> 引入泛型之后，java扩展了类型表示 <br>
> Class对象无法描述：
> - 泛型参数 `<T>`
> - 参数化类型 `List<String>`
> - 泛型数组 `T[]` `List<String>[]`
> - 通配符 `<?>` `<? extends>` `<? super>`
> 
> 需要其他对象来描述这些类型

TypeVariable用于表示类型参数，如`class List<T>`中的`T`是一个类型参数

```java
public interface TypeVariable<D extends GenericDeclaration> extends Type, AnnotatedElement {
    // 返回类型参数的上界，泛型参数可以声明为<T extends Number & Serializable>
    Type[] getBounds();

    // 返回声明这个泛型参数的泛型声明
    // Class 声明在类上
    // Method 声明在方法上
    // Constructor 声明在构造函数上
    D getGenericDeclaration();

    // 返回类型参数名，如 <T> 返回字符串"T"
    String getName();

    // 获取声明在上界的注解类型
    AnnotatedType[] getAnnotatedBounds();
}
```

### 示例

### 补充内容
#### 注解相关

##### AnnotatedElement 接口
> 所有实现了这个接口的“元素”都是可以“被注解的元素”，（可以是Class，Method，Field，Constructor，Package等）

##### AnnotatedType

## 2.4 ParameterizedType

参数化类型，如`List<String>`

```java
public interface ParameterizedType extends Type {
    // 返回实际的参数类型
    Type[] getActualTypeArguments();

    // 返回声明了这个类型的class或interface
    Type getRawType();

    
    Type getOwnerType();
}
```

### 示例

# Class.getResource