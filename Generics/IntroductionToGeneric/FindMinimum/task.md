# Exercise: Find Minimum Using Generics

Implement a method:
```java
public static <T extends Comparable<T>> T min(T a, T b)
```

The method should:
- Compare two values of type T. 
- Return the smaller one using compareTo.

Examples:
```java
GenericUtils.min(5, 10);        // 5
GenericUtils.min("a", "b");     // "a"
GenericUtils.min(3.14, 2.71); 
```

### Hint: Understanding Comparable<T>

In Java, **`Comparable<T>`** is an interface that defines how objects of a class
can be *compared* to each other — usually to determine their order.

It declares a single method:
```java
int compareTo(T other);
```
What does it return?
- a negative number if this is smaller than other, 
- zero if this and other are equal, 
- a positive number if this is greater than other.