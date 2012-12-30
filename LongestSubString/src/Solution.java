
import java.util.*;
public class Solution {
	public int lengthOfLongestSubstring(String s) {
		if(s.isEmpty()){
			return 0;
		}
		
		int max=0;
		int tmp=0;
		int l=s.length();
		int startIndex=0;
		int endIndex=0;
		HashMap<Character,Integer> hash=new HashMap<Character,Integer>();
		for(int i=0;i<l;i++){
			endIndex=i;
			char currChar=s.charAt(i);
			//if met a repeated
			if(hash.containsKey(currChar)){
				tmp=endIndex-startIndex;
				if(tmp>max){
					max=tmp;
//					String tmpStr=s.substring(startIndex,endIndex);
//					System.out.println(tmpStr);
				}
				int firstRepeatIndex=hash.get(currChar);
				//remove all letters before first repeated(including 1st repeated), but this is a loop so doesn't work
				
				for(int j=startIndex;j<=firstRepeatIndex;j++){
					
						hash.remove(s.charAt(j));
					
					
				}
				
				//add the second repeated letter
				hash.put(currChar, i);
				startIndex=firstRepeatIndex+1;
			}
			//put new letters in
			else{
				hash.put(currChar, i);
			}
				
		}
		if(hash.size()>max){
			max=hash.size();
		}
		
        return max;
    }
	
	public static void main(String args[]){
		int max=0;
		String input="abcabcde";
		max=new Solution().lengthOfLongestSubstring(input);
		System.out.println(max);
	}

}
