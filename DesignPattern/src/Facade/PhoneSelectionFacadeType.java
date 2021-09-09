package Facade;

public class PhoneSelectionFacadeType {
	
	
	private MobilePhone sumsang;
	private MobilePhone iphone;
	private MobilePhone motorola;
	
	PhoneSelectionFacadeType(){
		this.iphone = new Iphone();
		this.sumsang = new Sumsang();
		this.motorola = new Motorola();
	}
	
	
	public void getSumsung() {
		this.sumsang.getModel();
		this.sumsang.getPrice();
	}
	
	public void getIphone() {
		this.iphone.getModel();
		this.iphone.getPrice();
	}
	public void getMotorola() {
		this.motorola.getModel();
		this.motorola.getPrice();
	}
}
