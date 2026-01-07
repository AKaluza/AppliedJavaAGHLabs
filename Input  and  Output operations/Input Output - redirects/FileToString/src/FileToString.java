
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;


public class FileToString {
    static String path = "Input  and  Output operations/Input Output - redirects/FileToString/src/";
    public static String byReadString(Path file) throws IOException {
        return Files.readString(file, Charset.defaultCharset()); // java 11
    }
    public static String byReadAllBytes(Path file)throws IOException{
        byte[] bytes = Files.readAllBytes(file);
        return new String(bytes, Charset.defaultCharset());
    }
    public static String byReadAllLines(Path file) throws IOException{
        List<String> out = Files.readAllLines(file); //java 8
        return String.join("\n",out);
    }
    public static void main(String[] args){
        Path file = Paths.get(path+"FileToString.java");
        String[] str = new String[] {"", "", ""};
        try {
            str[0] = byReadString(file);
            str[1] = byReadAllBytes(file);
            str[2] = byReadAllLines(file);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        for(String v:str) {
            System.out.println(v);
            System.out.println("***************************************************************");
        }
    }
}