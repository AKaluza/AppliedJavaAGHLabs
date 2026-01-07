package base;
import java.io.IOException;


public interface IFile {
    public String getAbsolutePath();
    public String getName();
    public boolean exists();
    public IFile getParentFile();
    public IFile createNewFile();
    public IFile delete();
    public IFile mkdirs();
    public boolean isDirectory();
    public IFile[] listFiles() throws IOException;
}
