package simple;

import simple.*;
import static org.junit.Assert.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;

import com.netflix.hystrix.HystrixCommand;

import com.netflix.hystrix.HystrixCommandGroupKey;
public class HelloWorldTest {

	public void testSync() {
		// TODO Auto-generated method stub
		
	}

	public void testRemoteSim() {
		// TODO Auto-generated method stub
		
	}

	

	 @Test
		public void test() throws InterruptedException, ExecutionException {
			HelloWorldCommand helloCommand = new HelloWorldCommand(" World");
	    assertEquals("Hello World", helloCommand.execute());
	 }


	
}
