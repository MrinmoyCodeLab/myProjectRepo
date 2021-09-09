package Facade;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PhoneSelectionFacadeType phoneSelectionFacadeType = new PhoneSelectionFacadeType();
		
		int i = 1;
		
		switch (i) {
		case 1:
			phoneSelectionFacadeType.getIphone();
			break;
		case 2:
			phoneSelectionFacadeType.getMotorola();
			break;
		case 3:
			phoneSelectionFacadeType.getSumsung();
			break;
		default:
			break;
		}	
		
	}

}
