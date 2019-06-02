###1.什么是SPI
SPI全称为__Service Provider Interface__，服务提供者接口，是一种把接口与实现分离的思想的实现方式，并且在JDK中就内置了这种实现方式，我们可以直接使用。

![SPI.png](https://upload-images.jianshu.io/upload_images/4190914-4f0854000e84a435.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

1、当服务提供者提供了接口的一种具体实现后，在jar包的META-INF/services目录下创建一个以"接口全限定名"为命名的文件，内容为实现类的全限定名；
2、接口实现类所在的jar包放在主程序的classpath中；
3、主程序通过java.util.ServiceLoader动态装载实现模块，它通过扫描META-INF/services目录下的配置文件找到实现类的全限定名，把类加载到JVM；
4、SPI的实现类必须携带一个不带参数的构造方法；

###2.常见应用

#####2.1 数据库Driver 


###3.代码演示

###4.SPI的不足
HSF 和dobbo 的实现

###5.结尾
类加载器是 Java 语言的一个创新。它使得动态安装和更新软件组件成为可能。
在开发自己的类加载器的时候，需要注意与已有的类加载器组织结构的协调。