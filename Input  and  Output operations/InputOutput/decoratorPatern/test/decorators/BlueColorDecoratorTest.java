package decorators;

import base.Attributes;
import org.junit.jupiter.api.Test;
import testbase.TestsBase;

public class BlueColorDecoratorTest extends TestsBase {

	@Test
	public void test() {
		check(new BlueColorDecorator(getEmpty()), Attributes.BLUE);
	}
}
