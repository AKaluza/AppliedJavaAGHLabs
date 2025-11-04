public record Product(String name, double price) {
    public Product {
        if (price <= 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }

    public Product withDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Discount percent must be in range [0, 100]");
        }
        double newPrice = price * (1.0 - percent / 100.0);
        return new Product(name, newPrice);
    }

    public static Product of(String name, double price) {
        return new Product(name, price);
    }
}
