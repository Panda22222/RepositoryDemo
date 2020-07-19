public class Woman implements People {
    @Override
    public int sleep(String name) {
        System.out.println("go to sleep..." + name);
        return 1024;
    }
}
