package decorators;

import base.Attributes;
import base.IObject;

import java.util.List;

public class RedColorDecorator extends ObjectDecorator {

	public RedColorDecorator(IObject decorated) {
		super(decorated);
	}

	@Override
	public List<Attributes> getAttributes() {
		List<Attributes> list = super.getAttributes();
		list.add(Attributes.RED);
		
		return list;
	}		
}
