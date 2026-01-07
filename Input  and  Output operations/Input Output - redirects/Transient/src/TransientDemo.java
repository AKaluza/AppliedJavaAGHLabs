import java.io.*;


public class TransientDemo{
   public static void main(String[] args) throws Exception{
      String fileName = "Input  and  Output operations/Input Output - redirects/Transient/data/f.out";
      Student s1 = new Student(211, "Andrzej", 22);//creating object
      write(s1,fileName);
      System.out.println(load(fileName));
   }
   public static void write(Student student, String fileOutName) {
      //writing object into file
      try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileOutName))) {
         out.writeObject(student);
      } catch (IOException e) {
         System.err.println(e.getMessage());
      }
   }
   public static Student load(String fileName){
      try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName))){
         Object ob = in.readObject();
         if(ob instanceof Student s)
            return s;
      }catch(Exception e) {
         System.err.println(e.getMessage());
      }
      return null;
   }
}


