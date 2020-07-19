import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo4 {
    @Test
    public void test1(){
        String abc = null;
        try {
            if (abc.equals(null)) {
                System.out.println("1");
            }
            abc = "abc";
            if (abc == "abc") {
                System.out.println("2");
            }

        }catch (Exception e){
            System.out.println("3");
            e.printStackTrace();
        }finally {
            System.out.println("4");
        }
        System.out.println("5");
    }

    @Test
    public void test2(){
        DynamicProxy proxy = new DynamicProxy();
        People woman = new Woman();
        People people = (People) proxy.create(woman);
        int i = people.sleep("Panda");
        System.out.println("-->"+i);
    }

    @Test
    public void test3(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add(null);
        list.forEach(s->System.out.println(s));
    }

    @Test
    public void test04(){
        long maxMemory = Runtime.getRuntime().maxMemory(); //返回Java虚拟机试图使用的最大内存量
        long totalMemory = Runtime.getRuntime().totalMemory(); //返回Java虚拟机中内存总量
        System.out.println("MAX_MEMORY = "+maxMemory + "(字节)，" + (maxMemory/(double)1024/1024)+"MB");
        System.out.println("TOTAL_MEMORY = "+totalMemory + "(字节)，" + (totalMemory/(double)1024/1024)+"MB");
    }
}
