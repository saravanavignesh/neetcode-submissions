class Solution {
    public String minWindow(String s, String t) {
        int left=0;
        int need=0;
        int have=0;
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> needMap = new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1);
        }
        have=map.size();
        System.out.println("have:"+have);
        int minLen = Integer.MAX_VALUE;
        String result = "";
        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);
            System.out.println("left:"+left+" right:"+right+" char:"+c);
            needMap.put(c,needMap.getOrDefault(c,0)+1);
            if(map.containsKey(c) && needMap.get(c).intValue() == map.get(c).intValue()){
                need++;
            }
            if(need==have){
                while(need==have){
                    if(right - left + 1 < minLen){
                        minLen = right - left + 1;
                        result = s.substring(left, right + 1);
                    }
                    //System.out.println("result:"+result);
                    char r = s.charAt(left++);
                    needMap.put(r, needMap.get(r)-1);
                    //System.out.println("left:"+left+" right:"+right+" r:"+r);
            
                    if(map.containsKey(r) && needMap.get(r) < map.get(r)){
                        need--;
                    }
                }
            }
        }
        return result;

    }
}
