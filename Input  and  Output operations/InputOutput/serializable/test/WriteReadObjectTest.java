import base.IWriteReadObject;
import base.WriteReadTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WriteReadObjectTest extends WriteReadTestBase {
	@Test
	public void readTest() {
		IWriteReadObject toTest = new WriteReadObject();
		
		writeObject(fullFile, new CollectionOfObjects("1234", new Person("Pierwszy", 1), new Person("Drugi", 2)));
		
		Object output = toTest.readObject(fullFile.getAbsolutePath());
		Assertions.assertNotNull(output, "Shouldn't return null!!");
		Assertions.assertEquals("<identificationData: 1234, list: [<name: Pierwszy, someNumber:1>, <name: Drugi, someNumber:2>]>", output.toString(), "Readed data don't match output data!");
	}
	
	@Test
	public void writeTest() {
		IWriteReadObject toTest = new WriteReadObject();
		
		toTest.writeObject(emptyFile.getAbsolutePath(), new CollectionOfObjects("1234", new Person("Pierwszy", 1), new Person("Drugi", 2)));
		Assertions.assertTrue(emptyFile.exists(), "File is not created, please check openAndCreateFile method in BasicsIO class!");
		
		Assertions.assertEquals("<identificationData: 1234, list: [<name: Pierwszy, someNumber:1>, <name: Drugi, someNumber:2>]>", readObject(emptyFile).toString(), "Writen data don't match what was provided as parameter!");
	}
}
