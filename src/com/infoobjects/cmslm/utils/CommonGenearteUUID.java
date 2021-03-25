package com.infoobjects.cmslm.utils;

import java.util.UUID;

public class CommonGenearteUUID {
	private CommonGenearteUUID() {

	}

	public static String generateId() {
		UUID uuid = UUID.randomUUID();
		String uuString = uuid.toString();
		return uuString;
	}

}
