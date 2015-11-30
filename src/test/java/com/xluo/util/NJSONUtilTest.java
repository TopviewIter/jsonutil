package com.xluo.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.xluo.po.User;

public class NJSONUtilTest {

	@Test
	public void testToArray() {
		List<String> lists = new ArrayList<String>();
		lists.add("xiaoming");
		lists.add("xiaoluo");
		System.out.println(NJSONUtil.toArray(lists));
	}
	
	@Test
	public void testToObject(){
		
		User user = new User();
		user.setName("xluo");
		user.setPassword("xluo");
		
		List<String> books = new ArrayList<String>();
		books.add("head of java");
		user.setBooks(books);
		
		Map<String, Object> friends = new HashMap<String, Object>();
		List<User> goodFriends = new ArrayList<User>();
		goodFriends.add(new User());
		List<User> badFriends = new ArrayList<User>();
		badFriends.add(new User());
		friends.put("good", goodFriends);
		friends.put("bad", badFriends);
		user.setFriends(friends);
		
		System.out.println(NJSONUtil.toObject(user));
		
	}
	
	@Test
	public void toObjectWithFilter(){
		User user = new User();
		user.setName("xluo");
		user.setPassword("xluo");
		
		List<String> books = new ArrayList<String>();
		books.add("head of java");
		user.setBooks(books);
		
		Map<String, Object> friends = new HashMap<String, Object>();
		List<User> goodFriends = new ArrayList<User>();
		goodFriends.add(new User());
		List<User> badFriends = new ArrayList<User>();
		badFriends.add(new User());
		friends.put("good", goodFriends);
		friends.put("bad", badFriends);
		user.setFriends(friends);
		
		System.out.println(NJSONUtil.toObject(user, new String[]{"name"}));
	}

}
