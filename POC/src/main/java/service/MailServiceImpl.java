package service;

import model.MailVO;
import model.Student;
import util.MailUtil;

public class MailServiceImpl {

	
	public void sendMail(Student std) {
		
		String name = std.getName();
		String subject = "Student details" + std.getName();
		String to = std.getEmail();
		String from = "mrinmoypodder06@gmail.com";
		String body = std.toString();
		MailVO mailvo = new MailVO(from, to, body, subject);
		MailUtil.dispatchEmail(mailvo);
		
	}
}
