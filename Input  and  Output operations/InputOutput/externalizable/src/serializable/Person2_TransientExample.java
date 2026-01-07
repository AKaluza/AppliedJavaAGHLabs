package serializable;

import java.io.Serializable;

public class Person2_TransientExample implements Serializable {
	private String name;
	/*
	 * We don't want password to be saved to file
	 * Test will check if password wasn't written down
	 */
	private transient String password;
	private int someNumber;
	
	public Person2_TransientExample(String name, String password, int someNumber) {
		this.name = name;
		this.password = password;
		this.someNumber = someNumber;
	}
	
	@Override
	public String toString() {
		return "<name: " + name + ", password: " + password + ", someNumber:" + someNumber + ">";
	}
}
