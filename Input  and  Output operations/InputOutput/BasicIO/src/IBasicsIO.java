import base.File;
import java.io.IOException;

public interface IBasicsIO {

	/*
	 * We want just to open file here, there is no need to have logic which will check if particular file exists
	 */
	public File openFile(String path);
	
	/*
	 * We want to open file, but we need also to check if file exist, if not then to create it
	 */
	public File openAndCreateFile(String path) throws IOException;
	
	public boolean isDirectory(File file);
	
	public String getAbsolutePath(File file);
	
	public String getName(File file);
}
