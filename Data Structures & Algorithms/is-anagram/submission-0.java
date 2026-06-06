class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        int n = s.length();
        int m = t.length();
        int i=0;
        if(n!=m) return false;
        while(i<n){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
            i++;
        }

        for(int k=0;k<26;k++){
            if(freq[k]!=0) return false;
        }
        return true;
    }
}
