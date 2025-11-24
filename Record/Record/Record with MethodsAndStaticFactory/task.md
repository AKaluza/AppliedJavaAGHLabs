## Goal
Learn how to define **custom methods** and **static factory methods** in records.

## Background
Records can contain additional methods (instance or static).  
They remain immutable — so instead of changing existing fields,  
methods return **new record instances**.

## Instructions

1. Define a record `Product` with components:

  * `String name`
  * `double price`
2. Add a **compact constructor** to ensure `price > 0`.
3. Add an instance method:

   ```java
   public Product withDiscount(double percent)
   ```

   which returns a **new Product** with price reduced by given percent.
4. Add a static factory:

   ```java
   public static Product of(String name, double price)
   ```

   which simply returns `new Product(name, price)`.

## Example Output

```
Product[name=Monitor, price=1000.0]
Product[name=Monitor, price=900.0]
Product[name=Mouse, price=129.99]
```
<div class="hint">
Records are immutable — don’t try to modify fields, always return new objects.
</div>

