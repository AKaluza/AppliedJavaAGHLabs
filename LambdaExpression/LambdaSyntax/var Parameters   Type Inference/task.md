# Lambda Syntax — `var` Parameters & Type Inference

## Goal
Create `BiFunction<Integer,Integer,Integer> multiply` using:
```java
(var a, var b) -> a * b
```
Note
If you use var for one parameter, you must use it for all.