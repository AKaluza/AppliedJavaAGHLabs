### Jackson JsonGenerator
The `ObjectMapper` of the Jackson library internally uses 
`JsonGenerator` class for generating JSON structure from the Java objects.

Your task is to manually generate JSON Array from list:
`{Car("Mercedes",5), Car("Fiat",4)}, Car("Opel",3)}`

<div class="hint">
  Use writeObjectField / writeStartObject / writeEndObject
</div>
