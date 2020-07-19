/**
 * 函数式编程
 */
public class LambdaExpressDemo2 {
    public static void main(String[] args) {
        Foo foo = (x,y) -> {return x+y;};
        System.out.println(foo.add(2,3));
        System.out.println(foo.mul(2,3));
        System.out.println(Foo.div(4,2));
    }
}

@FunctionalInterface
interface Foo{
    public int add(int x,int y);
    public default int mul(int x,int y){
        return x*y;
    }
    public static int div(int x,int y){
        return x/y;
    }
}