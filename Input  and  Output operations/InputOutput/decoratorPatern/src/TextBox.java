import base.Attributes;
import base.IObject;

import java.util.ArrayList;
import java.util.List;


public class TextBox implements IObject {
	@Override
	public List<Attributes> getAttributes() {
		List<Attributes> attrs = new ArrayList<Attributes>();
		attrs.add(Attributes.TEXTBOX);
		return attrs;
	}
}
