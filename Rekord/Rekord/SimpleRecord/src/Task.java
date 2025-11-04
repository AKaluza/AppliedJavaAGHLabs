public class Task {
    public static void main(String[] args) {
        Book book1 = new Book("Effective Java", "Joshua Bloch");
        Book book2 = new Book("Effective Java", "Joshua Bloch");
        Book book3 = new Book("Clean Code", "Robert C. Martin");

        System.out.println(book1);                 // Expected: Book[title=Effective Java, author=Joshua Bloch]
        System.out.println(book1.equals(book2));   // Expected: true
        System.out.println(book1.equals(book3));   // Expected: false
    }
}