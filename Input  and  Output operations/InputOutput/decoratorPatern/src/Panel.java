import base.Attributes;
import base.IObject;

import java.util.ArrayList;
import java.util.List;

public class Panel implements IObject {
	@Override
	public List<Attributes> getAttributes() {
		List<Attributes> attrs = new ArrayList<Attributes>();
		attrs.add(Attributes.PANEL);
		return attrs;
	}
}
