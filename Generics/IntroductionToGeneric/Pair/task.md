# Exercise: A Generic Pair

Create a class `Pair<K, V>` that:
1. Stores a key and a value of possibly different types.
2. Provides methods:
  - `K getKey()`
  - `V getValue()`
3. Implements `toString()` returning the format `(key = value)`.

Example:
```java
Pair<String, Integer> p = new Pair<>("Age", 30);
System.out.println(p); // (Age = 30)
