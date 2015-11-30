package com.xluo.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.xluo.po.User;


public class JSONUtilTest {

	@Test
	public void testToJsonString(){
		
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
		
		System.out.println(FJSONUtil.toJsonString(user));
		System.out.println(FJSONUtil.toJsonString(user, true));
	}
	
	@Test
	public void testToJsonStringList(){
		
		List<Object> result = new ArrayList<Object>();
		result.add("a");
		result.add("a");
		result.add("a");
		System.out.println(FJSONUtil.toJsonString(result));
		
	}
	
	@Test
	public void testToJsonStringMap(){
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", true);
		result.put("data", new ArrayList<String>());
		System.out.println(FJSONUtil.toJsonString(result));
		
	}
	
	@Test
	public void testToJsonStringWithFilter(){
		
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
		
		System.out.println(FJSONUtil.toJsonString(user, "password", "books"));
		
	}
	
	@Test
	public void testToJsonStringWithFilter_01(){
		
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
		
		Map<Class<?>, Set<String>> filter = new HashMap<Class<?>, Set<String>>();
		Set<String> set = new HashSet<String>();
		set.add("password");
		filter.put(User.class, set);
		System.out.println(FJSONUtil.toJsonString(user, filter));
		
	}
	
	@Test
	public void testParseObject(){
		
		User user = new User();
		user.setName("xluo");
		user.setPassword("123");
		
		List<String> books = new ArrayList<String>();
		books.add("head of java");
		books.add("hadoop");
		user.setBooks(books);
		
		User u = FJSONUtil.parseObject(FJSONUtil.toJsonString(user), User.class);
		System.out.println(u);
	}
	
}
