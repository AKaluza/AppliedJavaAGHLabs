package decorators;

import base.Attributes;
import org.junit.jupiter.api.Test;
import testbase.TestsBase;

public class TransparentDecoratorTest extends TestsBase {

	@Test
	public void test() {
		check(new TransparentDecorator(getEmpty()), Attributes.TRANSPARENT);
	}
}
