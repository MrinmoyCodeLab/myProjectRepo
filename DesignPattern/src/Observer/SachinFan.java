package Observer;

public class SachinFan {

	private String name;

	public SachinFan(String name ) {
		this.name= name;
	}
	
	public void notified() {
		System.out.println(this.name + "" + "Notified that sachine made 100");
	}
	

}
