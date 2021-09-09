package executorServiceExample;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;

public class FixedThreadPoolExcServiceExmpl {

	/*public static void main(String[] args) {
		
		
		
		Tasks task = new Tasks();
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		for(int i =0; i<5;i++) {
			service.execute(task);
		}
	}*/
	
	public static void main(String [] args){
		/*String name="WelcomeJava";
		Runnable r1=() -> System.out.println(name);
		String name1 = name.toUpperCase();
		Runnable r2=() -> System.out.println(name1);
		r1.run();*/
		
		
		
		String abe = new Adder().add(a, b);
		}

}

interface Adder {
    
    void add(String a, String b);
}
 




