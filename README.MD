>对于fastjson，相对来说效率与速度比较快。但如代码所示，它封装起来比较麻烦。有一个特点就是如果po的值是为空的，它是不会转换出来的。

`fastjson:`

``` java
public static String toJsonString(Object object, final Map<Class<?>, Set<String>> filter){
		
		SerializeWriter sw = new SerializeWriter();
		JSONSerializer jsw = new JSONSerializer(sw);
		jsw.getPropertyFilters().add(new PropertyFilter() {
			
			public boolean apply(Object object, String name, Object value) {
				for(Entry<Class<?>, Set<String>> entry : filter.entrySet()) {  
		            Class<?> clazz = entry.getKey();  
		            if(object.getClass() == clazz){  
		                Set<String> fields = entry.getValue();  
		                for(String field : fields) {  
		                    if(field.equals(name)){  
		                        return false;  
		                    }  
		                }  
		            }  
		        }  
				return true;
			}
		});
		jsw.write(object);
		return sw.toString();
		
}
```

`test:`

``` java
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
```

`result:`

>{"books":["head of java"],"friends":{"good":[{}],"bad":[{}]},"name":"xluo"}

`json.lib:`

``` java
public static <T> String toObject(T t, String[] filter){
		JsonConfig config = new JsonConfig();
		config.setExcludes(filter);
		return JSONObject.fromObject(t, config).toString();
}
```

`test:`

``` java
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
```

`result:`

>{"books":["head of java"],"friends":{"good":[{"books":[],"friends":null,"password"
:""}],"bad":[{"books":[],"friends":null,"password":""}]},"password":"xluo"}

>从这里可以看出来，两个jar的实现还是不一样的。相对来说json.lib封装起来会更加简单一点。