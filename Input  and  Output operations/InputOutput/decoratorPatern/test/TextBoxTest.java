import base.Attributes;
import org.junit.jupiter.api.Test;
import testbase.TestsBase;

public class TextBoxTest extends TestsBase {

	@Test
	public void test() {
		check(new TextBox(), Attributes.TEXTBOX);
	}
	
}
