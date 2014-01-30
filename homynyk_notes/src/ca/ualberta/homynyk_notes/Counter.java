package ca.ualberta.homynyk_notes;

public class Counter {
	
	private String name;
	private Integer value;
	
	public Counter(String name, Integer value) {
		super();
		this.name = name;
		this.value = value;
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
