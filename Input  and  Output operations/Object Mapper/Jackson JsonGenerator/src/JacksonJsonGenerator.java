import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

record Car(String brand, int doors){}

public class JacksonJsonGenerator {

    public static void main(String[] args){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        writeAsJSON(out);
        System.out.println(out);
    }
    public static void writeAsJSON(OutputStream out){
      JsonFactory factory = new JsonFactory();
      try(JsonGenerator generator = factory.createGenerator(
              out, JsonEncoding.UTF8)){
          generator.writeStartArray();

          generator.writeStartObject();
          generator.writeObjectField("brand", "Mercedes");
          generator.writeObjectField("doors", 5);
          generator.writeEndObject();

          generator.writeStartObject();
          generator.writeObjectField("brand", "Fiat");
          generator.writeObjectField("doors", 4);
          generator.writeEndObject();

          generator.writeStartObject();
          generator.writeObjectField("brand", "Opel");
          generator.writeObjectField("doors", 3);
          generator.writeEndObject();

          generator.writeEndArray();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
}