### oncurrency: Splitter
- Implement split method in org.example.Splitter class as static one
  1. must take an array of long numbers - vector argument
  2. must take a number of splits - n argument
  3. a function f that maps array of long to long
  4. must split a given vector into n possibly equal slices
  5. must returns a collection of callables functions that applies a given function to particular slice

- Complete main method to test split
### output:
```
Length of [1, 2, 3, 4] = 4
Sum of [1, 2, 3, 4] = 10

```

<div class="hint">
  Use mapToObj on proper IntStream and Arrays.copyOfRange
</div>
