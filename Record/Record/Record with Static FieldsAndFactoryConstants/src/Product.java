public record Product(String name, double price) {
    // static constant (shared)
    public static final Product DEFAULT = new Product("Unknown", 0.0);

    // static counter (shared across all instances)
    private static int createdCount = 0;

    // compact constructor
    public Product {
        createdCount++; // increment each time a new product is created
    }

    // static getter for counter
    public static int getCreatedCount() {
        return createdCount;
    }
}
