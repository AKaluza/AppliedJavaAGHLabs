// Average an array of values.
   public class Average {
   public static double average(double[] arr) {
      double result = 0;
      int i;
      for(i=0; i<arr.length; i++)
         result = result + arr[i];
      return result / arr.length;
   }

   public static void main(String[] args) {
      double[] nums = {10.1, 11.2, 12.3, 13.4, 14.5};
      System.out.println("Average is " + Average.average(nums) );
   }
}