package hu.schonherz.training.records;

import java.io.Serializable;

public class User implements Serializable {

	private int id;
	private String userName;
	private String address;
	private int age;
	private String password;

	public User(int _id, String _userName, String _address) {
		id = _id;
		userName = _userName;
		address = _address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
