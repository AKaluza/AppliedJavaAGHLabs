import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamingAppTest {
  public List<String> mapStreamReference(Stream<String> productCategoriesStream) {


    List<String> categoryCodes =
            productCategoriesStream.map(
                    // mapping function: map category name to code
                    element->{
                      String code = null;
                      switch (element) {
                        case "washing machine" : code = "1"; break;
                        case "Television" : code = "2"; break;
                        case "Laptop" : code = "3"; break;
                        case "grocery" : code = "4"; break;
                        case "essentials" : code = "5"; break;
                        case "default" : code = "6";
                      }
                      return code;
                    }
            ).collect(Collectors.toList());

    return categoryCodes;
  }
  public List<String> flatmapStreamReference(Stream<List<String>> streamProductByCategories) {

    List<String> products = streamProductByCategories
            .flatMap(Collection::stream)
            .collect(Collectors.toList());

    return products;
  }

  @Test
  public void testSolution() {
    List<List<String>> nestedProductByCategories = Arrays.asList(
            Arrays.asList("washing machine", "Television"),
            Arrays.asList("Laptop"),
            Arrays.asList("grocery", "essentials"));

    List<String> productCategoriesExpected = flatmapStreamReference(nestedProductByCategories.stream());
    List<String> categoryCodesExpected = mapStreamReference(productCategoriesExpected.stream());
    List<String> productCategoriesActual = StreamingApp.flatmapStream(nestedProductByCategories.stream());
    List<String> categoryCodesActual = StreamingApp.mapStream(productCategoriesActual.stream());

    Assertions.assertAll(
            ()->Assertions.assertEquals(productCategoriesExpected,productCategoriesActual),
            ()->Assertions.assertEquals(categoryCodesExpected,categoryCodesActual)
    );
  }
}