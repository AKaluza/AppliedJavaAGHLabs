import base.Attributes;
import org.junit.jupiter.api.Test;
import testbase.TestsBase;

public class ObjectsFactoryTest extends TestsBase {

	@Test
	public void TransparentRedPanelTest() {
		check(ObjectsFactory.getTransparentRedPanel(), 
				Attributes.RED,
				Attributes.PANEL,
				Attributes.TRANSPARENT);
	}
	
	@Test
	public void BoldTextBlueTextBox() {
		check(ObjectsFactory.getBoldTextBlueTextBox(), 
				Attributes.BLUE,
				Attributes.TEXTBOX,
				Attributes.BOLDTEXT);
	}
}
