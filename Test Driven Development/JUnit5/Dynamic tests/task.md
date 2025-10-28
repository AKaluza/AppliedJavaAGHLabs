### Dynamic  tests
Dynamic test methods are annotated with @TestFactory and allow you to create multiple tests of type DynamicTest with your code. 
They can return:
1. an Iterable
2. a Collection
3. a Stream

JUnit 5 creates and runs all dynamic tests during test execution.

Methods annotated with @BeforeEach and @AfterEach are not called for dynamic tests. 
This means, that you can’t use them to reset the test object, if you change it’s state in the lambda expression for a dynamic test.

<div class="hint">
  initialize the array
</div>

<div class="hint">
  Use dynamicTest
</div>
