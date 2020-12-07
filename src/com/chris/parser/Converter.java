package com.chris.parser;

// JDK 11.x
import java.io.IOException;
import java.util.List;

// Log4J 1.2.17
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

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
	
	public static final String IN_FILE = "/files"; // should use a properties file instead
	
	private Logger log = Logger.getLogger(Converter.class);
	
	public Converter() {
		super();
		BasicConfigurator.configure();
	}
	
	/**
	 * This main method is to read, save, print, convert, and print again from the input file.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		
		Converter convert = new Converter();
		convert.log.info("Starting conversion");
		convert.process();
		convert.log.info("Ending conversion");
	}
	
	/**
	 * 
	 */
	public void process() {
		Parser parse = new Parser(IN_FILE);
		
		try {
			List<DataBean> beanList = parse.read();
			beanList = convertCaps(beanList);
			parse.write(beanList);

		}catch(IOException ioe) {
			log.error("Unable to process file", ioe);
		}
	}
	
	/*
	 * This method Converts strings to caps using the caps converter in the DataBean class.
	 */
	public List<DataBean> convertCaps(List<DataBean> beanList) { 
		for (DataBean bean : beanList) {
			bean.toCaps();
		}
		return beanList;

	}
}