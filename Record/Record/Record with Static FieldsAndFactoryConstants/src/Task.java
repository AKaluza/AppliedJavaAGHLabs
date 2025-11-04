public class Task {
    public static void main(String[] args) {
        Product p1 = new Product("Mouse", 129.99);
        Product p2 = new Product("Keyboard", 199.0);

        System.out.println(p1);
        System.out.println(p2);

        System.out.println("Created products: " + Product.getCreatedCount());
        System.out.println("Default product: " + Product.DEFAULT);
    }
}