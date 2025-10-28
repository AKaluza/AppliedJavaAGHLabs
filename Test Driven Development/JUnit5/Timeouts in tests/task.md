### Defining timeouts
1. If you want to ensure that a test fails, if it isn’t done in a certain amount of time you can use 
the assertTimeout() method. 
This assert fails the method if the timeout is exceeded.


2. If you want your tests to cancel after the timeout period is passed you can use the assertTimeoutPreemptively() method.