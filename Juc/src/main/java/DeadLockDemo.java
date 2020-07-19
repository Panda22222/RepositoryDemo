import java.util.concurrent.TimeUnit;

public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLocktThread(lockA,lockB),"t1").start();
        new Thread(new HoldLocktThread(lockB,lockA), "t2").start();
    }
}

class HoldLocktThread implements Runnable{

    private String lockA;
    private String lockB;

    public HoldLocktThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t自己持有锁:"+lockA+"\t尝试获得："+lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t自己持有锁:"+lockB+"\t尝试获得："+lockA);
            }
        }

    }
}