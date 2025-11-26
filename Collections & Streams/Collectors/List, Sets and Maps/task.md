### List, Sets and Maps
Stream.collect() is one of the Java 8's Stream API‘s terminal methods. 
It allows us to perform mutable fold operations (repackaging elements to some data structures and 
applying some additional logic, concatenating them, etc)
The strategy for this operation is provided via the Collector interface.

Fix ToCollection
1. List should be LinkedList
2. Set should be unmodifiable.
3. Every value in the map should be the key length
<div class="hint">
  For a dictionary, ignore the duplicates using alambda expression
</div>

