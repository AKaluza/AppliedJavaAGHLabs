### Partitioning
`partitioningBy` is a specialized case of groupingBy that accepts a Predicate instance, 
and then collects Stream elements into a Map instance that stores Boolean values as keys and collections as values. 
Under the “true” key, we can find a collection of elements matching the given Predicate, 
and under the “false” key, we can find a collection of elements not matching the given Predicate.

Your task is to fix `partition` and `partitionAndCount` according to:
### output:
```
{false=[1, 3, 5, 7, 9, 11, 13, 15, 17, 19], true=[2, 4, 6, 8, 10, 12, 14, 16, 18, 20]}
{false=IntSummaryStatistics{count=10, sum=100, min=1, average=10,000000, max=19}, true=IntSummaryStatistics{count=10, sum=110, min=2, average=11,000000, max=20}}

```