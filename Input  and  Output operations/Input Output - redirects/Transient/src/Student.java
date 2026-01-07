import java.io.Serializable;
/* If you serialize the object,
all the values will be serialized
but we don't want to serialize one value,
e.g. age then we can declare the age data member as transient. */

public class Student implements Serializable {
    int id;
    String name;
    transient int age;//Now it will not be serialized
    public Student(int id, String name,int age) {
        this.id = id;
        this.name = name;
        this.age=age;
    }
    public String toString(){
        return "Student(id = "+id+", name = "+name+", age = "+age+")";
    }

}