import base.ICSVLine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CSVLineTest {

	@Test
	public void toCSVTest() {
		doToCSVTest("abc,123,;_+,123");
		doToCSVTest("abc ,");
		doToCSVTest(", ,,");
	}
	
	@Test
	public void getPartsTest() {
		doGetPartsTest("abc,123,;_+,123");
		doGetPartsTest("abc ,");
		doGetPartsTest(", ,,");
	}
	
	private void doToCSVTest(String lineIn) {
		ICSVLine line = new CSVLine(lineIn);
		Assertions.assertEquals(lineIn, line.toCSV());
	}
	
	private void doGetPartsTest(String lineIn) {
		ICSVLine line = new CSVLine(lineIn);
		Assertions.assertArrayEquals(lineIn.split(ICSVLine.delim, -1), line.getParts());
	}
	
}
