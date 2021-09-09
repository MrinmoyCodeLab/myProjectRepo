package proxy_pattern;

public class RealInternetAccess implements OfficeInternetAccess  {

	
	
	private String userName;
	
	public RealInternetAccess(String userName) {
		this.userName = userName;
		
	}
	
	@Override
	public void grantInternetAccess() {
		System.out.println("Internate give to user : " + userName);
		
	}
	
	

}
