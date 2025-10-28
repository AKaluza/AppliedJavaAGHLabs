### Grouped assertions
If an assert fails in a test, JUnit will stop executing the test and additional asserts are not checked. 
In case you want to ensure that all asserts are checked you can assertAll.

In this grouped assertion all assertions are executed, even after a failure. The error messages get also grouped together.
<div class="hint">
  Usee ()->
</div>
