#### Ordering Operations
Ordering operations on a stream include:

1. sorted() which sorts the stream elements according to the natural order
2. an overridden method sorted(comparator) which sorts the stream elements according to a provided Comparator instance.

Comparator is a functional interface that is used to provide an ordering for a collection of objects. 
It takes two arguments for comparison and returns a negative, zero, or a positive integer. 
More details on the Comparator can be found in the official 
[Java documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html).
Both methods are intermediate operations so we still need to call a terminal operation to trigger the sorting. 
We are calling the terminal operation: forEach() to trigger the sort.

### output:
```
[4, 7, 8, 9, 10, 15]
15
10
9
8
7
4
```