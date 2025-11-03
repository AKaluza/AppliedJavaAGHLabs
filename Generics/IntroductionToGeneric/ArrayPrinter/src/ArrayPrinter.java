public class ArrayPrinter {
  //put your task here
  public static <T> void printArray(T[] array) {
      for (T element : array) {
          System.out.print(element + " ");
      }
      System.out.println();
  }
}