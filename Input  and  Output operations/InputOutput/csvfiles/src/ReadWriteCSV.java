import base.IBasicsIO;
import base.ICSVLine;
import base.IReadWriteCSV;
import base.BasicsIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteCSV implements IReadWriteCSV {

	@Override
	public List<ICSVLine> readCSV(String path) {
		List<ICSVLine> list = new ArrayList<ICSVLine>();
		
		IBasicsIO basicIO = new BasicsIO();
		File file = basicIO.openFile(path);
		
		if(file!= null && file.exists()) {
			BufferedReader stream = null;
			try {
				/* here we should create stream and read data line by line
				 * Help - check FileReader/BufferedReader
				 */
				//TODO put code here!
				stream = new BufferedReader(new FileReader(file));
				String line;
				while((line = stream.readLine()) != null) {
					list.add(new CSVLine(line));
				}
			} catch (IOException e) {
				System.out.println(e);
			} finally {
				// here we need to clean up nothing to do for you;)
				if(stream!=null) {
					try {
						stream.close();
					} catch (IOException e) {
						System.out.println("Nothing more I can do here: " + e);
					}
				}
			}
		}
		System.out.println("Readed data: " + list);
		
		return list;
	}
	
	@Override
	public void writeCSV(String path, List<ICSVLine> data) {		
		BufferedWriter stream = null;
		try {
			/*
			 * We need to open file and write data line by line into it (you may think about usage of IBasicIO)
			 * Help - check FileWriter/BufferedWriter
			 */
			//TODO put code here!
			IBasicsIO basicIO = new BasicsIO();
			File file = basicIO.openAndCreateFile(path);

			stream = new BufferedWriter(new FileWriter(file));
			for(ICSVLine line: data) {
				stream.write(line.toCSV());
				stream.newLine();
			}
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			// here we need to clean up   nothing to do for you;)
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					System.out.println("Nothing more I can do here: " + e);
				}
			}
		}
	}
}
