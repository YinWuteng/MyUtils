package yinwuteng.com.myutils.utils;

/**
 * Create By yinwuteng
 * 2018/10/9.
 * 单利模式
 */
public class Singleton {

    /**
     * 饿汉式
     */

//    private static Singleton instance = new
//            Singleton();
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        return instance;
//    }

    /**
     * 懒汉式，线程不安全
     */

//    private static Singleton instance;
//    private Singleton(){}
//    public static Singleton getInstance(){
//        if (instance==null){
//            instance=new Singleton();
//        }
//        return instance;
//    }

    /**
     * 静态内部类单利模式(推荐使用)
     */
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        return SingletonHolder.instance;
//    }
//
//    //静态内部类
//    private static class SingletonHolder {
//        private static final Singleton
//                instance = new Singleton();
//    }
}
