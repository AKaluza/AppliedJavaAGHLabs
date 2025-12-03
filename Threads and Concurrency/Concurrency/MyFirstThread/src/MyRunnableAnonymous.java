import java.util.Arrays;

public class MyRunnableAnonymous {


    public static void main(String[] args) throws InterruptedException {
        int[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Thread thread = new Thread(new Runnable() {
            public void run() {
                int sum = Arrays.stream(a1).sum();
                System.out.println("Runnable Anonymous Work. The sum is: " + sum);
            }
        });
        thread.start();
        thread.join();

    }

}
