package org.jboss.as.quickstarts.rshelloworld;

public class StudentRecord {
	
	String id;
	String name;
	public StudentRecord(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String toString(){
		return "id="+id+",name="+name;
	}
	
	public String getId(){
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
