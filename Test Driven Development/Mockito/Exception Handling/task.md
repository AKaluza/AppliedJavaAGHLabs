### Exception Handling
Mockito provides the capability to a mock to throw exceptions, so exception handling can be tested. 

Let'add an exception clause to a mock object. 
MathApplication makes use of calcService using its add method and the mock throws a RuntimeException whenever 
calcService.add() method is invoked.

<div class="hint">
  Use DoThrow
</div>
