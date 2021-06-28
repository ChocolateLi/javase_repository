package com.IO.Serializable;

import java.io.*;

public class ObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //序列化对象
        //demo01();
        //反序列化对象
        demo02();
    }

    private static void demo02() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\test\\object.txt"));
        Object obj = ois.readObject();
        System.out.println(obj);
    }

    private static void demo01() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\test\\object.txt"));
        oos.writeObject(new Person("陈力",24));
        oos.flush();
        oos.close();
    }
}
