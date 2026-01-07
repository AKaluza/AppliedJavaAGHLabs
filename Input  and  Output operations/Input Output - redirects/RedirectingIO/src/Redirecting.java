import java.io.*;

public class Redirecting {
    // Throw exceptions to console:
    public static void main(String[] args) throws IOException {
        String working_dir = "Input  and  Output operations/Input Output - redirects/RedirectingIO/";
        redirectFromTo(working_dir+"src/Redirecting.java",working_dir+"data/test.txt");
    }
    public static void redirectFromTo(String fromFileName, String toFileName)
            throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(fromFileName));
        PrintStream out = new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(toFileName)));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null)
            System.out.println(s);
        out.close(); // Remember this!
        System.setOut(console);
        System.out.println("Back to old console");
    }

}
