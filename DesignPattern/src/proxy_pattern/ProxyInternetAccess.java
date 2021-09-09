package proxy_pattern;

public class ProxyInternetAccess implements OfficeInternetAccess {

	
	private String userName ;
	
	private RealInternetAccess realInternetAccess;
	
	public ProxyInternetAccess(String userName) {
		this.userName =  userName;
	}
	
	
	@Override
	public void grantInternetAccess() {
		
		realInternetAccess = new RealInternetAccess(userName);
		realInternetAccess.grantInternetAccess();		
	}

}
