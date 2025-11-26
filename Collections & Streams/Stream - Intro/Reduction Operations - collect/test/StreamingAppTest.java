import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamingAppTest {
  @Test
  public void testSolution() {
    String[] strings = Stream.generate(()-> UUID.randomUUID().toString()).limit(10).toArray(String[]::new);
    Supplier<Stream<String>> streamSup = ()-> Arrays.stream(strings);
    Assertions.assertEquals(joinString(streamSup.get()),StreamingApp.joinnStrings(streamSup.get()));
  }
  public String joinString(Stream<String> products) {
    return products.collect(Collectors.joining());
  }
}