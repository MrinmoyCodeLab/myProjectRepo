package executorServiceExample;

import java.util.concurrent.Callable;

public class Tasks<Integer> implements Runnable {
	
	

	@Override
	public void run() {
		
		System.out.println("Starts Thread " + Thread.currentThread().getName());	
		
		System.out.println("Ends .....!!!");
	}

}
