import java.util.Arrays;

public class LambdaImplementationOfRunnable {
    public static void main(String[] args) throws InterruptedException {
        int[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] a2 = {10, 10, 10, 10, 10, 10, 10, 10};
        int[] a3 = {3, 4, 3, 4, 3, 4, 2, 1, 3, 7};

        ThreadSubclass thread = new ThreadSubclass(a1);
        thread.start();


        Runnable task1 = () -> {
            int sum = Arrays.stream(a1).sum();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("1. The sum is: " + sum);

        };

        Runnable task2 = () -> {
            int sum = Arrays.stream(a2).sum();
            System.out.println("2. The sum is: " + sum);
        };

        Runnable task3 = () -> {
            int sum = Arrays.stream(a3).sum();
            System.out.println("3. The sum is: " + sum);
        };

        Thread myFirstTask = new Thread(task1);
        Thread mySecondTask = new Thread(task2);
        Thread myThirdTask = new Thread(task3);

        myFirstTask.start();
        mySecondTask.start();
        myThirdTask.start();

        myFirstTask.join();
        mySecondTask.join();
        myThirdTask.join();

        System.out.println("Next part of code.....");
    }
}
