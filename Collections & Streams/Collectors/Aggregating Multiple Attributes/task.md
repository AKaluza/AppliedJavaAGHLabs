### Aggregating Multiple Attributes of a Grouped Result
In the previous examples we've seen how to aggregate one field at a time. 
There are some techniques that we can follow to do aggregations over multiple fields.
The first approach is to use `Collectors::collectingAndThen` for the downstream collector of `Collectors::groupingBy`. 
For the first parameter of `collectingAndThen` we collect the stream into a list, using `Collectors::toList`. 
The second parameter applies the finishing transformation, we can use it with any of the Collectors' class methods that 
support aggregations to get our desired results.

The second approach is to use  `Collectors::toMap`

1. Your first task is to fix `groupAndThen` so that:
   1. It groups texts by first letter 
   2. For each one it counts the number of grouped texts, 
   3. It lists grouped texts
   4. It provides a summary statistics of length grouped texts
2. Your second task is to fix `groupAndThenByMap` so that
   1. It is doing the same as `groupAndThen` but use only `toMap`
   2. The first parameter of toMap should group the keys applying length function.
   3. The second parameter of toMap should transform values of the map to initial IntSummaryStatistics object
   4. The third parameter of toMap deals with duplicate elements for a given key, so you should merge statistics
   
   

### output:
```
x=Stat:< texts=[xa, xccc, xdd, xee, xf, xeee, xg], summary:IntSummaryStatistics{count=7, sum=20, min=2, average=2,857143, max=4} >
y=Stat:< texts=[ya, ybb, yccc, ydd, yee, ybb, yf, yeee, yg], summary:IntSummaryStatistics{count=9, sum=26, min=2, average=2,888889, max=4} >
x=Stat:< texts=[xa, xccc, xdd, xee, xf, xeee, xg], summary:IntSummaryStatistics{count=7, sum=20, min=2, average=2,857143, max=4} >
y=Stat:< texts=[ya, ybb, yccc, ydd, yee, ybb, yf, yeee, yg], summary:IntSummaryStatistics{count=9, sum=26, min=2, average=2,888889, max=4} >

```






