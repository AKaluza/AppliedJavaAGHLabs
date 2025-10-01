public class ForSample {
   public static void main(String[] args) {
      int i;
      boolean done = false;
      i = 0;
      for( ; !done; ) {
         System.out.println("i is " + i);
         if(i == 3)
            done = true;
         i++;
      }
      int[] nums = { 1, 2, 3, 4 };
      int sum = 0;
      // use for-each style for to display and sum the values
      for(int x : nums) {
         System.out.println("Value is: " + x);
         sum += x;
      }
      System.out.println("Summation: " + sum);
   }
}