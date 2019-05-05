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

JDK通过 Proxy 的静态方法 newProxyInstance 动态地创建代理
### 行为型模式分为类行为型模式和对象行为型模式两种：

类行为型模式： 类的行为型模式使用继承关系在几个类之间分配行为，类行为型模式主要通过多态等方式来分配父类与子类的职责。
对象行为型模式： 对象的行为型模式则使用对象的聚合关联关系来分配行为，对象行为型模式主要是通过对象关联等方式来分配两个或多个类的职责。根据“合成复用原则”，系统中要尽量使用关联关系来取代继承关系，因此大部分行为型设计模式都属于对象行为型设计模式。

职责链模式：
Java设计模式之责任链模式、职责链模式
责任链模式实现的三种方式
       
       命令模式： https://design-patterns.readthedocs.io/zh_CN/latest/behavioral_patterns/command.html 在软件设计中，我们经常需要向某些对象发送请求，但是并不知道请求的接收者是谁，也不知道被请求的操作是哪个，我们只需在程序运行时指定具体的请求接收者即可，此时，可以使用命令模式来进行设计，使得请求发送者与请求接收者消除彼此之间的耦合，让对象之间的调用关系更加灵活。命令模式可以对发送者和接收者完全解耦，发送者与接收者之间没有直接引用关系，发送请求的对象只需要知道如何发送请求，而不必知道如何完成请求。这就是命令模式的模式动机。
解释器模式： https://design-patterns.readthedocs.io/zh_CN/latest/behavioral_patterns/mediator.html

迭代器模式：

中介者模式：

备忘录模式：

观察者模式： https://design-patterns.readthedocs.io/zh_CN/latest/behavioral_patterns/observer.html

状态模式：https://design-patterns.readthedocs.io/zh_CN/latest/behavioral_patterns/state.html

策略模式：https://design-patterns.readthedocs.io/zh_CN/latest/behavioral_patterns/strategy.html

策略模式作为设计原则中开闭原则最典型的体现，也是经常使用的。下面这篇博客介绍了策略模式一般的组成部分和概念，并用了一个小demo去说明了策略模式的应用。
https://blog.csdn.net/zlj1217/article/details/81230077
    java设计模式之策略模式

    模板方法模式：
    访问者模式：
