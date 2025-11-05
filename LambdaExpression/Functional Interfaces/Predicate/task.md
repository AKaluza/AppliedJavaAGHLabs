# Predicate<T>

## Goal
Create:
```java
Predicate<String> startsWithCapitalAndNonEmpty
```

Returns `true` if the string is not blank and its first character is uppercase A–Z.

Hints
`Check s != null, !s.isBlank()`.
Use `isUpperCase`.