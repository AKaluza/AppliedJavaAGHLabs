public class Task {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 3499.0);
        System.out.println(p1);

        try {
            Product p2 = new Product("Phone", -100.0);
            System.out.println(p2);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation works: " + e.getMessage());
        }
    }
}