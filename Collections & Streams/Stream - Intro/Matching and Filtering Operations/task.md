### Matching and Filtering Operations
The Stream interface provides methods to detect whether the elements of a stream comply with a condition 
(called the predicate) specified as input. All of these methods are terminal operations that return a boolean.
1. With anyMatch() operation, we determine whether any of the elements comply to the condition specified as the predicate
2. With allMatch() operation, we determine whether all of the elements comply to the condition specified as the predicate
3. With noneMatch() operation, we determine whether none of the elements comply to the condition specified as the predicate 
4. filter() is an intermediate operation of the Stream interface that allows us to filter elements 
of a stream that match a given condition (known as predicate)
### output:
```
true
1
true
true
[5, 6, 7, 8, 9]

```