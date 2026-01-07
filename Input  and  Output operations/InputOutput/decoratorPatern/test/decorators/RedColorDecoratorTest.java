package decorators;

import base.Attributes;
import org.junit.jupiter.api.Test;
import testbase.TestsBase;

public class RedColorDecoratorTest extends TestsBase {

	@Test
	public void test() {
		check(new RedColorDecorator(getEmpty()), Attributes.RED);
	}
}
