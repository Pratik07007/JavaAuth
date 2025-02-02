package app;




public class ReturnedUser {
	boolean success;
	String msg;
	Users user;
	
	
	public ReturnedUser(boolean success,String msg,Users user) {
		this.success=success;
		this.msg=msg;
		this.user= user;
	}
	
	

}