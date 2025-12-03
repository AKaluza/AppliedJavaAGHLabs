## Concurrency: Accumulator
Fix class <strong>SimpleAccumulator</strong>
or/and class <strong>FiveJob</strong>

Fix class <strong>AtomicAccumulator</strong>
try to use build in functions.

Fix class <strong>BrokenAccumulator</strong>
by using different technique than in SimpleAccumulator.

Why volatile not work? Try to find answer.
### Sample output:
```
simpleAccumulator 95 miliseconds
atomicAccumulator 30 miliseconds
brokenAccumulator 17 miliseconds
volatileAccumulator 27 miliseconds
expected: <1000000> but was: <286713>

```