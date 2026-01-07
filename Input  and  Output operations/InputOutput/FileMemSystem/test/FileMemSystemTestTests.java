import base.FileMemSystem;
import base.IFileService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

public class FileMemSystemTestTests {
  IFileService actual = new FileMemSystem();
  IFileService expected = new FileMemSystemRef();
  String dirName1 = "/a/b/c/d";
  String dirName2 = "/a/b/y/z/t";
  String fileName1 = dirName1+"/"+"file1.txt";
  String filename2 = "/file2.txt";
  @BeforeEach
  public void clean(){
    actual.clean();
    expected.clean();
  }
  @Test
  public void mkdirsTest() {
    actual.mkdirs(dirName1);
    actual.mkdirs(dirName2);
    expected.mkdirs(dirName1);
    expected.mkdirs(dirName2);
    Assertions.assertEquals(expected.toString(), actual.toString());
    // put your test here

  }
  @Test
  public void creatFileTest() throws IOException {
    actual.mkdirs(dirName1);
    actual.mkdirs(dirName2);
    actual.createFile(fileName1);
    actual.createFile(filename2);
    expected.mkdirs(dirName1);
    expected.mkdirs(dirName2);
    expected.createFile(fileName1);
    expected.createFile(filename2);
    Assertions.assertEquals(expected.toString(), actual.toString());
    // put your test here

  }

}