### Parametrized tests
Junit5 also supports parameterized tests. To use them you have to add the junit-jupiter-params package as a test dependencies.
We also use the @MethodSource annotation.
We give it the name of the function(s) we want it to call to get it’s test data. 
The function has to be static and must return either a Collection, an Iterator, a Stream or an Array. 
On execution the test method gets called once for every entry in the data source. 
In contrast to Dynamic Tests @BeforeEach and @AfterEach methods will be called for parameterized tests.

**Your task is to fix Calculator and use some annotations to test it**
<div class="hint">
  Use @ParameterizedTest and @MethodSource 
</div>

<div class="hint">
  Use  @ParameterizedTest and @CsvSource
</div>

<div class="hint">
  <a> https://junit.org/junit5/docs/5.8.1/api/org.junit.jupiter.params/org/junit/jupiter/params/ParameterizedTest.html</a>
</div>
