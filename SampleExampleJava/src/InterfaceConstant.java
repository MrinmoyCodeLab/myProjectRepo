
public class InterfaceConstant implements foo{

	@Override
	public void getfoo() {
		int ab=89; //cant take it from foo interface and it will give compilation error
		System.out.println("value" + ab);
	}
	
}


interface foo {
	
	public void getfoo();
	
	int ab=76;
	
} 