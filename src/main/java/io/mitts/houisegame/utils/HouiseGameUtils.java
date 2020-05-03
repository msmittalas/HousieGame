package io.mitts.houisegame.utils;

import org.springframework.stereotype.Component;

@Component
public class HouiseGameUtils {

	public String generatePasscode() {
		
		
		return Long.toString(System.currentTimeMillis());
	}

}
