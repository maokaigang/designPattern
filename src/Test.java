import 单例模式.LazySingleton;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        Class<单例模式.HungrySingleton> hungrySingletonClass = 单例模式.HungrySingleton.class;
        System.out.println(单例模式.HungrySingleton.name);

        System.out.println(单例模式.InnerClassSingleton.getInstance());
        单例模式.EnumSingleton enumSingleton = 单例模式.EnumSingleton.INSTANCE;
        enumSingleton.print();
        
        /*
            序列化、反序列化后存在多例，添加
            Object readResolve() throws ObjectStreamException {
                return getInstance();
            }
         */
        LazySingleton lazySingleton = LazySingleton.getInstance();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("testSerial"));
            objectOutputStream.writeObject(lazySingleton);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("testSerial"));
            LazySingleton instance = (LazySingleton) objectInputStream.readObject();
            System.out.println(lazySingleton == instance);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
