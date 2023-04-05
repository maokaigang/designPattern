package 单例模式;

public  class HungrySingleton {     //反射出来的实例和静态方法获取的实例不是同一个，因此要在构造方法里做修改
    static {
        System.out.println("static code block");    //初始化 反射调用 调用静态属性方法时执行
    }
    private static HungrySingleton instance = new HungrySingleton();

    public static String name = "hungrysingleton";

    private HungrySingleton(){
        if(instance != null){
            throw new RuntimeException("instance is not null");
        }
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
