package com.chris.parser;

import java.io.Serializable;
import java.util.Date;

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
	/**
	 * 
	 */
	private static final long serialVersionUID = 7885345184137145186L;
	private Date date;
	private Date time;
	private String type;
	private String from;
	private String to;
	
	/**
	 * Empty constructor for file data bean
	 */
	public DataBean() {
		super();
	}
	
	/**
	 * Date setter.
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * Time setter.
	 * @param time
	 */
	public void setTime(Date time) {
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
	public Date getDate() {
		return date;
	}
	/**
	 * Time getter.
	 * @return
	 */
	public Date getTime() {
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
	 *Override toString method for data bean.
	 */
	@Override
	public String toString() {
		return "Date- " + date + ", Time- " + time + " Type- " + type + ", From- " + from + ", To- " + to + " \n";
	}


}