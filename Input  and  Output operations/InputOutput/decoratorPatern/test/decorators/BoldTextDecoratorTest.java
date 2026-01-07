package decorators;

import base.Attributes;
import org.junit.jupiter.api.Test;
import testbase.TestsBase;

public class BoldTextDecoratorTest extends TestsBase {

	@Test
	public void test() {
		check(new BoldTextDecorator(getEmpty()), Attributes.BOLDTEXT);
	}
}
