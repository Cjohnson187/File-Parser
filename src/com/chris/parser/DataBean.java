package com.chris.parser;

import java.io.Serializable;

/****************************************************************************
 * <b>Title</b>: dataBean.java
 * <b>Project</b>: FileParser
 * <b>Description: </b> Bean to store each line of the file.
 * <b>Copyright:</b> Copyright (c) 2020
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Chris Johnson
 * @version 1.0
 * @since Dec 2, 2020
 * @updates:
 ****************************************************************************/

public class DataBean implements Serializable {
	private String date;
	private String time;
	private String type;
	private String from;
	private String to;
	
	/**
	 * Empty constructor for file data bean
	 */
	public DataBean() {
	}
	/**
	 * Date setter.
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * Time setter.
	 * @param time
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * Type setter.
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * From setter.
	 * @param from
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * To setter.
	 * @param to
	 */
	public void setTo(String to) {
		this.to = to;
	}
	/**
	 * Date getter.
	 * @return
	 */
	public String getDate() {
		return date;
	}
	/**
	 * Time getter.
	 * @return
	 */
	public String getTime() {
		return time;
	}
	/**
	 * Type getter.
	 * @return
	 */
	public String getType() {
		return type;
	}
	/**
	 * From getter.
	 * @return
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * To getter.
	 * @return
	 */
	public String getTo() {
		return to;
	}
	
	/**
	 * Convert strings to caps
	 */
	public void toCaps() {
		type = type.toUpperCase();
		from = from.toUpperCase();
		to = to.toUpperCase();
	}
	/**
	 * Method to split each line from file reader and store each segment in the bean.
	 * Not safe if file changes format or data it contains
	 * @param line
	 */
	public void parse(String line) {
		String[] lineArray = line.split("\\s"); //  \\s = split by tab and space
		// could maybe sanitize data
		setDate(lineArray[0]);
		setTime(lineArray[1]);
		setType(lineArray[2]);
		setFrom(lineArray[3]);
		// skipping arrow character between from and to
		setTo(lineArray[5]);
	}
	/**
	 *Override toString method for data bean.
	 */
	@Override
	public String toString() {
		return "Date- " + date + ", Time- " + time + " Type- " + type + ", From- " + from + ", To- " + to + " ";
	}


}