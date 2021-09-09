package simple;


import com.netflix.hystrix.HystrixCommand;

import com.netflix.hystrix.HystrixCommandGroupKey;

public class HelloWorldCommand  extends HystrixCommand<String>  {


  private final String name;
		public HelloWorldCommand(String name) {
			super(HystrixCommandGroupKey.Factory.asKey("default"));
			this.name = name;
		}
	   @Override
	   protected String run() throws Exception {

		 return "Hello" + name;
	   }

	}