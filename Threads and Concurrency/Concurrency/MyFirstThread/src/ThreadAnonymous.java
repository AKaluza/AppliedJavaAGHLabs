import java.util.Arrays;

public class ThreadAnonymous extends Thread {

    public static void main(String[] args) throws InterruptedException {
        int[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        ThreadAnonymous thread = new ThreadAnonymous(){
            public void run(){
                int sum = Arrays.stream(a1).sum();
                System.out.println("Thread Anonymous Work. The sum is: "+ sum);
            }
        };

        thread.start();
        thread.join();
    }
}
