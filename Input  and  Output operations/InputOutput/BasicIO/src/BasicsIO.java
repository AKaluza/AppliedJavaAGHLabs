import  base.File;
import java.io.IOException;

public class BasicsIO implements IBasicsIO {

	/*
	 * We want just to open file here, there is no need to have logic which will check if particular file exists
	 * 
	 * Help - try to use constructor of File object
	 */
	@Override
	public File openFile(String path) {
		return new File(path);
	}

	/*
	 * We want to open file, but we need also to check if file exist, if not then to create it
	 * 
	 * Help - it maybe usefull to look at methods of java.io.File object:
	 * 	- exists()
	 *  - getParentFile()
	 *  - mkdirs()
	 *  - createNewFile()
	 */
	@Override
	public File openAndCreateFile(String path) throws IOException {
		File file = openFile(path);
		if(!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
		}
		return file;
		//TODO put code here!
	}

	/*
	 * We want to check that file exists.
	 */
	@Override
	public boolean isDirectory(File file) {
		return file.isDirectory();
		//TODO put code here!
	}

	/*
	 * We want to get the absolut path.
	 */
	@Override
	public String getAbsolutePath(File file) {
		return file.getAbsolutePath();
		//TODO put code here
	}

	/*
	 * We want to get file name.
	 */
	@Override
	public String getName(File file) {
		return file.getName();
		//TODO put code here!
	}
}
