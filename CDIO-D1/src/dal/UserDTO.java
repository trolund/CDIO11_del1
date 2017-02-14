package dal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable, Comparable<UserDTO> {
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

	@Override
	public int compareTo(UserDTO user) {
		if (user.getUserId() == this.userId) {
			return 0;
		} else if (user.getUserId() < this.userId) {
			return 1;
		}
		return -1;
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
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", ini=" + ini + ", roles=" + roles + "]";
	}

}