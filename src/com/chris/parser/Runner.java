package com.chris.parser;

import java.io.IOException;
import java.text.ParseException;

import org.apache.log4j.BasicConfigurator;

/****************************************************************************
 * <b>Title</b>: Runner.java
 * <b>Project</b>: main class to run the parser
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2020
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Chris Johnson
 * @version 1.0
 * @since Dec 8, 2020
 * @updates:
 ****************************************************************************/
public class Runner {

	public static void main(String[] args) throws IOException, ParseException {
		BasicConfigurator.configure();
		
		
		Parser parse = new Parser("files/input/master");
		
		parse.write(parse.read());
		
	}

}