public class Playground {
    public static void main(String[] args) {
        IntegerObserver obs1 = new IntegerObserver();
        NumberObserver  obs2 = new NumberObserver();
        ObjectObserver  obs3 = new ObjectObserver();

//        Calculator.feedResults(obs1, 1, 2, 3);  // OK
//        Calculator.feedResults(obs2, 4, 5, 6);  // OK
//        Calculator.feedResults(obs3, 7, 8, 9);  // OK
    }
}
