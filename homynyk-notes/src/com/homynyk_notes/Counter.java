package com.homynyk_notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Counter implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String name;
	private Integer value;
	private ArrayList<Date> date_list;
	
	public Counter() {
		super();
	}
	
	public Counter(String name, Integer value) {
		super();
		this.name = name;
		this.value = value;
		this.date_list = new ArrayList<Date>();
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
	
	public void addDate(Date new_date){
		if (date_list != null){
			date_list.add(new_date);
			//System.out.println("ADDING MORE DATES");
		}
		else {
			this.date_list = new ArrayList<Date>();
			date_list.add(new_date);
			//System.out.println("ADD DATE TO NEW LIST");
		}
	}
	
}

	
	

