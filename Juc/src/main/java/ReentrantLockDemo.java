import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        new Thread(()->{
            try {
                cellPhone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            try {
                cellPhone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t3 = new Thread(cellPhone);
        Thread t4 = new Thread(cellPhone);
        t3.start();
        t4.start();
    }
}
class CellPhone implements Runnable{
    public synchronized void sendSMS()throws Exception{
        System.out.println(Thread.currentThread().getId()+"\t invoked sendSMS");
        sendEmail();
    }

    public synchronized void sendEmail()throws Exception{
        System.out.println(Thread.currentThread().getId()+"\t invoked sendEmail");
    }

    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        get();
    }

    public void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId()+"\t invoked get");
            set();
        } finally {
            lock.unlock();
        }
    }

    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId()+"\t invoked set");
        } finally {
            lock.unlock();
        }
    }
}