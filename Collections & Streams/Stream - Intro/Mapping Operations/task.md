
### Mapping Operations
These are intermediate operations and transform each element of a stream by applying a function and putting them in a new stream for further processing.

- The map() operation takes a function as an input and returns a stream consisting of the results of applying the supplied function to each element of the stream.
- We should use the flatMap() method if we have a stream where every element has its sequence of elements and we want to create a single stream of these inner elements

### output:
```
[[washing machine, Television], [Laptop], [grocery, essentials]]
[washing machine, Television, Laptop, grocery, essentials]
[1, 2, 3, 4, 5]

```
<div class="hint">
  Use map on productCategoriesStream
</div>

<div class="hint">
  Use flatMap
</div>
