
public class CloneingObjectExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ApplicationClone obj = new ApplicationClone();
		obj.i =6;
		obj.j =7;
		
		try {
			
	/*		ApplicationClone  obj2 = new ApplicationClone();
			obj2.i =obj.i;
			obj2.j =obj.j;*/
			
			
			
			//ApplicationClone obj3 = (ApplicationClone) obj2.clone();
			
			
			ApplicationClone obj1 = (ApplicationClone) obj.clone();
			obj1.i=5;
			System.out.println(obj1);
			
			//System.out.println(obj3);
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

	}

}


class ApplicationClone implements Cloneable {
	
	int i;
	int j;
	
	@Override
	public String toString() {
		return "Value return for i " + this.i + "and for j " + this.j;		
	}
	
	@Override
	protected  Object clone() throws CloneNotSupportedException {
		
			return super.clone();
	}
	
	
	
}
