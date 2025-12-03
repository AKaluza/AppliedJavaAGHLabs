import java.util.Arrays;

public class MyRunnable implements Runnable {
    int[] array;
    MyRunnable(int[] a){
        this.array = a;
    }

    public void run(){
        int sum = Arrays.stream(this.array).sum();
        System.out.println("Runnable implementation Work. The sum is: "+ sum);
    }

    public static void main(String[] args) throws InterruptedException {
        int[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Thread thread = new Thread(new MyRunnable(a1));
        thread.start();
        thread.join();

    }
}
