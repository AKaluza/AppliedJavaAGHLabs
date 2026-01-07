package base;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;


public final class File implements IFile{
    private final String absoluteFileName;
    private static IFileService fileService;

    public File(String name) {
        if (fileService == null)
            fileService = new FileService();
        absoluteFileName= fileService.getAbsoluteName(name);
    }
    public File(Path path){ this(path.toString());}
    public File(IFileService proxy){fileService= proxy;absoluteFileName = fileService.getAbsoluteName(".");}

    //public static void setFileService(IFileService proxy){fileService = proxy;}

    public String getAbsolutePath() {return fileService.getAbsoluteName(absoluteFileName);}
    public String getName() {return fileService.getName(absoluteFileName);}
    public boolean exists() {return fileService.exists(absoluteFileName);}
    public File getParentFile() {
        return new File(fileService.getParentDirName(absoluteFileName));
    }


    public File createNewFile() {
        if(fileService.createFile(absoluteFileName))
            return this;
        return null;
    }
    public File delete(){
        if(fileService.delete(absoluteFileName))
            return this;
        return null;
    }

    public File mkdirs() {
        if(fileService.mkdirs(absoluteFileName))
            return this;
        return null;
    }
    public boolean isDirectory() {return fileService.isDirectory(absoluteFileName);}

    public File[] listFiles() throws IOException {
        List<String> ls = fileService.ls(absoluteFileName);
        return ls.stream().map(File::new).toArray(File[]::new);
    }

    public boolean equals(Object o){
        if (o == this)
            return true;
        if (o == null || !(this.getClass().equals(o.getClass())))
            return false;
        //if(!(o instanceof File))
        //    return false;
        File file = (File) o;
        return Objects.equals(absoluteFileName,file.absoluteFileName);
    }
    public int hashCode() {
        return Objects.hash(absoluteFileName);
    }
    public String toString(){
        return "File: "+absoluteFileName;
    }

}

class FileService implements IFileService{
    public  String getAbsoluteName(String name) {return Paths.get(name).toAbsolutePath().toString();}
    public  String getParentDirName(String name) {  return Paths.get(name).toAbsolutePath().getParent().toString();}
    public  String getName(String name){ return Paths.get(name).getFileName().toString();}

    public  boolean exists(String name) {return Files.exists(Paths.get(name));}
    public  boolean createFile(String name) {
        try {
            Files.createFile(Paths.get(name));
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    public  boolean  delete(String name){
        try {
            Files.delete(Paths.get(name));
            return true;
        } catch (IOException ex){
            return false;
        }
    }

    public  boolean mkdirs(String name) {
        try {
            Files.createDirectories(Paths.get(name));
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    public  boolean isDirectory(String name) {return Files.isDirectory(Paths.get(name));}
    public List<String> ls(String name) throws IOException {
        return Files.list(Paths.get(name)).map(x->x.toAbsolutePath().toString()).toList();
    }
}