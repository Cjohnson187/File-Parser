package com.chris.parser;

import java.io.BufferedReader; // for reader writer version
import java.io.BufferedWriter; // for reader writer version
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/****************************************************************************
 * <b>Title</b>: parser.java
 * <b>Project</b>: FileParser
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2020
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Chris Johnson
 * @version 1.0
 * @since Dec 7, 2020
 * @updates:
 ****************************************************************************/
public class Parser {
	
	private String fileName;
	private String fileOut = "src/com/chris/outFiles/outFileBuffered";
	private String fileOutCaps = "src/com/chris/outFiles/outFileBufferedCaps";
	private String fileLine = null;
	private ArrayList<DataBean> beanList = new ArrayList<>();
	
	private BufferedReader reader = null;
	private BufferedWriter writer = null;
	private DataBean bean = new DataBean();
	
	/**
	 * Constructor that takes fileName.
	 * @param fileName
	 */
	public Parser(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Method to build a buffer and store the beans to an array list that is returned
	 * @return
	 * @throws IOException
	 */
	public ArrayList<DataBean> read() throws IOException {   // 3 things...
		try {
			reader = new BufferedReader(new FileReader(fileName));
			while ((fileLine = reader.readLine()) != null) {
					bean.parse(fileLine);
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
		// read a file
	}
	
	/**
	 * Method to read array list of data beans and print them to a file.
	 * @param beanList
	 * @throws IOException
	 */
	public void write(ArrayList<DataBean> beanList) throws IOException {
		try {
			writer = new BufferedWriter(new FileWriter(fileOut));
			for (DataBean bean : beanList ) {
				writer.write(bean.toString() + "\n");
			}
		}	
		catch (IOException ex) {
			System.out.println("Error writing to file- '" + fileOut + "'" );
		}	
		finally {
			writer.close();
		}
	}
	
	/**
	 * Alternate write method to write to a different file for the capitalized version
	 * @param beanList
	 * @throws IOException
	 */
	public void write(ArrayList<DataBean> beanList, String caps) throws IOException {
		try {
			writer = new BufferedWriter(new FileWriter(fileOutCaps));
			for (DataBean bean : beanList ) {
				writer.write(bean.toString() + "\n");
			}
		}	
		catch (IOException ex) {
			System.out.println("Error writing to file- '" + fileOut + "'" );
		}	
		finally {
			writer.close();
		}
	}
}
