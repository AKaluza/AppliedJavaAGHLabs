### Handling Nullable Streams
In some earlier examples, we used the static factory method of Stream: 
Stream.of() to create a stream with elements. We will get a NullPointerException if the value in the stream is null. 
The ofNullable method was introduced in Java 9 to mitigate this behavior.
The ofNullable method creates a Stream with the supplied elements and if the value is null, an empty Stream is created

The ofNullable method returns an empty stream. So we get a value of 0 for the count() operation instead of a NullPointerException.

### output:
```
4
Cannot read the array length because "array" is null
0

```