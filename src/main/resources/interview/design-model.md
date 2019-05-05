https://design-patterns.readthedocs.io/zh_CN/latest/index.html

## 设计模式类型  创建型模式  结构型模式  行为型模式
### 常见创建型模式详解

单例模式

工厂模式

建造者模式

原型模式

### 常见结构型模式详解

适配器模式

桥接模式 

组合模式 

装饰模式： java模式—装饰者模式（https://www.cnblogs.com/chenxing818/p/4705919.html）、Java设计模式-装饰者模式（https://blog.csdn.net/cauchyweierstrass/article/details/48240147#）

外观模式：  

享元模式： 

代理模式：代理模式原理及实例讲解 （IBM出品，很不错）(https://www.ibm.com/developerworks/cn/java/j-lo-proxy-pattern/index.html)


生成动态代理类的方法很多，如，JDK 自带的动态处理、CGLIB、Javassist 或者 ASM 库。JDK 的动态代理使用简单，它内置在 JDK 中，因此不需要引入第三方 Jar 包，但相对功能比较弱。CGLIB 和 Javassist 都是高级的字节码生成库，总体性能比 JDK 自带的动态代理好，而且功能十分强大。ASM 是低级的字节码生成工具，使用 ASM 已经近乎于在使用 Java bytecode 编程，对开发人员要求最高，当然，也是性能最好的一种动态代理生成工具。但 ASM 的使用很繁琐，而且性能也没有数量级的提升，与 CGLIB 等高级字节码生成工具相比，ASM 程序的维护性较差，如果不是在对性能有苛刻要求的场合，还是推荐 CGLIB 或者 Javassist。
