package com.chris.parser;

import java.io.BufferedReader; // for reader writer version
import java.io.BufferedWriter; // for reader writer version
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/****************************************************************************
 * <b>Title</b>: BufferParser.java
 * <b>Project</b>: FileParser
 * <b>Description: </b> The parser class will create a bean for each line 
 * 		from the buffer and store them in an array before writing using a buffer. 
 * <b>Copyright:</b> Copyright (c) 2020
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Chris Johnson
 * @version 1.0
 * @since Dec 2, 2020
 * @updates:
 ****************************************************************************/
public class BufferParser {
	
	
/**
 * Main method to call to run the in file process and leter call the outfile process.
 * @param args
 * @throws IOException
 */
	public static void main(String[] args) throws IOException {
		String fileIn = "src/com/chris/input/master";
		String fileOut = "outFileBuffered";
		
		ArrayList<DataBean> beanList;
		
		BufferParser parser = new BufferParser();
		
		beanList = parser.processIn(fileIn);
		parser.ProcessOut(beanList, fileOut);
	}
	
	/**
	 * Method to process the in file and store each line segment into each bean object.
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public ArrayList<DataBean> processIn(String fileName) throws IOException {
		ArrayList<DataBean> beanList = new ArrayList<>();
		String line = null;
		BufferedReader reader = null;
		DataBean bean = new DataBean();
		try {
			reader = new BufferedReader(new FileReader(fileName));
			while ((line = reader.readLine()) != null) {
					bean.parse(line);
					beanList.add(bean);
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Unable to open file- '" + fileName + "'");
		}
		finally {
			reader.close();			
		}
		return beanList;
	}
	
	/**
	 * Method to read each bean pulled from the file and print the formatted versions of the data.
	 * @param beanList
	 * @param fileName
	 * @throws IOException
	 */
	public void ProcessOut(ArrayList<DataBean> beanList, String fileName) throws IOException {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			for (DataBean bean : beanList ) {
				writer.write(bean.toString() + "\n");
			}
		}	
		catch (IOException ex) {
			System.out.println("Error writing to file- '" + fileName + "'" );
		}	
		finally {
			writer.close();
		}
	}
	
}
