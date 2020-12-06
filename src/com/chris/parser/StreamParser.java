package com.chris.parser;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;



/****************************************************************************
 * <b>Title</b>: StreamParser.java
 * <b>Project</b>: FileParser
 * <b>Description: </b> The parser class will create a bean for each line 
 * 		from the input stream and store them in an array before writing using an 
 * 		output stream.
 * <b>Copyright:</b> Copyright (c) 2020
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Chris Johnson
 * @version 1.0
 * @since Dec 2, 2020
 * @updates:
 ****************************************************************************/
public class StreamParser {
	
	/**
	 * Main method to make make an input stream to read the file and later make an out put stream to write the data to a new file.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// carriage return  = 13 int/ 0D hex
		// space 			= 32 int/ 20 hex
		// tab				= 9 int
		
		String inFile = "src/com/chris/input/master";
		String outFile = "src/com/chris/outFiles/outPutStreamed";
		
		ArrayList<DataBean> beanList;
		
		StreamParser stream = new StreamParser();
		
		beanList = stream.processIn(inFile);
		
		stream.processOut(beanList, outFile);
	}

	/**
	 * Method to create the input stream and read each segment of bytes to store into a data bean and data bean to list.
	 * @param inFile
	 */
	public ArrayList<DataBean> processIn(String inFile) throws IOException {
		FileInputStream inputStream = new FileInputStream(inFile);
		ArrayList<DataBean> beanList = new ArrayList<DataBean>();
		try {
			int currentByte;
			String line = "";
			DataBean bean = new DataBean();
			while ((currentByte = inputStream.read()) != -1) {
				if(currentByte == 10) { 
					bean.parse(line); 
					beanList.add(bean);
					line = ""; 
					continue;
				}
				line += ((char) currentByte); //convert to char
			}
		}
		catch (FileNotFoundException ex){
			System.out.println("Error writing to file- '" + inFile + "'" );
		}
		finally {
			inputStream.close();
		}
		return beanList;
	}
	
	/**
	 * Method to read each bean from the bean list and and print them to a file while reading.
	 * @param beanList
	 * @param fileName
	 */
	public void processOut (ArrayList<DataBean> beanList, String fileName) throws IOException {
		FileOutputStream outStream = null;
		final byte[] lineBreak = {10};
		try {
			outStream = new FileOutputStream(fileName);
			for (DataBean bean : beanList ) {
				byte[] buffer = (bean.toString()).getBytes(); 
				outStream.write(buffer);
				outStream.write(lineBreak);
			}
		}
		catch (IOException ex) {
			System.out.println("Error writing to file- '" + fileName + "'" );
		}
		finally {
			outStream.close();
		}
	}
}