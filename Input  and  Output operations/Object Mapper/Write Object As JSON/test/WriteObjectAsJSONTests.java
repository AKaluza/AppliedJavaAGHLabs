import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class WriteObjectAsJSONTests {
  @Test
  public void writeAsJSONTest1() throws IOException {
    ByteArrayOutputStream out1 = new ByteArrayOutputStream();
    ByteArrayOutputStream out2 = new ByteArrayOutputStream();
    Car[] cars ={new Car("Mercedes",5),
            new Car("Opel",3), new Car("Mercedes",5),
            new Car("Opel",3)};
    Set<Car> carSet = Arrays.stream(cars).collect(Collectors.toSet());
    Shop shop = new Shop(Arrays.stream(cars).toList(),carSet);
    Object[] warehouse = {cars[1],cars,shop,carSet};
    for(Object o:warehouse) {
      writeAsJSON(out1, o);
      WriteObjectAsJSON.writeAsJSON(out2,o);
    }
    Assertions.assertEquals(out1.toString(),out2.toString());
  }


  public static void writeAsJSON(OutputStream out, Object cars) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.writeValue(out,cars);
  }
}