package question1;

public final class Singleton implements Cloneable{
    private static volatile Singleton instance = null;
    private Singleton() {
    }
    
    //Double checked locking code on Singleton to make it thread safe
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
