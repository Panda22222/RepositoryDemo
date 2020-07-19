import pojo.Person;

public class TestTransferValue {
    public static void main(String[] args) {
        TestTransferValue testTransferValue = new TestTransferValue();
        int age = 20;
        testTransferValue.changeValue(age);
        System.out.println("age---->"+age); //20

        Person person = new Person("abc");
        testTransferValue.changeValue2(person);
        System.out.println("person---->"+person.getPersonName()); //xxx

        String str = "abc";
        testTransferValue.changeValue3(str);
        System.out.println("str---->"+str); //abc
    }

    public void changeValue(int age){
        age = 30;
    }
    public void changeValue2(Person person){
        person.setPersonName("xxx");
    }
    public void changeValue3(String str){
        str = "xxx";
    }
}
