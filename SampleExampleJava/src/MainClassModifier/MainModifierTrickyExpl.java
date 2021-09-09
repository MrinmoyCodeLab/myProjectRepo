package MainClassModifier;

import ChildModifier.ChildModifierTrickyExpl;

public class MainModifierTrickyExpl  {
	
	public static void main(String[] args) {
		
		ChildModifierTrickyExpl cd = new ChildModifierTrickyExpl();
		
		int i = cd.x;
		
		System.out.println(i);
		
	}
}



