public record ProductMy(String name, double price) {
    public ProductMy {
        if (price <= 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }

    public ProductMy withDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Discount percent must be in range [0, 100]");
        }
        double newPrice = price * (1.0 - percent / 100.0);
        return new ProductMy(name, newPrice);
    }

    public static ProductMy of(String name, double price) {
        return new ProductMy(name, price);
    }
}
