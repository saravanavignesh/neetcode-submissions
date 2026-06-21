class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int maxLen = 0;
        Set<Character> characters = new HashSet<>();
        for(int right=0;right<s.length();right++){
            if(!characters.contains(s.charAt(right))){
                characters.add(s.charAt(right));
                maxLen = Math.max(maxLen, right-left+1);
            }else{
                while(left<right){
                    if(s.charAt(left)==s.charAt(right)){
                        left++;
                        break;
                    }else{
                        characters.remove(s.charAt(left++));
                    }
                }
            }
        }
        return maxLen;
    }
}
