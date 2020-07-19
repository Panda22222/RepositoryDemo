import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class JvmDemo2 {
    public static void main(String[] args) {
      /*  long maxMemory = Runtime.getRuntime().maxMemory(); //返回Java虚拟机试图使用的最大内存量 Jprofile
        long totalMemory = Runtime.getRuntime().totalMemory(); //返回Java虚拟机中内存总量
        System.out.println("MAX_MEMORY = "+maxMemory + "(字节)，" + (maxMemory/(double)1024/1024)+"MB");
        System.out.println("TOTAL_MEMORY = "+totalMemory + "(字节)，" + (totalMemory/(double)1024/1024)+"MB");*/
        My my = new My();
        FutureTask<Integer> task = new FutureTask<>(my);
        Thread thread = new Thread(task);
            try {
                thread.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("end....");

       /* String str = "Hello World";
        while (true){
            str += str + new Random().nextInt(88888888)+new Random().nextInt(999999999);
        }*/
    }
}
class My implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("success...");
        return 1024;
    }
}