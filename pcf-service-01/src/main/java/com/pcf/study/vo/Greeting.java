/**
 *
 */
package com.pcf.study.vo;

import java.io.Serializable;

/**
 * @author Adersh.P
 *
 */
public class Greeting implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -2308310193589134702L;
	private int id;
	private String message;

	public Greeting(int id, String message) {
		this.id = id;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
