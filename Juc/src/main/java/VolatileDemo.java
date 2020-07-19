import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo {
    public static void main(String[] args) throws InterruptedException {

    }

    private static void NoAtomic() {
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.getIncrement();
                }
            },String.valueOf(i)).start();
        }

        //等待20个线程计算完成后，再用main取得最终结果值
        //Thread.activeCount() > 2 解释:后台存在两个线程:main线程与gc线程
        while (Thread.activeCount() > 2) {
            //yield:线程让步。顾名思义，就是说当一个线程使用了这个方法之后，它就会把自己CPU执行的时间让掉，
            //让自己或者其它的线程运行，注意是让自己或者其他线程运行，并不是单纯的让给其他线程。
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t finally number value:   "+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t finally number value:   "+myData.atomicInteger);
    }

    /**
     * 验证volatile可见性
     */
    private static void SeeByVolatile() {
        MyData myData = new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
                myData.addTo60();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"\t number updata to 60");
        },"AAA").start();

        while (myData.number == 0) {

        }
        System.out.println(Thread.currentThread().getName()+"\t over..."+myData.number);
    }


}
class MyData{
    AtomicInteger atomicInteger = new AtomicInteger();

    volatile int number = 0;

    public void addTo60(){
        this.number = 60;
    }

    //number++底层被拆分成三个指令:
    //执行getfield拿到原始number、执行iadd进行加1操作、执行putfield写把累加后的值写回
    public void addPlusPlus(){
        number++;
    }

    public void getIncrement(){
        atomicInteger.getAndIncrement();
    }

}
