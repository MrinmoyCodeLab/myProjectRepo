package SimpleExample;

public class PublicMain {

	public static void main(String[] args) {
		
		ChildClass cd = new ChildClass();
		cd.getChildClass();
		cd.getParentClass();
		
		ParentClass cd1 = new ChildClass();
		cd1.getParentClass();
	}

}
