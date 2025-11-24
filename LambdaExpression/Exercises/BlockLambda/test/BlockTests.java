
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BlockTests {
  @Test
  public void testSolution() {
    String expected = "10! = 3628800"+ System.lineSeparator() +"10! = 3628800"
            + System.lineSeparator() +"toUpperCase for \"Hello\" = HELLO"+ System.lineSeparator();
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
    Block.main(new String[] {""});
    Assertions.assertEquals(expected,out.toString());

    Assertions.assertEquals(Block.factorial(10),3628800);
  }

  @Test
  public void factorialTest(){
    int x = 10;
    int y = 9;
    Assertions.assertEquals(Block.factorial(10),3628800);
    Assertions.assertEquals(Block.factorial(9),362880);
  }

  public void factorialTest2(){
    Integer x = 10;
    Integer y = 9;
    Assertions.assertEquals(Block.factorial(10),3628800);
    Assertions.assertEquals(Block.factorial(9),362880);
  }

  public void upTest(){
    Assertions.assertEquals(Block.up().func("myname"),"MYNAME");
  }

}