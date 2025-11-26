### Chaining Stream Operations in a Pipeline
Operations on streams are commonly chained together to form a pipeline to execute specific use cases.
We are counting the number of elements, that are bigger than 1.7. To get that count, 
we have created a pipeline of two intermediate operations map() and filter(), 
and chained them together with a terminal operation count().
As we can see in the example, intermediate operations are present in the middle of the pipeline while 
terminal operations are attached to the end of the pipeline.
Intermediate operations are lazily loaded and executed when the terminal operation is called on the stream.



### output:
```
Number of elements from
[1.0, 1.2, 1.4, 1.5999999999999999, 1.7999999999999998, 1.9999999999999998, 2.1999999999999997, 2.4, 2.6, 2.8000000000000003]
that are greater than 1.7 is equal: 6

```

<div class="hint">
  Use map, filter and count
</div>
