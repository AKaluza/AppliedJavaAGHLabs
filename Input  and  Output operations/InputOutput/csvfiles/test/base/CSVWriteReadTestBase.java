package base;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class CSVWriteReadTestBase extends WriteReadTestBase {
    public CSVWriteReadTestBase() {
    }

    protected abstract ICSVLine createICSVLine(String var1);

    protected List<ICSVLine> getCSV() {
        List<ICSVLine> list = new ArrayList();
        list.add(this.createICSVLine("1,x,y,z"));
        list.add(this.createICSVLine("2,xxx,yyy,zzz"));
        list.add(this.createICSVLine("3,x,,z"));
        list.add(this.createICSVLine("4,x,y,"));
        list.add(this.createICSVLine("5,,,"));
        list.add(this.createICSVLine("6,x,y,z"));
        list.add(this.createICSVLine("7,,y,z"));
        return list;
    }

    protected boolean checkCSV(List<ICSVLine> list) {
        List<ICSVLine> check = this.getCSV();
        if (check.size() != list.size()) {
            return false;
        } else {
            Iterator var4 = list.iterator();

            while(var4.hasNext()) {
                ICSVLine line = (ICSVLine)var4.next();
                if (!check.remove(line)) {
                    return false;
                }
            }

            return check.size() == 0;
        }
    }

    protected List<ICSVLine> readCSV(File file) {
        List<ICSVLine> list = new ArrayList();
        if (file != null && file.exists()) {
            BufferedReader stream = null;

            try {
                stream = new BufferedReader(new FileReader(file));

                String line;
                while((line = stream.readLine()) != null) {
                    list.add(this.createICSVLine(line));
                }
            } catch (IOException var13) {
                System.out.println(var13);
            } finally {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (IOException var12) {
                        System.out.println("Nothing more I can do here: " + var12);
                    }
                }

            }
        }

        System.out.println("Readed data: " + list);
        return list;
    }

    protected void writeCSV(File file, List<ICSVLine> data) {
        BufferedWriter stream = null;

        try {
            stream = new BufferedWriter(new FileWriter(file));
            Iterator var5 = data.iterator();

            while(var5.hasNext()) {
                ICSVLine line = (ICSVLine)var5.next();
                stream.write(line.toCSV());
                stream.newLine();
            }
        } catch (IOException var14) {
            System.out.println(var14);
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException var13) {
                    System.out.println("Nothing more I can do here: " + var13);
                }
            }

        }

    }
}
