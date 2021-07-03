package com.reflect;


public class ReflectDemo01 {
    /*
    获取class对象的三种方式：
    1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象（对应第一阶段，Source源代码阶段）
    2. 类名.class：通过类名的属性class获取（对应第二阶段，Class类对象阶段）
    3. 对象.getClass()：getClass()方法在Object对象中定义着（对应第三阶段，Runtime运行时阶段）
     */
    public static void main(String[] args) throws Exception {
        //1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象（对应第一阶段，Source源代码阶段）
        Class cla1 = Class.forName("com.reflect.Person");
        System.out.println(cla1);

        //2. 类名.class：通过类名的属性class获取（对应第二阶段，Class类对象阶段）
        Class cla2 = Person.class;
        System.out.println(cla2);

        //3. 对象.getClass()：getClass()方法在Object对象中定义着（对应第三阶段，Runtime运行时阶段）
        Person p = new Person("Chocolate",24);
        Class cla3 = p.getClass();
        System.out.println(cla3);

        //结论：同一个字节码文件（*.class）在一次程序运行过程中，只会被加载一次。即无论通过哪一种方式获取的class对象都是同一个
        System.out.println(cla1==cla2);//true
        System.out.println(cla1==cla3);//true

    }
}
