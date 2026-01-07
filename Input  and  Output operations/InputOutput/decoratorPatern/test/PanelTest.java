import base.Attributes;

import org.junit.jupiter.api.Test;
import testbase.TestsBase;

public class PanelTest extends TestsBase {

	@Test
	public void test() {
		check(new Panel(), Attributes.PANEL);
	}
	
}
