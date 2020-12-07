package com.chris.parser;

import java.io.BufferedReader; // for reader writer version
import java.io.BufferedWriter; // for reader writer version
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/****************************************************************************
 * <b>Title</b>: parser.java
 * <b>Project</b>: FileParser
 * <b>Description: </b> THis class parses each line in the file using a buffer, can print, 
 * and returns the data in an arrayList of beans to be converted.
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
	private Logger log = Logger.getLogger(Parser.class);
	
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
	public List<DataBean> read() throws IOException { 
		List<DataBean> beanList = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String fileLine;
			while ((fileLine = reader.readLine()) != null) {
					beanList.add(parse(fileLine));
			}
		} catch (FileNotFoundException e) {
			log.error("Unable to open file- '" + fileName + "'", e);
		}
		
		return beanList;
		// read a file
	}
	
	public DataBean parse(String line) {
		DataBean db = new DataBean();
		String[] lineArray = line.split("\\s"); //  \\s = split by tab and space
		
		// could maybe sanitize data
		db.setDate(lineArray[0].trim());
		db.setTime(lineArray[1].trim());
		db.setType(lineArray[2].trim());
		db.setFrom(lineArray[3].trim());
		
		return db;
	}
	
	/**
	 * Method to read array list of data beans and print them to a file.
	 * @param beanList
	 * @throws IOException
	 */
	public void write(List<DataBean> beanList) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut))) {
			
			for (DataBean bean : beanList ) {
				writer.write(bean.toString());
			}
		} catch (IOException ex) {
			log.error("Error writing to file- '" + fileOut + "'", ex );
		}
	}
}
