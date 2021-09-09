
class FirstThread implements Runnable{

	@Override
	public void run() {
		
		for(int i =0 ; i<2;i++) {
			System.out.println("FirstThread is executing" + i);
		}
		
		
	}
	
}


class SecondThread implements Runnable{

	@Override
	public void run() {
		
		for(int i =0 ; i<2;i++) {
			System.out.println("2ndThread is executing" + i);
		}
		
	}
	
}


public class ThreadJoinTest {
	
	public static void main(String[] args) {
		
		
		FirstThread ft = new FirstThread();
		Thread th = new Thread(ft);
		th.start();
		try {
			th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SecondThread st = new SecondThread();
		Thread th1 = new Thread(st);
		th1.start();
	}
}
