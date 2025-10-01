// Initialize a two-dimensional array.
   public class Matrix {
      public static void main(String[] args) {
         double[][] m = {
                 { 0, 0, 0, 0 },
                 { 0, 1, 2, 3 },
                 { 0, 2, 4, 6 },
                 { 0, 3, 6, 9 }
         };
         int i, j;
         for(i=0; i<4; i++) {
            for(j=0; j<4; j++)
               System.out.print(m[i][j] + " ");
            System.out.println();
         }
      }
}