package base;
import java.util.*;

public class FileMemSystem implements IFileService{
    Inode root;

    public FileMemSystem()
    {
        root = new Inode("/", true);
    }



    public String getAbsoluteName(String path) {
        if(path.indexOf("/") != 0)
            return "/"+path;
        else
            return path;
    }

    public String getParentDirName(String path){
        int index = path.lastIndexOf("/");
        if (index <= 0)
            return "/";
        return "/"+path.substring(1,index);
    }

    public String getName(String path) {
        return path.substring(path.lastIndexOf('/')+1,path.length());
    }

    /**
     *
     * @param path
     * @return
     */
    public List<String> ls(String path) {
        List<String> listing = new ArrayList<>();

        Inode node = root.getNode(path);
        if (node == null)
            return listing;

        if(node.isDirectory)
            node.children.forEach((name, inode) -> listing.add(name));
        else
            listing.add(node.name);

        Collections.sort(listing);
        return listing;
    }



    /** Creates a directory: directoryName with all subdirectories
     *
     * @param directoryName - Path to directory
     * @return
     */
    public boolean mkdirs(String directoryName) {
        String[] subdirs = directoryName.substring(1).split("/");
        Inode node = root;
        if (subdirs.length == 0) //root
            return false;
        for(String dir: subdirs)
        {
            if(!node.children.containsKey(dir))
                node.children.put(dir, new Inode(dir, true));
            node = node.children.get(dir);
        }
        return true;
    }

    public boolean delete(String path) {
        String parentName = getParentDirName(path);
        Inode parentNode = root.getNode(parentName);
        String name = getName(path);
        if(parentNode != null) {
            parentNode.children.remove(name);
            return true;
        } else
            return false;
    }


    public boolean isDirectory(String path) {
        Inode node = root.getNode(path);
        if(node == null)
            return false;
        else
            return node.isDirectory;
    }


    public boolean exists(String path) {
        Inode node = root.getNode(path);
        if(node == null)
            return false;
        else
            return true;
    }


    public boolean createFile(String path) {
        String parent = getParentDirName(path);
        String name = getName(path);
        Inode node = root.getNode(parent);
        if(node == null || node.children.containsKey(name))
            return false;
        node.children.put(name,new Inode(name,false));
        return true;
    }

    public boolean addContentToFile(String path, String content) {
        Inode node = root.getNode(path);
        if(node == null || node.isDirectory)
            return false;
        node.fileContent.append(content);
        return true;
    }

    public String readContentFromFile(String path) {
        Inode node = root.getNode(path);
        if(node == null || node.isDirectory)
            return null;
        return node.fileContent.toString();
    }

    public String toString(){
        return "/=" + root.toString();
    }
    public void clean(){
        for(String key:root.children.keySet())
            root.children.remove(key);
    }
    public  static class Inode {
        public String name;
        public boolean isDirectory=true;
        public StringBuilder fileContent=null;
        public HashMap<String, Inode> children = null;

        public Inode(String name, boolean is_dir)
        {
            this.name = name;
            this.isDirectory = is_dir;

            if(!is_dir)
                fileContent = new StringBuilder();

            if(is_dir && children == null)
                children = new HashMap<>();
        }

        private Inode getNode(String path){
            if(path.equals("/")) //root
                return this;
            String[] subdirs = path.substring(1,path.length()).split("/");
            Inode node = this;
            if(children == null)
                return null;
            for (String dir: subdirs) {
                if (!node.children.containsKey(dir))
                    return null;
                node = node.children.get(dir);
            }
            return node;
        }

        public String toString(){
            StringBuilder s = new StringBuilder();
            if(children == null)
                return s.append("\"").append(fileContent).append("\"").toString();
            else
                return children.toString();
        }


        public boolean equals(Object o){
            if(this == o)
                return true;
            if( o == null || o.getClass()!=this.getClass())
                return false;
            Inode that = (Inode) o;
            return name.equals(that.name) && isDirectory == that.isDirectory && Objects.equals(children,that.children);
        }

        public int hashCode(){
            return Objects.hash(name,isDirectory,children);
        }

    }
}



