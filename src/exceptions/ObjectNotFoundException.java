package exceptions;

public class ObjectNotFoundException extends Exception {
	public ObjectNotFoundException() {
		super("Object not found in database");
	}
}
