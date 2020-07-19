import pojo.User;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StreamDemo {
    /**
     * 场景:查询偶数ID且年龄大于24且用户名转为大写且用户名字母倒叙排序
     * 只输出一个用户名
     * @param args
     */
    public static void main(String[] args) {
        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);

        List<User> users = Arrays.asList(u1, u2, u3, u4, u5);
        users.stream().filter(user -> user.getId() % 2 == 0)
                      .filter(user -> user.getAge() > 24)
                      .map(user -> user.getName().toUpperCase())
                      .sorted((o1,o2)->{return o2.compareTo(o1);})
                      .limit(1)
                      .forEach(System.out::println);


    }

    private static void FunctionInterface() {
        Function<String,Integer> function = s ->{return s.length();};
        System.out.println("Function:   "+function.apply("aaa"));

        Predicate<String> predicate = s->{return s.isEmpty();};
        boolean test = predicate.test("aa");
        System.out.println("Predicate:  "+test);

        Consumer<String> consumer = s -> { System.out.println("Consumer:    "+s);};
        consumer.accept("sss");

        Supplier<String> supplier = () -> {return "Jerry";};
        System.out.println("Supplier:   "+supplier.get());
    }
}
