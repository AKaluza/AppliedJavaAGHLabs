package decorators;


import base.Attributes;
import base.IObject;
import java.util.List;

public class BoldTextDecorator extends ObjectDecorator {

	public BoldTextDecorator(IObject decorated) {
		super(decorated);
	}

	@Override
	public List<Attributes> getAttributes() {
		List<Attributes> list = super.getAttributes();
		list.add(Attributes.BOLDTEXT);
		
		return list;
	}		
}
