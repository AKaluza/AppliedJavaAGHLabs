import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReadObectArrayTests {
  String jsonArray = "[{\"brand\":\"ford\", \"doors\" : 5}, " +
          "{\"brand\":\"Fiat\",\"doors\" : 4}]";

  @Test
  public void testReadAsArray() throws JsonProcessingException {
    ReadObjectArray readObjectArray = new ReadObjectArray();
    Assertions.assertArrayEquals(arrayFromJSON(jsonArray),readObjectArray.arrayFromJSON(jsonArray));
  }

  @Test
  public void testReadAsList() throws JsonProcessingException {
    ReadObjectArray readObjectArray = new ReadObjectArray();
    Assertions.assertEquals(listFromISON(jsonArray),readObjectArray.listFromISON(jsonArray));
  }

  public Car[] arrayFromJSON(String jsonArray) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(jsonArray, Car[].class);
  }

  public List<Car> listFromISON(String jsonArray) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(jsonArray, new TypeReference<List<Car>>() {});
  }
}