import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception{
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " - - >没有返回值");
        });
        completableFuture.get();

        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " - - >有返回值");
            int i = 10/0;
            return 1024;
        });
        //BiConsumer两个参数:  t:返回值  u:异常
        integerCompletableFuture.whenComplete((t,u)->{
            System.out.println("--------->"+t);
            System.out.println("--------->"+u);
        }).exceptionally(f->{
            System.out.println("exeption:   "+f.getMessage());
            return 4444;
        }).get();
    }
}
