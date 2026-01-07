import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.Externalizable;
import java.io.Serializable;

public class TypeChecks {
	@Test
	public void checkIfCollectionOfObjectsSerializable() {
		Assertions.assertTrue(new CollectionOfObjects("") instanceof Serializable, "CollectionOfObjects.class don't implements Serializable!!");
	}
	
	@Test
	public void checkIfPersonSerializable() {
		Assertions.assertTrue(new Person("", 1) instanceof Serializable, "Person.class don't implements Serializable!!");
	}
	
	@Test
	public void checkIfPerson2_TransientExampleSerializable() {
		Assertions.assertTrue(new Person2_TransientExample("", "", 1) instanceof Serializable, "Person2_TransientExample.class don't implements Serializable!!");
		Assertions.assertFalse(new Person2_TransientExample("", "", 1) instanceof Externalizable, "Person2_TransientExample.class implements Externalizable, but it shouldn't!!");
	}
}
