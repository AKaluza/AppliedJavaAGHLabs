# Task 2 — Record with Validation (Compact Constructor)

## Goal
Learn how to validate record components using a **compact constructor**.

## Background
In a record, the canonical constructor is generated automatically.  
If you need to validate input (for example, disallow negative prices),  
you can define a **compact constructor**. Remember the compiler automatically assigns `this.name = name` and `this.price = price`.

## Instructions

1. Create a record `Product` with two components:

  * `String name`
  * `double price`
2. Add a **compact constructor** that throws an `IllegalArgumentException`
   if `price` is less than 0.
3. In `Main`, test both a valid and invalid case.

## Example Output

```
Product[name=Laptop, price=3499.0]
Exception in thread "main" java.lang.IllegalArgumentException: Price cannot be negative
```

## Hints

* Compact constructor syntax: `public Product { ... }`
* Do not reassign fields — Java does it automatically.

