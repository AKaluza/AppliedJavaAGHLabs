import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.Externalizable;

public class TypeChecks {	
	@Test
	public void checkIfPerson2_ExternalizableExampleSerializable() {
		Assertions.assertTrue(new Person2_ExternalizableExample("", "", 1) instanceof Externalizable, "Person2_ExternalizableExample.class don't implements Externalizable!!");
	}
}
