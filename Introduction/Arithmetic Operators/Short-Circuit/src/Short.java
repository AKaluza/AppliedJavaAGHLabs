public class Short {
   public static void main(String[] args) {
     int denom = 0, num = 1, d = 0;
      if (denom != 0 && num / denom > 10)
         System.out.println("nu / denom is calculated");
      if ( denom == 0 && num++ < 2) d++;
      System.out.println("num = " + num + " d = " + d);
      if ( denom == 0 & num++ < 2) d++;
      System.out.println("num = " + num+  " d = " + d);
       if ( denom == 0 | num++ < 4) d++;
       System.out.println("num = " + num + " d = " + d);
       if ( denom == 0 || num++ < 4) d++;
       System.out.println("num = " + num+  " d = " + d);
   }
}