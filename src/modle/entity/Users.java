package modle.entity;

public class Users {
	private String name;
	private String password;
	private boolean admin;
	
	public Users(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public Users() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
		
	
	
}
