package Observer;

import java.util.*;

public class RegisterCentury {
	List<SachinFan> sachineFan = new ArrayList<SachinFan>();
	
	
	public void register(SachinFan fan) {
		this.sachineFan.add(fan);
	}
	
	public void sachineCentury() {
		for(SachinFan fan : sachineFan) {
			fan.notified();
		}
	}

}
