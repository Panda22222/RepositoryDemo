public class CarDemo1 {
    public static void main(String[] args) {

    }
}
class Car implements CarAction{
    private boolean isOver = false; //是否超过停车线
    private Signal signal;

    @Override
    public void checkSignal() {

    }

    @Override
    public void checkDirection() {

    }
}
//信号灯枚举类
enum Signal{
    RED,YELLOW,GREEN;
}

interface CarAction{
    void checkSignal();
    void checkDirection();
}

