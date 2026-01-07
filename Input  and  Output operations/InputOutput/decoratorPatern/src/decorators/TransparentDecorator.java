package decorators;

import base.Attributes;
import base.IObject;
import java.util.List;

public class TransparentDecorator extends ObjectDecorator {

	public TransparentDecorator(IObject decorated) {
		super(decorated);
	}

	@Override
	public List<Attributes> getAttributes() {
		List<Attributes> list = super.getAttributes();
		list.add(Attributes.TRANSPARENT);
		
		return list;
	}		
}
