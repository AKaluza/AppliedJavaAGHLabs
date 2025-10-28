### Disable test
The @Disabled or @Disabled("Why disabled") annotation marks a test to be disabled. 
This is useful when the underlying code has been changed and the test case has not yet been adapted of 
if the test demonstrates an incorrect behavior in the code which has not yet been fixed. 
It is best practice to provide the optional description, why the test is disabled.

Alternatively you can use Assumptions.assumeFalse or Assumptions.assumeTrue to define a condition for test execution. 
Assumptions.assumeFalse marks the test as invalid, if its condition evaluates to true. 
Assumptions.assumeTrue evaluates the test as invalid if its condition evaluates to false. 

