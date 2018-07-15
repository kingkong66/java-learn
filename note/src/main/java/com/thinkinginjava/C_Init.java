package com.thinkinginjava;

import com.commonsjar.beanutils.User;
import org.junit.Test;

public class C_Init{
    public void up(int i){
        System.out.println(i);
    }
    @Test
    public void te(){
        //形参是int类型，实参是byte类型，实参类型会自动提升
        up((byte)2);
        //形参是int类型，实参是long类型，报错，需执行窄化转换
        //up((long)2);
    }

    public static void s1(){
        //up();
        User user = new User();
        user.setId("static方法内部不可以调用本类的非static方法，但可以调用其他对象的非static方法");
    }

    @Test
    public void te1(){
        int[] a = new int[]{1,2};
    }

    @Test
    public void tec(){
        C_Sub s = new C_Sub();
        s.say();
    }
}











class Bean{
    char c;

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }
}

class C_Init2{
    public static void main(String[] args){
        //char c = ' ';
        Bean bean = new Bean();
        System.out.println("***"+bean.getC()+"***");
        System.out.println(' ' == bean.getC());
    }
}







class C_Init3{

    public static void test1(int i, String... strings){
        System.out.println(i);
        System.out.println(strings.length);
    }

    public static void main(String[] args){
        test1(1);
        test1(1, "a");
    }
}














