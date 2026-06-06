class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> alienDict = new HashMap<>();
        for(int i=0;i<order.length();i++){
            alienDict.put(order.charAt(i),i);
        }

        for(int i=1;i<words.length;i++){
            String word1 = words[i-1];
            String word2 = words[i];
            int len = Math.min(word1.length(),word2.length());
            int index=0;
            if(word1.substring(0,len).equals(word2.substring(0,len)) && word2.length()<word1.length()){
                return false;
            }
            while(index<len){
                int a = alienDict.get(word1.charAt(index));
                int b = alienDict.get(word2.charAt(index));
                if(a<b) break;
                else if(a>b) return false;
                else index++;
            }
        }
        return true;
    }
}