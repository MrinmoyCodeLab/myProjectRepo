package verf;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.concurrent.ExecutionException;

import org.junit.Test;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import simple.HelloWorldCommand;
import simple.HelloWorldTest;
import simple.RemoteServiceClient;
import simple.RemoteServiceSimulator;

public class HelloTest {
	@Test
	public void test() throws InterruptedException, ExecutionException {
		HelloWorldCommand helloWorldCommand = new HelloWorldCommand(" World");
		assertEquals("Hello World", helloWorldCommand.execute());
		
		HelloWorldTest ts= new HelloWorldTest();
		ts.testSync();
		
	    HystrixCommand.Setter config = HystrixCommand
	  	      .Setter
	  	      .withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceGroup2"));
	  	     
	  	    assertThat(new RemoteServiceClient(config, new RemoteServiceSimulator(100)).execute(),
	  	      equalTo("Success"));
	  	    
	  	  ts.testRemoteSim();
	}
}
