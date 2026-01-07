import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ReadObjectFromJSON {
  public static void main(String[] args) throws IOException {
      String carJson =
              "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
      try(InputStream input = new FileInputStream("Input  and  Output operations/Object Mapper/Read Object From JSON/data/car.json")){
          Object[] ob = new Object[] {carJson,
                  input
          };
          for (Object o : ob)
              System.out.println(readFrom(o));
      } catch (IOException ex) {
          ex.printStackTrace();
      }
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