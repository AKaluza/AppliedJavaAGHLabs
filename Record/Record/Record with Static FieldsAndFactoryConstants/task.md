
# Task 4 — Record with Static Fields and Factory Constants

## Goal
Learn how to define **static fields** and **factory constants** inside records.

## Background
Although records are immutable and cannot extend other classes,
they can still have **static fields**, **constants**, and **static methods**.

Static members belong to the **class**, not to a particular record instance.

Example:
```java
record Circle(double radius) {
    static final double PI = 3.14159;

    public double area() {
        return PI * radius * radius;
    }

    public static Circle unitCircle() {
        return new Circle(1.0);
    }
}
````

## Instructions

1. Define a record `Product` with two components:

  * `String name`
  * `double price`
2. Add two **static fields**:

  * `static final Product DEFAULT` – representing `"Unknown", 0.0`
  * `static int createdCount` – counting how many `Product` instances have been created
3. Increment `createdCount` in the compact constructor.
4. Add a static method:

   ```java
   public static int getCreatedCount()
   ```

   returning the number of created products.

## Example Output

```
Product[name=Mouse, price=129.99]
Product[name=Keyboard, price=199.0]
Created products: 2
Default product: Product[name=Unknown, price=0.0]
```

## Hints

* Static fields belong to the record type, not to the instance.
* Compact constructor is a good place to increment counters.
* Access static members via the record name, not `this`.

````
