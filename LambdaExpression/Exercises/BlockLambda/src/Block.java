interface NumericFunc {
    int func(int n);
}

interface StringFunc {
    String func(String n);
}

interface SomeFunc<T> {
    T func(T t);
}


public class Block {
    public static void main(String[] argx){
        System.out.println("10! = "+factorial(10));
        System.out.println("10! = "+factorial(Integer.valueOf(10)));
        System.out.println("toUpperCase for \"Hello\" = " + up().func("Hello"));
    }
    public static int factorial(int n){
        NumericFunc f = (x) -> {
            int result = 1;
            for(int i=1; i <= x; i++)
                result = i * result;
            return result;
        };
        return f.func(n);
    }

    public static StringFunc up(){
        StringFunc g = (s)->s.toUpperCase();
        return g;
    }

    public static Integer factorial(Integer n){
        SomeFunc<Integer> f = (x) -> {
            int result = 1;
            for(int i=1; i <= x; i++)
                result = i * result;
            return result;
        };
        return f.func(n);
    }

}
