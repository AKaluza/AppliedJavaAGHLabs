### Filtering Collector
The Collectors.filtering is similar to the Stream filter(); 
it's used for filtering input elements but used for different scenarios. 
The Stream's filter is used in the stream chain whereas the filtering 
is a Collector which was designed to be used along with groupingBy.

With Stream's filter, the values are filtered first and then it's grouped. 
In this way, the values which are filtered out are gone and there is no trace of it. 
If we need a trace then we would need to group first and then apply filtering which actually the Collectors.filtering does.

The Collectors.filtering takes a function for filtering the input elements and a collector to collect the filtered elements.

Your task is to fix `filter` method so that for input list of strings it return map with following properties:
1. key = length of string
2. value = all strings with key length which don't contain '0' letter.