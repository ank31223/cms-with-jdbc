package com.infoobjects.cmslm.utils;

public class CommonUtils {
	
	private static int i=1;
	
	private CommonUtils() {
		
	}

	public static int generateId() {
		return i++;
	}
}
