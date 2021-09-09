package Observer;

public class ImplementObserver {

	public static void main(String[] args) {
		
		RegisterCentury registerCentury = new RegisterCentury();
		
		registerCentury.register(new SachinFan("Mrinmoy"));
		registerCentury.register(new SachinFan("Rahul"));
		registerCentury.register(new SachinFan("sanjeev"));
		
		registerCentury.sachineCentury();
	}

}
