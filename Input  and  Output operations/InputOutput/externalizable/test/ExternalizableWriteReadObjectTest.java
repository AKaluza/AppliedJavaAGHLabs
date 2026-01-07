import base.IWriteReadObject;
import base.WriteReadTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import serializable.CollectionOfObjects;
import serializable.WriteReadObject;

public class ExternalizableWriteReadObjectTest extends WriteReadTestBase {
	@Test
	public void transientTest() {		
		IWriteReadObject toTest = new WriteReadObject();
		
		toTest.writeObject(emptyFile.getAbsolutePath(), new CollectionOfObjects("1234", new Person2_ExternalizableExample("Pierwszy", "pass1", 1), new Person2_ExternalizableExample("Drugi", "pass2", 2)));
		Assertions.assertTrue(emptyFile.exists(), "File is not created, please check openAndCreateFile method in BasicsIO class!");
		
		Assertions.assertEquals("<identificationData: 1234, list: [<name: Pierwszy, password: null, someNumber:1>, <name: Drugi, password: null, someNumber:2>]>", toTest.readObject(emptyFile.getAbsolutePath()).toString(), "Writen data don't match what was provided as parameter!");
	}
}
