package com.kv.util;

public class ValueUtil {

	/**
	 * 判断字符串对象是否为空
	 * @param str
	 * @return
	 */
	public static boolean notNull(String str) {
		if (str != null && str.equals("")) {
			return true;
		} else {
			return false;
		}
	}
	
}
