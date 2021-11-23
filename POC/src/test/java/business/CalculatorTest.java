package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;


@TestMethodOrder(OrderAnnotation.class)
class CalculatorTest {

	
	Calculator calculator;
	
	
	
	@BeforeAll
    static void initAll() {
		System.out.println("inside @BeforeAll ");
    }

    @BeforeEach
    void init() {
    	System.out.println("inside @BeforeEach");
    	calculator = new Calculator();
    }

	
	
	@Test
	@Order(1)
	void testAdd() {
		System.out.println("Hash Value of calculator in ADD : " + calculator.toString());
		assertEquals(2, calculator.add(1, 1));
		assertNotNull(calculator.add(1, 1));
		assertNotNull(calculator.add(1, 1),"Test Passed");
	}

	@Test
	@Order(2)
	void testSub() {
		System.out.println("Hash Value of calculator in SUB : " + calculator.toString());
		assertEquals(4, calculator.sub(5, 1));
	}

	@Test
	@Order(4)
	void testMul() {
		
		System.out.println("Hash Value of calculator in MUL : " + calculator.toString());
		assertEquals(5, calculator.mul(5, 1),"this is multiplication test for successful case . ");
		assertEquals(7, calculator.mul(5, 1),"this is multiplication test for Non successful case . ");
		
	}

	@Test
	@Order(3)
	void testDevide() {
		System.out.println("Hash Value of calculator in DIV : " + calculator.toString());
		assertEquals(5, calculator.devide(5, 1),"this is divide test for successful case . ");
		assertEquals(7, calculator.devide(5, 1),"this is divide test for Non successful case . ");
	}
	
	
	@AfterEach
    void tearDown() {
		
		System.out.println("inside @AfterEach");
    }

    @AfterAll
    static void tearDownAll() {
    	
    	System.out.println("inside   @AfterAll ");
    }

}
