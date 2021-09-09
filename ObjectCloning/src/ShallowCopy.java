
public class ShallowCopy {

	
	/**
	 * We will learn here 
	 * Shallow Copy
	 * Deep Copy
	 * Clone Methos
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Shallow Copy example 
		
		
		App app = new App();
		app.i =6;
		app.j =7;
		
		App app1 = app;
		
		app1.i=9;
		app1.j=10;
		
		System.out.println(app1); //output 9 & 10
		System.out.println(app);  //output should be 6 & 7 but coming 9 & 10 ------it is shallow copy
		
		//Creating two ref for one object
		
		//Deep Copy
		
		
		App appOriginal = new App();
		appOriginal.i =6;
		appOriginal.j =7;
		
		App app2 = new App();
		
		app2.i = appOriginal.i;
		app2.j = appOriginal.j;
		System.out.println(app2);//out put =====It is deep copy : 6 & 7
		
		System.out.println(app); 
	}

}
	class App  {
		
		int i;
		int j;
		
		@Override
		public String toString() {
			return "Value return for i " + this.i + "and for j " + this.j;		
		}
		
	}

