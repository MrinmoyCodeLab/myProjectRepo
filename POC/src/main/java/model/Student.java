package model;

public class Student {

	
	private String name;
	private Integer rollno;
	private String section;
	private String email;
	private Integer totalMarks;
	
	
	
	
	
	public Student(String name, Integer rollno, String section, String email, Integer totalMarks) {
		super();
		this.name = name;
		this.rollno = rollno;
		this.section = section;
		this.email = email;
		this.totalMarks = totalMarks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRollno() {
		return rollno;
	}
	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}
	
	
}
