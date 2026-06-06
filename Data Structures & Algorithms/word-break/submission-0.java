class Solution {
    Map<Integer,Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        map.put(s.length(),true);
        return rec(s, wordDict, 0);

    }

    public boolean rec(String s, List<String> wordDict, int index){
         if(map.containsKey(index)){
            return map.get(index);
         }

         for(String w: wordDict){
            if(index+w.length()<=s.length() && s.substring(index,index+w.length()).equals(w)){
                if(rec(s,wordDict,index+w.length())){
                    map.put(index,true);
                    return true;
                }
            }
         }
         map.put(index,false);
         return false;
    }
}
