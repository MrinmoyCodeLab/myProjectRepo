package business;

import java.util.List;

import model.Student;
import service.MailServiceImpl;

public class StudentReport {
	
	private List<Student> studentList;
	private Student student;
	private MailServiceImpl mailServiceImpl;
	
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public void setMailServiceImpl(MailServiceImpl mailServiceImpl) {
		this.mailServiceImpl = mailServiceImpl;
	}
	
	public void displayStudentDetails(Integer rollno) {		
		if(null!= this.studentList ) {
			for(Student student :  this.studentList) {
				System.out.println("Name : " + student.getName() );
				System.out.println("Name : " + student.getSection() );
				System.out.println("Name : " + student.getTotalMarks());
				
			}
		}
	}
	
	
	
	private boolean checkifStudentPassed(Student student) {
		
		System.out.println("Inside checkifStudentPassed " );		
		if(null != this.studentList && null!= student ) {
			for(Student std :  this.studentList) {
				if(student.getRollno().equals(std.getRollno())) {					
					if(student.getTotalMarks() > 40) {
						return true;
					}
				}
			}
		}
		return false;
		
	}
	
	
	public void sendStudentReportInMail() {		
		System.out.println("Inside checkifStudentPassed " );			
		if(checkifStudentPassed(this.student)) {
			this.mailServiceImpl.sendMail(this.student);
		}
	}
	
	

}
