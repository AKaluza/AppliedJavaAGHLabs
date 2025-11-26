import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.stream.Stream;

public class StreamingAppTest {

    final String filePath = "data/Na straganie.txt";

    public  LinkedList<String> readFromFileReference(String filePath)  {
      LinkedList<String> data = new LinkedList<String>();
      Stream<String> stream;
      try (Stream<String> lines = Files.lines(Paths.get(filePath))){
        lines.forEach(x->data.add(x));
      } catch(IOException e) {
        System.err.println(e.getMessage());
      }
      return data;
    }


    @Test
    public void readFromFile2Test() {
        LinkedList<String> expected = readFromFileReference(filePath);
        try(Stream<String> actual = StreamingApp.readFromFile2(filePath)){
            Assertions.assertLinesMatch(expected,actual.toList());
        } catch(IOException ex) {
            Assertions.fail(ex.getMessage());
        }
    }
}