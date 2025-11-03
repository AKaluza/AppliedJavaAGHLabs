# Generic Methods

A **generic method** is a method that defines its own type parameter —  
separate from the class it belongs to.

This means you can use generics **even in non-generic classes**.

---

### Example 1: Generic Print Method

```java
public class Utils {

    public static <T> void print(T value) {
        System.out.println(value);
    }
}
```

### Exercise: Print Any Array

Implement a **static generic method** inside `ArrayPrinter`:

```java
public static <T> void printArray(T[] array)