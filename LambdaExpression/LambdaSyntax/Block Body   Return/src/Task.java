import java.util.function.Function;

public class Task {
    //put your task here
    /* TODO: implement Function<String,String> greeter
        with a block body that trims and returns "Hello, <name>!" */
    Function<String, String> greeter = name -> {
        String trimmed = name.trim();
        return "Hello, " + trimmed + "!";
    };

    public static void main(String[] args) {
        // Uncomment after implementing:
        Task task = new Task();
        System.out.println(task.greeter.apply("  Alice  "));
    }
}