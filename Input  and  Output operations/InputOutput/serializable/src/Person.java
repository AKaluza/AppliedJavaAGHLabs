import java.io.Serializable;

public class Person implements Serializable {
	private String name;
	private int someNumber;
	
	public Person(String name, int someNumber) {
		this.name = name;
		this.someNumber = someNumber;
	}
	
	@Override
	public String toString() {
		return "<name: " + name + ", someNumber:" + someNumber + ">";
	}
}
