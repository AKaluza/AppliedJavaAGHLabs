import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

record Car(String brand, int doors){}
public class ReadObjectArray {
    String jsonArray = "[{\"brand\":\"ford\", \"doors\" : 5}, " +
            "{\"brand\":\"Fiat\",\"doors\" : 4}]";

    public static void main(String[] args) throws JsonProcessingException {
        ReadObjectArray readObjectArray = new ReadObjectArray();
        System.out.println(Arrays.toString(readObjectArray.arrayFromJSON(readObjectArray.jsonArray)));
        System.out.println(readObjectArray.listFromISON(readObjectArray.jsonArray));
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