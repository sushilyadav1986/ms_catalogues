package com.hcl.ms.cat.utils;

/**
 * @author SushilY
 *
 */
public class StringUtils {

	/**check null or empty string
	 * @param str
	 * @return boolean
	 */
	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}

	/**validate email pattern
	 * @param email
	 * @return boolean
	 */
	public static boolean isEmailPattern(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}
}
