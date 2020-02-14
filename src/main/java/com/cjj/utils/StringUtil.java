package com.cjj.utils;

/**
 * 
 * @ClassName: StringUtil
 * @Description: 字符串工具类
 * @author: changjiajia
 */
public class StringUtil {
	// 判断是否是数字
	public static boolean isNumber(String str) {
		String reg_str = "^([1-9][0-9]*)|((([0-9])|([1-9]\\d+))\\.\\d)$";
		boolean matches = str.matches(reg_str);
		return matches;
	}

	// 判断源字符串是否有值，空引号也算没值
	public static boolean isNull(String str) {
		if (null != str && !"".equals(str)) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isNotNull(String str) {
		if (null != str && !"".equals(str)) {
			return true;
		} else {
			return false;
		}
	}

	// 判断源字符串是否有值，空引号和空格也算没值
	public static boolean isNotEmpty(String str) {
		if (null != str && !"".equals(str)) {
			if (str.trim().length() == 0) {
				return false;
			}
			return true;
		}
		return false;
	}

	// 验证手机号码
	public static boolean isPhone(String str) {
		// 正则1 3456789 [abc]
		String reg_str = "^1[3-9]\\d{9}$";
		boolean matches = str.matches(reg_str);
		return matches;
	}

	// 验证邮箱
	public static boolean isEmail(String str) {
		// 正则 154565@qq.com lqd@163.cn net com.cn
		String reg_str = "^\\w+@$\\w+\\.(com|cn|net|com\\.cn)";
		boolean matches = str.matches(reg_str);
		return matches;
	}
}
