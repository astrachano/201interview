import java.util.*;

public class LongestSubstring {
	public int lengthOfLongestSubstringGood(String s) {
		 if (s.length() == 0) return 0;
	        HashMap<Character,Integer> map = new HashMap<>();
	        int max = 1;
	        int start = 0;
	        map.put(s.charAt(0),0);
	        for(int index = 1; index < s.length(); index++) {
	            char ch = s.charAt(index);
	            if (map.containsKey(ch) && map.get(ch) >= start) {
	                start = map.get(ch) + 1;          
	            }
	            map.put(ch,index);      
	            max = Math.max(max,index-start+1);
	        }
	        return max;
    }
    public int lengthOfLongestSubstring(String s) {
        int max = 1;
        if (s.length() == 0) return 0;
        
        for(int j=0; j < s.length(); j++) {
            for(int k=j+1; k <= s.length(); k++) {
                String sub = s.substring(j,k);
                HashSet<Character> set = new HashSet<>();
                for(char ch : sub.toCharArray()) set.add(ch);
                if (k-j == set.size()) {
                    max = Math.max(max,k-j);
                }
            }
        }   
        return max;
    }
}
