package com.atguigu.juc;

public class LambdaExpressDemo {

    public static void main(String[] args) {
        Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("sayHello...");
            }
        };
        foo.sayHello();
    }

}

interface Foo{
    public void sayHello();
}
