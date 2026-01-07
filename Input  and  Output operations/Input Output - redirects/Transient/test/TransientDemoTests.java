import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TransientDemoTests {
  @Test
  public void testTransient() throws NoSuchFieldException {
    Field field = Student.class.getDeclaredField("age");
    Assertions.assertTrue(Modifier.isTransient(field.getModifiers()),"age hasn't proper modifier");
  }
  @Test
  public void writeLoadTest() throws IOException {
    String fileName = "data/f.test.out";
    Student s1 = new Student(100, "Adam", 20);//creating object
    Student s2 = new Student(100, "Adam", 0);//creating object

    final Path path = Paths.get(fileName);
    Files.deleteIfExists(path);
    TransientDemo.write(s1,fileName);
    Student s3 = TransientDemo.load(fileName);
    Files.deleteIfExists(path);
    Assertions.assertNotNull(s3);
    Assertions.assertEquals(s2.toString(),s3.toString());
  }
  
}