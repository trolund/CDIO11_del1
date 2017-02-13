package dal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int userId;
	private String userName;
	private String ini;
	private List<String> roles;

	public UserDTO(int userId, String userName, String ini, String role) {
		this.userId = userId;
		this.userName = userName;
		this.ini = ini;
		
		this.roles = new ArrayList<>();
		this.roles.add(role);
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getIni() {
		return ini;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void addRole(String role) {
		this.roles.add(role);
	}

	public boolean removeRole(String role) {
		return this.roles.remove(role);
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", ini=" + ini + ", roles=" + roles + "]";
	}

}