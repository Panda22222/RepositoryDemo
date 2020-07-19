import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    public static void main(String[] args) {
        PrinfThread thread = new PrinfThread();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                thread.pringA();
            }
        },"T1").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                thread.pringB();
            }
        },"T2").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                thread.pringC();
            }
        },"T3").start();
    }
}
class PrinfThread{
    private int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void pringA(){
        lock.lock();
        try {
            while (num != 1){
                c1.await();
            }
            System.out.print("a");
            num = 2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void pringB(){
        lock.lock();
        try {
            while (num != 2){
                c2.await();
            }
            System.out.print("b");
            num = 3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void pringC(){
        lock.lock();
        try {
            while (num != 3){
                c3.await();
            }
            System.out.print("c ");
            num = 1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
