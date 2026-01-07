package base;
import java.io.IOException;
import java.util.List;

public interface IFileService {
    public  String getAbsoluteName(String path);
    public  String getParentDirName(String path);
    public  String getName(String name);

    public  boolean exists(String path);
    public  boolean createFile(String path);
    public  boolean delete(String path);

    public  boolean mkdirs(String path);
    public  boolean isDirectory(String path);
    public List<String> ls(String path) throws IOException;
    public void clean();
}
