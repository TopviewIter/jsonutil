package com.xluo.util;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

/**
 * 
 * Project Name: fjson 
 * Class Name: JSONUtil 
 * Desc: 封装json的基本操作 
 * Date: 2015年11月30日下午3:52:19 
 * Copyright (c) 2015, xluocb@gmail.com All Rights Reserved.
 *
 */
public class FJSONUtil {

	public static String toJsonString(Object object) {
		return toJsonString(object, false);
	}

	/**
	 * 
	 * @param object
	 * @param format
	 *            : 是否格式化json
	 * @return
	 */
	public static String toJsonString(Object object, boolean format) {
		return JSON.toJSONString(object, format);
	}

	/**
	 * 
	 * @param object
	 * @param leaveProperties
	 *            必要的属性
	 * @return
	 */
	public static String toJsonString(Object object, String... leaveProperties) {
		return JSON.toJSONString(object,
				new SimplePropertyPreFilter(object.getClass(), leaveProperties));
	}
	
	/**
	  * 
	 * @param object
	 * @param filter 通过Map来指定要过滤掉那个类的那些字段
	 * @return
	 */
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
	
	/**
	 * 把json转成相应的对象
	 * 
	 * @param text
	 * @param clazz
	 * @return
	 */
	public static <T> T parseObject(String text, Class<T> clazz) {
		return JSON.parseObject(text, clazz);
	}

}
