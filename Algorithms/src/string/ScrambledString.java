/*Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.*/

package string;

import java.util.HashMap;

public class ScrambledString {
	public static boolean checkScrambled(String s1, String s2){
		
		HashMap<Character,Integer> firstString = new HashMap<Character,Integer>();
				
		int temp=0;
		
		char[] charArray1 = s1.toCharArray();
		
		for(char c:charArray1){				//create the map
			if(firstString.containsKey(c)){
				temp=firstString.get(c);
				firstString.put(c, temp+1);
			}
			else{
				firstString.put(c, 1);
			}
		}
		
		char[] charArray2 = s2.toCharArray();
		
		for(char c:charArray2){				//update the map
			if(firstString.containsKey(c)){
				if(firstString.get(c)==0){
					return false;
				}
				else{
					temp=firstString.get(c);
					firstString.put(c, temp-1);
				}
			}else
			{
				return false;
			}
		}
		
		for(char c:charArray1){				//check the map
			if(firstString.get(c)!=0)
				return false;
		}
		
		return true;
	}
}
