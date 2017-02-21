package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable, Comparable<UserDTO> {
	private static final long serialVersionUID = 1L;

	private String cpr;
	private int userId;
	private String userName;
	private String password;
	private String ini;
	private List<String> roles;

	public UserDTO(String cpr, int userId, String userName, String password, String ini, String role) {
		this.cpr = cpr;
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.ini = ini;

		this.roles = new ArrayList<>();
		this.roles.add(role);
	}
	
	public UserDTO(String cpr, int userId, String userName, String password, String ini) {
		this.cpr = cpr;
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.ini = ini;
		
		this.roles = new ArrayList<>();
	}

	@Override
	public int compareTo(UserDTO user) {
		if (user.getUserId() == this.userId) {
			return 0;
		} else if (user.getUserId() < this.userId) {
			return 1;
		}
		return -1;
	}

	public String getCpr() {
		return cpr;
	}

	public void setCpr(String cpr) {
		this.cpr = cpr;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIni() {
		return ini;
	}

	public void setIni(String ini) {
		this.ini = ini;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public void addRole(String role) {
		this.roles.add(role);
	}

	public boolean removeRole(String role) {
		return this.roles.remove(role);
	}

	@Override
	public String toString() {
		return "Bruger id: " + userId + ", Brugernavn: " + userName + ", Initialer: " + ini + ", Roller: " + roles;
	}
	
	public void addAll(List<String> roles2){
		roles.addAll(roles2);
	}

}