import base.CSVWriteReadTestBase;
import base.ICSVLine;
import base.IReadWriteCSV;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReadWriteCSVTest extends CSVWriteReadTestBase {
	
	protected IReadWriteCSV getReadWriteCSV() {
		return new ReadWriteCSV();
	}
	
	@Test
	public void readTest() {
		IReadWriteCSV toTest = getReadWriteCSV();
		
		writeCSV(fullFile, getCSV());
		
		List<ICSVLine> output = toTest.readCSV(fullFile.getAbsolutePath());
		Assertions.assertNotNull(output, "Shouldn't return null!!");
		Assertions.assertEquals(getCSV(), output, "Readed data don't match output data!");
	}
	
	@Test
	public void writeTest() {
		IReadWriteCSV toTest = getReadWriteCSV();
		
		toTest.writeCSV(emptyFile.getAbsolutePath(), getCSV());
		Assertions.assertTrue(emptyFile.exists(), "File is not created, please check openAndCreateFile method in BasicsIO class!");
		Assertions.assertEquals(getCSV(), readCSV(emptyFile), "Writen data don't match what was provided as parameter!");
	}

	@Override
	protected ICSVLine createICSVLine(String line) {
		return new CSVLine(line);
	}
}
