package com.hcl.ms.cat.utils;

public class StringUtils {

	
	public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }
}
