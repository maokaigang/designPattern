package 单例模式;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class LazySingleton implements Serializable {
    private volatile static LazySingleton instance;

    private LazySingleton(){

    }
    public  static LazySingleton getInstance(){
        if(instance == null){
            synchronized (LazySingleton.class){         //多个线程可能会同时来到这一步
                if(instance == null){
                    instance =  new LazySingleton();    //双重加锁
                }
            }
        }
        return instance;
    }
    Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
}
