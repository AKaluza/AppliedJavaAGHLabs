### Read Object From JSON

By default Jackson maps the fields of a JSON object 
to fields in a Java object by matching the names of the JSON field 
to the getter and setter methods in the Java object. 
Jackson removes the "get" and "set" part of the names 
of the getter and setter methods, and converts the first character
of the remaining name to lowercase.

Your task is to fix `Car` class and `ReadObjectFromJSON.readFrom` 
so that `ObjectMapper` can read data from:
1. String
2. Reader
3. File
4. via URL
5. InputStream
6. Byte Array