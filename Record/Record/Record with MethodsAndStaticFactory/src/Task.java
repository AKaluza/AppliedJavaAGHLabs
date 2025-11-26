public class Task {
    public static void main(String[] args) {
        ProductMy p1 = new ProductMy("Monitor", 1000.0);
        System.out.println(p1);

        ProductMy discounted = p1.withDiscount(10); // 10% off
        System.out.println(discounted);

        ProductMy mouse = ProductMy.of("Mouse", 129.99);
        System.out.println(mouse);
    }
}