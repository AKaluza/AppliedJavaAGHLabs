import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamingApp {
    public static void main(String[] args){
        List<List<String>> nestedProductByCategories = Arrays.asList(
                Arrays.asList("washing machine", "Television"),
                List.of("Laptop"),
                Arrays.asList("grocery", "essentials"));

        List<String> productCategories = flatmapStream(nestedProductByCategories.stream());
        System.out.println(nestedProductByCategories);
        System.out.println(productCategories);
        List<String> categoryCodes = mapStream(productCategories.stream());
        System.out.println(categoryCodes);

    }
    public static String getCode(String element){
        return switch (element){
            case "washing machine"-> "1";
            case "Television" -> "2";
            case "Laptop" -> "3";
            case "grocery"  ->"4";
            case "essentials" -> "5";
            default -> "6";
        };
    }


    public static List<String> mapStream(Stream<String> productCategoriesStream) {


        List<String> categoryCodes =
                productCategoriesStream.map(
                        // mapping function: map category name to code
                        StreamingApp::getCode
                ).collect(Collectors.toList()) ;

        return categoryCodes;
    }
    public static List<String> flatmapStream(Stream<List<String>> streamProductByCategories) {

        List<String> products = streamProductByCategories
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return products;
    }
}