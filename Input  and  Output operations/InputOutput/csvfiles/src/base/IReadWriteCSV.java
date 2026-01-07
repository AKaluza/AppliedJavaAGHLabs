package base;

import java.util.List;

public interface IReadWriteCSV {

	public abstract List<ICSVLine> readCSV(String path);

	public abstract void writeCSV(String path, List<ICSVLine> data);

}