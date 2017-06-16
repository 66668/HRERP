package com.huirong.common;

import java.util.HashMap;

/**
 * 封装类
 *
 * 将用户名和密码封装到map中
 *
 * @author JackSong
 */

public class HttpParameter extends HashMap<String, String> {
	private static final long serialVersionUID = 1L;

	public static HttpParameter create() {
		HttpParameter p = new HttpParameter();
		return p;
	}
	//map集合的put方法
	public HttpParameter add(String key, String value){
		this.put(key, value);
		return this;
	}
	
	//方法重载
	public HttpParameter add(String key, int value){
		this.put(key, ""+value);
		return this;
	}
}
