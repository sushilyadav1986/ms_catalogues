package com.hcl.ms.cat.utils;

/**
 * @author SushilY
 *
 */
public class StringUtils {

	/**
	 * check null or empty string
	 * 
	 * @param str // Set string Argument in param
	 * @return boolean  // If Argument is not null or empty will return true
	 */
	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}

	/**
	 * validate email pattern
	 * 
	 * @param email // Set string Argument in param
	 * @return boolean // If argument is corrected in email pattern will return true
	 */
	public static boolean isEmailPattern(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}
}
