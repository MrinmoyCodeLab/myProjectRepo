package Facade;

public interface MobilePhone {

	
	public void getPrice();
	public void getModel();
	
	default void getValue() {
		System.out.println("Default Method");
	}
	
	public static void getStatic() {
		System.out.println("Static Method");
	}
	
	
	
}
