import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，
 * 读取共享资源应该可以同时进行，但是如果有一个线程去写共享资源，
 * 就不应该再有其他线程可以对该资源进行读或写
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache cache = new MyCache();
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                final int tempInt = 1;
                cache.put(tempInt+"",tempInt+"");
            },String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                final int tempInt = 1;
                cache.get(tempInt+"");
            },String.valueOf(i)).start();
        }
    }
}
class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t写入数据:    key="+key);
            TimeUnit.SECONDS.sleep(2);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t写入完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t读取数据");
            TimeUnit.SECONDS.sleep(2);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t读取完成:    value="+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }
}
