package testbase;

import base.Attributes;
import base.IObject;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class TestsBase {

	protected IObject getEmpty() {
		return new IObject() {
			
			@Override
			public List<Attributes> getAttributes() {
				return new ArrayList<Attributes>();
			}
		};
	}
	
	protected void check(IObject object, Attributes... attributes) {		
		List<Attributes> list = object.getAttributes();
		
		Assertions.assertEquals(attributes.length, list.size(), "Expected number of attributes different form returned! ");
		for(Attributes attr: attributes) {
			Assertions.assertTrue(list.contains(attr), "Expected to have attribute " + attr + " in list " + list + " but missing!");
		}
	}
	
}
