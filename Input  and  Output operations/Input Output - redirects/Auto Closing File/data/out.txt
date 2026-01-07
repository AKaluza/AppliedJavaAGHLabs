/* A version of CopyFile that uses try-with-resources.
It demonstrates two resources (in this case files) being managed by a single try statement. */
import java.io.*;
public class CopyFile {
    //private static final String path = "Input  and  Output operations/Input Output - redirects/Auto Closing File/";
    private static final String path = "Input  and  Output operations/Input Output - redirects/Auto Closing File/";
    private static final String fileNameIn = "src/CopyFile.java";
    private static final String fileNameOut = "data/out.txt";
    public static void main(String[] args){
        copy(path+fileNameIn,path+fileNameOut);
    }
    public static void copy(String fileNameIn,String fileNameOut) {
        int i;

        // Open and manage two files via the try statement.
        try (FileInputStream fin = new FileInputStream(fileNameIn);
             FileOutputStream fout = new FileOutputStream(fileNameOut))
        {
            do { i = fin.read();
                if(i != -1)
                    fout.write(i);
            } while(i != -1);
        } catch(IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}