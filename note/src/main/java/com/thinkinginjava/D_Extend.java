package com.thinkinginjava;

import org.junit.Test;

class A{
    public A(){
        System.out.println("AAAAA构造函数执行");
    }
}
class B{
    public B(){
        System.out.println("BBBBBB构造函数执行");
    }
}
class C extends A{
    B b = new B();
    public C(){
        System.out.println("cccccccccc");
    }
}

class Component1 {
    public Component1() { System.out.println("Component1"); }
}
class Component2 {
    public Component2() { System.out.println("Component2"); }
}
class Component3 {
    public Component3() { System.out.println("Component3"); }
}
class Root {
    Component1 c1 = new Component1();
    Component2 c2 = new Component2();
    Component3 c3 = new Component3();
    public Root() { System.out.println("Root"); }
}
class Stem extends Root {
    Component1 c1 = new Component1();
    Component2 c2 = new Component2();
    Component3 c3 = new Component3();
    public Stem() { System.out.println("Stem"); }
}

public class D_Extend {
    @Test
    public void t(){
        new C();
/**
 执行结果如下：
 AAAAA构造函数执行
 BBBBBB构造函数执行

 结论：
 1、创建子类会调用父类构造器，仅执行super，此时构造本类的构造函数还没执行完。
 2、父类也会调用祖先类的构造器，仅执行super，此时构造本类的构造函数还没执行完。
 3、父祖先类的成员变量先初始化
 4、成员变量初始化完成后，继续执行构造器中除super外的代码

 5、由此也可以引申出，虽然构造函数先执行，但仅仅运行super就暂停了，成员变量先初始化完成
 */
    }

    @Test
    public void t2(){
        new Stem();
    }
}
























class Super {
    public int field = 0;
    private void privateFn1(){
        System.out.println("父类私有方法");
    }
    protected void protectedFn1(){
        System.out.println("父类protected方法");
    }
    public int getField() { return field; }
}

class Sub extends Super {
    public int field = 1;
    private void privateFn1(){
        System.out.println("子类私有方法");
    }
    protected void protectedFn1(){
        System.out.println("子类protected方法");
    }
    public int getField() { return field; }
    public int getSuperField() { return super.field; }
}

class FieldAccess {
    public static void main(String[] args) {
        Super sup = new Sub(); // Upcast
        sup.protectedFn1();
        //System.out.println("sup.field = " + sup.field +
        //    ", sup.getField() = " + sup.getField());
        //Sub sub = new Sub();
        //System.out.println("sub.field = " +
        //    sub.field + ", sub.getField() = " +
        //    sub.getField() +
        //    ", sub.getSuperField() = " +
        //    sub.getSuperField());
    }
}
