public class Test {
    int a, b;
    Test(){
    }
    Test(int i, int j) {
        a = i;
        b = j;
    }
    Test(Test ob){
        this(ob.a,ob.b);
    }
   // pass an object
   void meth(int a, int b){
        a *= 2;
        b/= 2;
   }
    void meth(Test o) {
        o.a *= 2;
        o.b /= 2;
    }
}