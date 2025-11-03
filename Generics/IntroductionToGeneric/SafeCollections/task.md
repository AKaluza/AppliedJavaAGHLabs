# What Is a Generic Class?

A **generic class** is a class that can work with **different data types** without rewriting its code.

Instead of hardcoding a type, we use a **type parameter** – a placeholder for the actual type.

### Example without Generics

```java
public class IntBox {
    private int value;
    public void set(int v) { value = v; }
    public int get() { return value; }
}
```

# Exercise: A Simple Generic Box

Implement a class `Box<T>` that can:
1. Store one value of any type `T`.
2. Provide methods:
    - `void set(T value)`
    - `T get()`
    - `boolean isEmpty()`

*Remember:* The type `T` is chosen when you create the object.
Example:
```java
Box<String> b = new Box<>();
b.set("Hello");
```
