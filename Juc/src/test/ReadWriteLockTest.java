import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static void main(String[] args) {
        Cache cache = new Cache();
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

class Cache{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println("读取数据,key:   "+key);
            TimeUnit.SECONDS.sleep(1);
            Object value = map.get(key);
            System.out.println("读取成功,value: "+value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println("写入数据...key: "+key+" ,value: "+value);
            TimeUnit.SECONDS.sleep(1);
            map.put(key, value);
            System.out.println("写入成功...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}