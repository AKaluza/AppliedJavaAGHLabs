import java.util.Arrays;

public class ThreadSubclass extends Thread {
    int[] array;
    ThreadSubclass(int[] a){
        this.array = a;
    }
    public void run(){
        int sum = Arrays.stream(this.array).sum();
        System.out.println("Thread Subclass Work. The sum is: "+ sum);
    }

    public static void main(String[] args) throws InterruptedException {
        int[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ThreadSubclass thread = new ThreadSubclass(a1);
        thread.start();
        thread.join();
    }

}