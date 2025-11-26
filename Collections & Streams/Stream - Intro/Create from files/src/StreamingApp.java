import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class StreamingApp {
    public static final String filePath = "data/Na straganie.txt";
    public static void main(String[] args) throws IOException {
       readFromFile(filePath).forEach(System.out::println);
       System.out.println("*************************************************************");
       readFromFile2(filePath).forEach(x->System.out.println(x));
    }

    public static LinkedList<String> readFromFile(final String filePath) throws IOException {
        LinkedList<String> data = new LinkedList<>();
        Stream<String> stream;
        try (Stream<String> lines = Files.lines(Paths.get(filePath))){
            lines.forEach(data::add);
        } catch(IOException e) {
            System.err.println(e.getMessage());
            throw e;
        }
        return data;
    }
    public static Stream<String> readFromFile2(final String filePath) throws IOException {
        return Files.lines(Paths.get(filePath));
    }
}