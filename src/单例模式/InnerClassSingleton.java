package 单例模式;

public class InnerClassSingleton {
    static {
        System.out.println("static code block");    //单例模式.InnerClassSingleton.name调用
    }
    public static String name = "InnerClass";
    private static class SingletonHoloder{  //延迟加载，只有在调用getInstance时才会初始化
        static {
            System.out.println("SingletonHoloder");     //单例模式.InnerClassSingleton.name不调用
        }
        private static InnerClassSingleton instance = new InnerClassSingleton();

    }
    private InnerClassSingleton(){}

    public static InnerClassSingleton getInstance(){
        return SingletonHoloder.instance;
    }
}
