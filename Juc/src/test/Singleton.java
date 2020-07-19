public class Singleton {
    private static Singleton singletonDemo = null;
    private Singleton(){

    }
    private static class InnerClass{
        private static final InnerClass inner = new InnerClass();
    }
    public InnerClass getInner(){
        return InnerClass.inner;
    }

    public static void main(String[] args) {
        InnerClass inner = InnerClass.inner;
        InnerClass inner1 = InnerClass.inner;
        System.out.println(inner == inner1);
    }
}
