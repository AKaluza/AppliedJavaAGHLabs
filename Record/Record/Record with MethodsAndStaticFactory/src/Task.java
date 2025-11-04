public class Task {
    public static void main(String[] args) {
        Product p1 = new Product("Monitor", 1000.0);
        System.out.println(p1);

        Product discounted = p1.withDiscount(10); // 10% off
        System.out.println(discounted);

        Product mouse = Product.of("Mouse", 129.99);
        System.out.println(mouse);
    }
}