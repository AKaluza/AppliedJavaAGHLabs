## Reduction Operations
The Stream class has many terminal operations (such as average, sum, min, max, and count) that return one value by combining the contents of a stream. 
These operations are called reduction operations. The Stream API also contains reduction operations that return a collection instead of a single value.
Many reduction operations perform a specific task, such as finding the average of values or grouping elements into categories. 
The Stream API provides two general-purpose reduction operations: reduce() and collect().

### reduce() 
The reduce() method is a general-purpose reduction operation that enables us to produce a single result by 
repeatedly applying a function to a sequence of elements from a stream. 
This method has three overridden signatures, the first of which looks like this:
```
Optional<T> reduce(BinaryOperator<T> accumulator);
```
This signature takes the accumulator function as an input and returns an Optional describing the reduced value. 
The accumulator function takes two parameters: a partial result of the reduction operation and the next element of the stream.

There are two more overridden methods of reduce with the below signatures:
```
T reduce(T identity, BinaryOperator<T> accumulator);

<U> U reduce(U identity, 
             BiFunction<U,? super T,U> accumulator, 
             BinaryOperator<U> combiner);
```
The first overridden method takes only the accumulator as an input parameter. 
The second overridden method signature takes the below input parameters:
- identity: default or the initial value.
- accumulator: a functional interface that takes two inputs: a partial result of the reduction operation and the next element of the stream.
- combiner: a stateless function for combining two values, which must be compatible with the accumulator function.

### output:
```
1-2-30
15

```