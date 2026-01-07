package base;

public interface ICSVLine {

    public static final String delim = ",";

    public abstract String[] getParts();

    public abstract String toCSV();

}
