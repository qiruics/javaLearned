# java内部类

#### 内部类（当作类中的一个普通成员变量，只不过此成员变量是class的类型）

1. 一个java文件中可以包含多个class，但是只能有一个public class。
2. 如果一个类定义在另一个类的内部，此时可以称之为内部类。

```java
public class InnerClassDemo {
    //内部类
    class InnerClassTest{
        public void test(){
            System.out.println("test");
        }
    }

}
```

如何调用：

```java
InnerClassDemo.InnerClass inner = new InnerClassDemo().new InnerClass();
inner.test();
```

#### 特点：

1. 内部类可以方便的访问外部类的私有属性

```java
public class InnerClassDemo {

    private int id;
    private String name;

    //内部类的用处
    class InnerClassTest{
        private int age;
        public void test(){
            System.out.println("test" + "print " + name);
        }
    }
}
```

2. 外部类不能访问内部类的私有属性。

​		  但是如果创建了内部类的对象，此时可以在外部类中访问私有属性。

```java
public class InnerClassDemo {

    private int id;
    private String name;
    public void show(){
        System.out.println("show");
        new InnerClassTest().test();
        InnerClassTest innerClassTest = new InnerClassTest();
        System.out.println("内部类私有属性 age：" + innerClassTest.age);

    }
    //内部类的用处
    class InnerClassTest{
        private int age;
        public void test(){
            System.out.println("test" + "print " + name);
        }

    }
}
```

3. 内部类中不能定义静态属性 static String name = "Jack";

4. 当内部类和外部类具有相同的私有属性的时候，在内部类中访问的时候，可以直接访问内部类的属性，
           如果需要访问外部类的属性，那么需要添加 外部类类名.this.属性。

```java
InnerClassDemo.this.age
```

为什么不能直接用==InnerClassDemo.age==？类名.属性，属性必须是静态类。

如果主方法main在外部类内部，则可以省略外部类InnerClassDemo

```java
InnerClassTest inner = new InnerClassDemo().new InnerClassTest();
//InnerClassDemo.InnerClassTest inner = new InnerClassDemo().new InnerClassTest();
```

#### 分类：

1. ==匿名内部类==：当定义了一个类，实现了某个接口的时候，在使用过程中==只需要使用一次，没有其他用途==，此时考虑到代码编写的简洁，可以考虑不创建具体的类，而采用new interface(){添加未实现的方法} 就叫做匿名内部类

   ```java
   new Thread(
     new Runnable() {
       @Override
       public void run() {
   
       }
    }
   );
   ```

2. 静态内部类：在内部类中可以定义静态内部类，使用static关键字进行修饰，使用规则: 外部类.内部类 类的引用名称 = new 外部类.内部类（）；

   ```java
   static class InnerClass{
           private String name;
           public void show(){
               System.out.println("show");
           }
   
       }
   
   InnerClassDemo.InnerClass innerStatic = new InnerClassDemo.InnerClass();
   //静态属于当前类
   //InnerClassDemo.InnerClassTest inner = new InnerClassDemo().new InnerClassTest();
   ```

3. 方法内部类：在外部类的方法中也可以定义类，此时叫做方法内部类（了解即可）

   使用的时候需要注意，==只能在方法中创建对象，因为此class的作用域就是当前方法==



