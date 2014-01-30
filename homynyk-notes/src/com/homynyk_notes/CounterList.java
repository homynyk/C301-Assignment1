package com.homynyk_notes;

import java.io.Serializable;
import java.util.ArrayList;

public class CounterList implements Serializable{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private static final long serialVersionUID = 6529685098267757690L;
	private ArrayList<Counter> counterList;

	public ArrayList<Counter> getCounterList() {
		return counterList;
	}

	public void setCounterList(ArrayList<Counter> counterList) {
		this.counterList = counterList;
	}
	
	public void addCounter(Counter counter){
		counterList.add(counter);
	}
	
	public Counter getCounter(int i){
		return counterList.get(i);
	}
	
	public CounterList() {
		super();
		counterList = new ArrayList<Counter>();
	}
	
}
