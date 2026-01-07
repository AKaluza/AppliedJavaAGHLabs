package base;

public interface IWriteReadObject {

	public abstract Object readObject(String path);

	public abstract void writeObject(String path, Object toWrite);

}