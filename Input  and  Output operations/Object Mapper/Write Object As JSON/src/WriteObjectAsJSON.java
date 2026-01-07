import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

record Car(String brand, int doors){}
record Shop(Collection<Car> cars1, Collection<Car> cars2){}
public class WriteObjectAsJSON {
    public static void main(String[] args) throws IOException {
        Car[] cars ={new Car("Mercedes",5),
                new Car("Opel",4),
                new Car("Mercedes",5)
        };
        Set<Car> carSet = Arrays.stream(cars).collect(Collectors.toSet());
        Shop shop = new Shop(carSet,Arrays.stream(cars).toList());

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        writeAsJSON(out,shop);

        System.out.println(out);
    }
    public static void writeAsJSON(OutputStream out, Object cars) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(out,cars);
    }

}