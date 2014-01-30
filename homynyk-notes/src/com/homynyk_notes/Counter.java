package com.homynyk_notes;

import java.io.Serializable;

public class Counter implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static final long serialVersionUID = 6529685098267757690L;

	private String name;
	private Integer value;
	//private static final long serialVersionUID = 0L;
	
	public Counter(String name, Integer value) {
		super();
		this.name = name;
		this.value = value;
	}
	
	public Counter() {
		super();
		this.name = "something";
		this.value = 0;
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) throws Exception {
		if (name.length() > 60) {
			throw new IllegalArgumentException(); }
		this.name = name;
		}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	
	
}

	
	

