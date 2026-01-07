package base;

public class FileMemTest {
   private static FileMemSystem fileSystem = new FileMemSystem();
   private static String dirName = "/a/b/c/d";
   private static String fileName = "/"+"out1.txt";

  public static void main(String[] args){
      fileSystem.mkdirs(dirName);
      fileSystem.createFile(fileName);
      fileSystem.addContentToFile(fileName,"UUUps");
      System.out.println(fileSystem);
      fileSystem.delete(fileName);
      System.out.println(fileSystem);
      fileSystem.delete(dirName);
      System.out.println(fileSystem);
      fileSystem.clean();
      System.out.println(fileSystem);
  }
}