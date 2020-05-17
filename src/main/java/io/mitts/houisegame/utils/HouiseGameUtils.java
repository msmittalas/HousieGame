package io.mitts.houisegame.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.springframework.stereotype.Component;

@Component
public class HouiseGameUtils {

	public String generatePasscode() {
		
		
		return Long.toString(System.currentTimeMillis());
	}
	
	public static  Integer getRandomNumberBetween(int minimum,int maximum,Collection<Integer> excludedNumbers)
	{
		Integer randomNumber=0;
		
		do
		{
			randomNumber=(minimum + (int)(Math.random() * maximum));
		}
		while(excludedNumbers.contains(randomNumber));
		return  randomNumber;
	}
	
}
