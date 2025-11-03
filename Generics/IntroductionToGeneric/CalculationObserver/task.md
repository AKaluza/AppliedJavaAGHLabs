# Task: Refactor `feedResults` using `? super Integer`

## 🎯 Goal
Currently, the class `Calculator` has **three nearly identical methods**:

```java
public static void feedResults(IntegerObserver observer, int... values) { ... }
public static void feedResults(NumberObserver observer, int... values) { ... }
public static void feedResults(ObjectObserver observer, int... values) { ... }
```
Each version does the same thing — it sends a list of integer values to an observer
that can process them in some way.

Your task is to refactor this design so that there is only one generic method,
using a lower bounded wildcard (? super Integer).