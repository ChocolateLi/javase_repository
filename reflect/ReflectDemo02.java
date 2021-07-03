package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo02 {

    public static void main(String[] args) throws Exception {
        //获取成员变量
        //demo01();

        //获取构造方法
        //demo02();

        //获取成员方法
        demo03();
    }

    private static void demo03() throws Exception {
        /*
         * Method[]  getMethods()：获取所有public修饰的成员方法
         * Method getMethod(String name, 类<?>... parameterTypes)：获取指定的public修饰的成员方法
         * Method[]  getDeclaredMethods()：获取所有的成员方法。不考虑修饰符
         * Method getDeclaredMethod(String name, 类<?>... parameterTypes)：获取指定的成员方法
         */
        Class cla = Class.forName("com.reflect.Person");
        //Method[]  getMethods()：获取所有public修饰的成员方法
        Method[] methods = cla.getMethods();
        for (Method m:methods){
            System.out.println(m);
        }
        System.out.println("==============================");
        //Method getMethod(String name, 类<?>... parameterTypes)：获取指定的public修饰的成员方法
        Person p = new Person();
        Method eat = cla.getMethod("eat");
        Method eat1 = cla.getMethod("eat", String.class);
        System.out.println(eat);
        System.out.println(eat1);
        //执行方法
        eat.invoke(p);
        eat1.invoke(p,"饭");
        System.out.println("============================");
        //获取方法名
        System.out.println(eat.getName());
        System.out.println("============================");
        //获取类名
        System.out.println(cla.getName());

    }

    private static void demo02() throws Exception {
        /*
           * Constructor<?>[] getConstructors()：获取所有public修饰的构造方法
           * Constructor<T> getConstructor(类<?>... parameterTypes)：获取指定的public修饰的构造方法
           * Constructor<?>[] getDeclaredConstructors()：获取所有的构造方法。不考虑修饰符
           * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)：获取指定的构造方法
         */
        Class cla = Class.forName("com.reflect.Person");
        Constructor[] constructors = cla.getConstructors();
        for (Constructor c:constructors){
            System.out.println(c);
        }
        System.out.println("==========================");
        //获取指定的构造器
        Constructor cons = cla.getConstructor(String.class,int.class);
        System.out.println(cons);
        System.out.println("============================");
        //由构造器创建对象
        //创建对象：T   newInstance(Object... initargs)
        Object obj = cons.newInstance("科比", 24);
        System.out.println(obj);
        System.out.println("==========================");
        //如果使用空参构造方法创建对象，操作可以简化：Class对象的newInstance方法
        Object obj2 = cla.newInstance();
        System.out.println(obj2);
    }

    private static void demo01() throws Exception {
        /*
         * Field[]  getFields()：获取所有public修饰的成员变量
         * Field  getField(Stringname)：获取指定的public修饰的成员变量
         * Field[]  getDeclaredFields()：获取所有的成员变量。不考虑修饰符
         * Field  getDeclaredField(String name)：获取指定的成员变量
         */
        Class cla = Class.forName("com.reflect.Person");
        //getFields()：获取所有public修饰的成员变量
        Field[] f1 = cla.getFields();
        for (Field f:f1){
            System.out.println(f);
        }
        System.out.println("===========================");
        //getDeclaredFields()：获取所有的成员变量。不考虑修饰符
        Field[] f2 = cla.getDeclaredFields();
        for (Field f:f2){
            System.out.println(f);
        }
        System.out.println("===============================");
        //getField(Stringname)：获取指定的public修饰的成员变量
        //获取某个成员变量，并对其进行赋值
        /*
        Field：成员变量
            * 设置值：void 	set(Object obj, Object value)
            * 获取值：Object    get(Object obj)
            * 忽略访问权限修饰的安全检查：setAccessible(true)
         */
        Person p = new Person();
        Field a = cla.getField("a");
        a.set(p,"我是a");
        Object o = a.get(p);
        System.out.println(o);
        System.out.println(p);


    }
}
