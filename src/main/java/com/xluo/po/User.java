package com.xluo.po;

import java.util.List;
import java.util.Map;

public class User {

	private String name;
	private String password;
	private List<String> books;
	private Map<String, Object> friends;
	
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

	public List<String> getBooks() {
		return books;
	}

	public void setBooks(List<String> books) {
		this.books = books;
	}

	public Map<String, Object> getFriends() {
		return friends;
	}

	public void setFriends(Map<String, Object> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", books="
				+ books + ", friends=" + friends + "]";
	}
	
}
