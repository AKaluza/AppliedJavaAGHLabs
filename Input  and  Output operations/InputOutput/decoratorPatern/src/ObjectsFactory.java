import base.IObject;
import decorators.BlueColorDecorator;
import decorators.BoldTextDecorator;
import decorators.RedColorDecorator;
import decorators.TransparentDecorator;

public abstract class ObjectsFactory {
	public static IObject getTransparentRedPanel() {
		/*
		 * Fill the code with proper methods
		 */
		IObject object = new RedColorDecorator(new TransparentDecorator(new Panel()));
		log(object);
		return object;
	}
	
	private static void log(IObject object) {
		System.out.println("Created object with attributes: " + object.getAttributes());
	}
	
	public static IObject getBoldTextBlueTextBox() {
		/*
		 * Fill the code with proper methods
		 */
		IObject object = new BlueColorDecorator(new BoldTextDecorator(new TextBox()));
		log(object);
		return object;
	}
}
