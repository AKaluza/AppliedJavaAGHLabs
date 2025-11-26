import java.util.function.Function;

public class Task {
    //put your task here
    Function<String, String> toUsername = s ->
            s.trim().toLowerCase().replace(" ", "_");

    public static void main(String[] args) {
        Task task = new Task();
        // Uncomment after implementing:
        // System.out.println(task.toUsername.apply("  Alice Smith  ")); // alice_smith
    }
}