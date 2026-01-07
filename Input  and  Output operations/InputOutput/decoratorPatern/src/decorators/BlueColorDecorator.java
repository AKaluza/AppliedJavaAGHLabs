package decorators;

import base.IObject;
import base.Attributes;
import java.util.List;

public class BlueColorDecorator extends ObjectDecorator {

	public BlueColorDecorator(IObject decorated) {
		super(decorated);
	}

	@Override
	public List<Attributes> getAttributes() {
		List<Attributes> list = super.getAttributes();
		list.add(Attributes.BLUE);
		
		return list;
	}		
}
