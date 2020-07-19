import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目:三个销售员 卖出  30张票
 *
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        final Ticket ticket = new Ticket();

        new Thread(()->{for (int i = 1;i<=40;i++) ticket.sale();},"A").start();
        new Thread(()->{for (int i = 1;i<=40;i++) ticket.sale();},"B").start();
        new Thread(()->{for (int i = 1;i<=40;i++) ticket.sale();},"C").start();
    }
}

//资源类 = 实例变量+实例方法
class Ticket{
    private int number = 30;
    Lock lock = new ReentrantLock();

    public void sale(){
       lock.lock();
        try {
            if (number>0) {
                System.out.println(Thread.currentThread().getName()+"\t卖出第: "+(number--)+"\t 还剩下:   "+number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}