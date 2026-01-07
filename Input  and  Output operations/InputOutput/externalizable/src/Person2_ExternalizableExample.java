import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Person2_ExternalizableExample implements Externalizable {
	private String name;
	/*
	 * We don't want password to be saved to file
	 * We can implement Externalizable interface and manually implement write and read methods
	 */
	private String password;
	private int someNumber;
	
	public Person2_ExternalizableExample() {}
	
	public Person2_ExternalizableExample(String name, String password, int someNumber) {
		this.name = name;
		this.password = password;
		this.someNumber = someNumber;
	}
	
	@Override
	public String toString() {
		return "<name: " + name + ", password: " + password + ", someNumber:" + someNumber + ">";
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		name = (String) in.readObject();
		someNumber = in.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(someNumber);
	}
}
