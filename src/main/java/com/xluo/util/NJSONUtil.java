package com.xluo.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 
 * Project Name: fjson 
 * Class Name: NJSONUtil 
 * Desc: 封装json的基本操作 
 * Date: 2015年11月30日下午10:26:24 
 * Copyright (c) 2015, xluocb@gmail.com All Rights Reserved. 
  *
 */
public class NJSONUtil {

	/**
	  * 
	 * @param lists
	 * @return 把list转换成json字串
	 */
	public static <T> String toArray(List<T> lists){
		return JSONArray.fromObject(lists).toString();
	}
	
	public static <T> String toArray(List<T> lists, String[] filter){
		JsonConfig config = new JsonConfig();
		config.setExcludes(filter);
		return JSONArray.fromObject(lists, config).toString();
	}
	
	/**
	 * 
	 * @param t
	 * @return 把对象转换成json字串
	 */
	public static <T> String toObject(T t){
		return JSONObject.fromObject(t).toString();
	}
	
	/**
	 * 
	 * @param t
	 * @param filter
	 * @return 返回过滤后的json字串
	 */
	public static <T> String toObject(T t, String[] filter){
		JsonConfig config = new JsonConfig();
		config.setExcludes(filter);
		return JSONObject.fromObject(t, config).toString();
	}
}
