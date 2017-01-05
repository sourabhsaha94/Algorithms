/*Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]*/

package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePairs {
	public List<List<Integer>> palindromePairs(String[] words){
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		HashMap<String,Integer> wordMap = new HashMap<>();
		
		for(int i=0;i<words.length;i++){
			wordMap.put(words[i],i);
		}
		
		for(int i=0;i<words.length;i++){
			String s = words[i];
			
			if(isPalindrome(s)){			//s and "" will be matched together
				if(wordMap.containsKey("")){
					if(wordMap.get("")!=i){
						ArrayList<Integer> l = new ArrayList<>();
						l.add(i);
						result.add(l);
						
						l=new ArrayList<>();
						l.add(wordMap.get(""));
						result.add(l);
					}
				}
			}
			
			String reversed = new StringBuilder(s).reverse().toString();
			
			if(wordMap.containsKey(reversed)){
				if(wordMap.get(reversed)!=i){
					ArrayList<Integer> l = new ArrayList<>();
					l.add(i);
					l.add(wordMap.get(reversed));
					result.add(l);
				}
			}
			
			for(int k=1;k<s.length();k++){
				String s1 = s.substring(0, k);
				String s2 = s.substring(k);
				
				if(isPalindrome(s1)){			//if first half is palindrome find reverse of entire string
					if(wordMap.containsKey(reversed)){
						if(wordMap.get(reversed)!=i){
							ArrayList<Integer> l = new ArrayList<>();
							l.add(i);
							l.add(wordMap.get(reversed));
							result.add(l);
						}
					}
				}
				
				if(isPalindrome(s2)){			//if second half palindrome find reverse of first half
					String rev = new StringBuilder(s1).reverse().toString();
					if(wordMap.containsKey(rev)){
						if(wordMap.get(rev)!=i){
							ArrayList<Integer> l = new ArrayList<>();
							l.add(i);
							l.add(wordMap.get(rev));
							result.add(l);
						}
					}

				}
				
			}
			
		}
		
		
		return result;
	}
	
	public boolean isPalindrome(String s){
		char[] charArray = s.toCharArray();
		int left=0;
		int right=s.length()-1;
		
		while(left<=right){
			if(charArray[left]!=charArray[right])
				return false;
			else{
				left++;
				right--;
			}
		}
		
		return true;
		
	}
}
