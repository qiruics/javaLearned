package com.company.InnerDemo;

public class InnerClassDemo {

    private int id;
    private String name;
    private int age = 24;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("show");
        new InnerClassTest().test();
        InnerClassTest innerClassTest = new InnerClassTest();
        System.out.println("内部类私有属性 age：" + innerClassTest.age);

    }
    //内部类的用处
    class InnerClassTest{
        private int age = 12;
        public void test(){
            System.out.println("test" + "print " + name);
            System.out.println("test" + "print " + InnerClassDemo.this.age);
        }

    }
    static class InnerClass{
        private String name;
        public void show(){
            System.out.println("show");
        }

    }

    public static void main(String[] args) {
        InnerClassTest inner = new InnerClassDemo().new InnerClassTest();
    }

}

