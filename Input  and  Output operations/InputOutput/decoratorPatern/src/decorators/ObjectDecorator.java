package decorators;

import base.IObject;
import base.Attributes;
import java.util.List;

public abstract class ObjectDecorator implements IObject {
	private IObject decorated;
	
	public ObjectDecorator(IObject decorated) {
		this.decorated = decorated;
	}

	@Override
	public List<Attributes> getAttributes() {
		return decorated.getAttributes();
	}
}
