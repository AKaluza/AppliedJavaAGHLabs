### FlratMapping Collector
The Collectors.flatMapping is similar to Collectors.mapping 
but has a more fine-grained objective. 
Both the collectors takes a function and a collector where the elements are collected 
but flatMapping function accepts a Stream of elements which is then accumulated by the collector.

Your task is to 
1. groups the lists by the lists' sizes and 
2. maps each list to the flat elements of integer which are only divisible by 2.