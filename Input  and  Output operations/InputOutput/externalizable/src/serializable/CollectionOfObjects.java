package serializable;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class CollectionOfObjects implements Serializable {
	private String identificationData;
	private List<Object> listOfPeople;
	
	public CollectionOfObjects(String identificationData, Object... listOfPeople) {
		this.identificationData = identificationData;
		this.listOfPeople = Arrays.asList(listOfPeople);
	}
	
	@Override
	public String toString() {
		return "<identificationData: " + identificationData + ", list: " + listOfPeople + ">";
	}
}
