package base;

import org.junit.jupiter.api.BeforeEach;

import java.io.*;
import java.util.Arrays;

public abstract class WriteReadTestBase {
    protected static final byte[] TEXT_ARRAY = "Some random text :)".getBytes();
    protected File emptyFile;
    protected File fullFile;
    private String nameEmptyFile = "data/writenObject.dat";
    private String nameFullFile = "data/objectToBeReaded.dat";
    public WriteReadTestBase() {
    }

    @BeforeEach
    public void before() {
        this.emptyFile = new File(nameEmptyFile);
        this.fullFile = new File(nameFullFile);
        this.removeIfExist(this.emptyFile);
        this.removeIfExist(this.fullFile);
    }

    private void removeIfExist(File file) {
        if (file != null && file.exists()) {
            file.delete();
        }

    }

    protected Object readObject(File file) {
        Object readedObject = null;
        if (file != null && file.exists()) {
            ObjectInputStream stream = null;

            try {
                stream = new ObjectInputStream(new FileInputStream(file));
                readedObject = stream.readObject();
            } catch (ClassNotFoundException | IOException var13) {
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

        return readedObject;
    }

    protected void writeObject(File file, Object toWrite) {
        ObjectOutputStream stream = null;

        try {
            file.createNewFile();
            stream = new ObjectOutputStream(new FileOutputStream(file));
            stream.writeObject(toWrite);
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

    protected byte[] readData(File file) {
        byte[] array = null;
        if (file != null && file.exists()) {
            FileInputStream stream = null;

            try {
                array = new byte[(int)file.length()];
                stream = new FileInputStream(file);
                stream.read(array, 0, array.length);
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

        System.out.println("Readed data: " + Arrays.toString(array));
        return array;
    }

    protected void writeData(File file, byte[] data) {
        FileOutputStream stream = null;

        try {
            stream = new FileOutputStream(file);
            stream.write(data, 0, data.length);
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
}

