import base.IBasicsIO;
import base.IWriteReadObject;
import base.BasicsIO;

import java.io.*;

public class WriteReadObject implements IWriteReadObject {

	@Override
	public Object readObject(String path) {
		// we need to find a way to open file (you may think about usage of IBasicIO)
		//TODO put code here!		
		IBasicsIO basicIO = new BasicsIO();
		File file = basicIO.openFile(path);
		
		Object readedObject = null;
		
		if(file!= null && file.exists()) {
			ObjectInputStream stream = null;
			try {
				/* here we should create stream and read data
				 * Help - we need to read whole object at once, think about ObjectInputStream
				 *      - this stream is just decorator to other streams, so you will need to create other one as well,
				 *        check out FileInputStream here
				 *      - think about readObject method in ObjectInputStream
				 */
				//TODO put code here!
				stream = new ObjectInputStream(new FileInputStream(file));
				readedObject = stream.readObject();
			} catch (IOException | ClassNotFoundException e) {
				System.out.println(e);
			} finally {
				// here we need to clean up nothing to do for you
				if(stream!=null) {
					try {
						stream.close();
					} catch (IOException e) {
						System.out.println("Nothing more I can do here: " + e);
					}
				}
			}
		}
		
		System.out.println("Readed from:   " + path + " object: " + readedObject.getClass() + " with data: " + readedObject.toString());
		
		return readedObject;
	}

	@Override
	public void writeObject(String path, Object toWrite) {
		System.out.println("Will write to: " + path + " object: " + toWrite.getClass() + " with data: " + toWrite.toString());
		
		ObjectOutputStream stream = null;
		try {
			/*
			 * We need to open file and write data into it (you may think about usage of IBasicIO)
			 * Help - we need to write whole object at once - think about ObjectOutputStream
			 * 	    - ObjectOUtputStream is decorator for other streams, so you first need to create different one 
			 *        (maybe FileOutputStream)
			 *      - check out writeObject method on ObjectOutputStream
			 */
			//TODO put code here!
			IBasicsIO basicIO = new BasicsIO();
			File file = basicIO.openAndCreateFile(path);

			stream = new ObjectOutputStream(new FileOutputStream(file));
			stream.writeObject(toWrite);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			// here we need to clean up
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
