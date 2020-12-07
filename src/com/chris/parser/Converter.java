package com.chris.parser;

import java.io.IOException;
import java.util.ArrayList;

/****************************************************************************
 * <b>Title</b>: converter.java
 * <b>Project</b>: FileParser
 * <b>Description: </b> This class is to instantiate the parser and convert the file data to uppercase.
 * <b>Copyright:</b> Copyright (c) 2020
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Chris Johnson
 * @version 1.0
 * @since Dec 7, 2020
 * @updates:
 ****************************************************************************/

public class Converter {
	
	final String inFile = "src/com/chris/input/master"; // should use a properties file instead
	
	/**
	 * This main method is to read, save, print, convert, and print again from the input file.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		Converter convert = new Converter();
		
		Parser parse = new Parser(convert.inFile);
		
		try {
			ArrayList<DataBean> beanList = parse.read();
			
			//parse.write(beanList);

			beanList = convert.convertCaps(beanList);

			parse.write(beanList, "caps");

		}catch(IOException ioe) {
			System.out.println("IOException- " + ioe);
		}
		

	}
	
	/*
	 * This method Converts strings to caps using the caps converter in the DataBean class.
	 */
	public ArrayList<DataBean> convertCaps(ArrayList<DataBean> beanList) { 
		for (DataBean bean : beanList) {
			bean.toCaps();
		}
		return beanList;

	}
}