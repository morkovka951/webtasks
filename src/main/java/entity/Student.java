package entity;

import java.util.Date;

public class Student extends AbstractModelIdName{

	private String last_name;
	private	String group;
	private Date date;
	
	public Student(){
		super();
	}
	
	public Student(Integer id, String name, String last_name, String group, Date date){
		super(id, name);
		this.last_name = last_name;
		this.group = group;
		this.date = date;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String first_name) {
		this.last_name = first_name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
