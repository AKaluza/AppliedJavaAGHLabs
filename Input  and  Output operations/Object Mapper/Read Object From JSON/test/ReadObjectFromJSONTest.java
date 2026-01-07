import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URL;


public class ReadObjectFromJSONTest {
  String path = "data/car.json";
  String carJson =
          "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
  @Test
  public void readFromString() throws IOException {
    Object o = carJson;
    Assertions.assertEquals(readFrom(o).toString(),
            ReadObjectFromJSONTest.readFrom(o).toString());
  }
  @Test
  public void readFromByteArray() throws IOException {
    Object o = carJson.getBytes();
    Assertions.assertEquals(readFrom(o).toString(),
            ReadObjectFromJSONTest.readFrom(o).toString());
  }
  @Test
  public void readFromReader() throws IOException {
    Object o1 = new StringReader(carJson);
    Object o2 = new StringReader(carJson);
    Assertions.assertEquals(readFrom(o1).toString(),
            ReadObjectFromJSONTest.readFrom(o2).toString());
  }
  @Test
  public void readFromFile() throws IOException {
    Object o1 = new File(path);
    Object o2 = new File(path);
    Assertions.assertEquals(readFrom(o1).toString(),
            ReadObjectFromJSONTest.readFrom(o2).toString());
  }
  @Test
  public void readFromURL() throws IOException {
    Object o1 = new URL("file:"+path);
    Object o2 = new URL("file:"+path);
    Assertions.assertEquals(readFrom(o1).toString(),
            ReadObjectFromJSONTest.readFrom(o2).toString());
  }
  @Test
  public void readFromInputStream() throws IOException {
    Object o1 = new FileInputStream(path);
    Object o2 = new FileInputStream(path);
    Assertions.assertEquals(readFrom(o1).toString(),
            ReadObjectFromJSONTest.readFrom(o2).toString());
  }

    public static Car readFrom(Object ob) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    return switch(ob){
      case String s -> objectMapper.readValue(s,Car.class);
      case Reader r -> objectMapper.readValue(r,Car.class);
      case File f   -> objectMapper.readValue(f,Car.class);
      case URL url  -> objectMapper.readValue(url,Car.class);
      case InputStream input -> objectMapper.readValue(input,Car.class);
      case byte[] bytes -> objectMapper.readValue(bytes,Car.class);
      default -> throw new IllegalStateException("Unexpected value: " + ob);
    };
  }
}