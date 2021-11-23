/**
 * 
 */
package business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;

import model.Student;
import service.MailServiceImpl;

/**
 * @author Home
 *
 */
class StudentReportTest {
	
	private static List<Student> studentList = new ArrayList<Student>();
	StudentReport studentReport = null;
	
	@InjectMocks
	private StudentReport studentReport1 = new StudentReport(); 
	 
	
	@BeforeAll
    static void initAll() {
		studentList.add(new Student("A",1,"a","abc@gmail.com",40));
		studentList.add(new Student("B",2,"b","bcd@gmail.com",40));
		System.out.println("inside @BeforeAll ");
    }

    @BeforeEach
    void init() {
    	System.out.println("inside @BeforeEach");
    	studentReport = new StudentReport();
    	
    }
	
    @AfterEach
    void tearDown() {
		
		System.out.println("inside @AfterEach");
    }

    @AfterAll
    static void tearDownAll() {
    	
    	System.out.println("inside   @AfterAll ");
    }


	/**
	 * Test method for {@link business.StudentReport#displayStudentDetails(java.lang.Integer)}.
	 */
	@Test
	@DisplayName("Display Student Details")
	@ParameterizedTest(name="testDisplayStudentDetails : index -> {index} : value -> {arguments}")
	@ValueSource(ints = {1,23,45,89})
	void testDisplayStudentDetails(Integer roll) {
		StudentReport studentReport = new StudentReport();
		studentReport.setStudentList(studentList);
		studentReport.displayStudentDetails(roll);
	}

	/**
	 * Test method for {@link business.StudentReport#checkifStudentPassed(model.Student)}.
	 */
	/*@Test
	void testCheckifStudentPassed() {
		fail("Not yet implemented");
	}*/

	/**
	 * Test method for {@link business.StudentReport#sendStudentReportInMail()}.
	 */
	@Test
	void testSendStudentReportInMail() {
		studentReport.setStudentList(studentList);
		
		Student student = new Student("B",2,"b","bcd@gmail.com",40);
		studentReport.setStudent(student);	
		
		MailServiceImpl mailServiceImpl = Mockito.mock(MailServiceImpl.class);
		studentReport.setMailServiceImpl(mailServiceImpl);
		
		StudentReport  sdtRpt =  Mockito.spy(studentReport);
		
		//Mockito.doReturn(true).when(sdtRpt).checkifStudentPassed(student);
		
		//when(sdtRpt.checkifStudentPassed(any(Student.class))).thenReturn(true);
		
		try {
			boolean bb = Whitebox.invokeMethod(studentReport1, "checkifStudentPassed",student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sdtRpt.sendStudentReportInMail();
		
		Mockito.verify(mailServiceImpl,Mockito.times(1)).sendMail(student);
		
	}

}
