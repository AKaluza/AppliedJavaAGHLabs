public class PassObjRef {
    public static void main(String[] args) {
        Test ob0 = new Test();
        Test ob2;
        int a = 5, b = 8;

        // Primitive types are passed by value.
        System.out.println("a and b before call: " + a + " " + b);
        ob0.meth(a, b);
        System.out.println("a and b after call: " + a + " " + b);

        // Objects are passed through their references.
        Test ob = new Test(15, 20);
        System.out.println("ob.a and ob.b before call: " + ob.a + " " + ob.b);
        ob2 = ob;
        ob.meth(ob2);
        System.out.println("ob.a and ob.b after call: " + ob.a + " " + ob.b);
        System.out.println("ob2.a and ob2.b after call: " + ob2.a + " " + ob2.b);
    }
}