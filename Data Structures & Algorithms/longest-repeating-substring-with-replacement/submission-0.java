class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxCharCount = 0;
        int maxLen = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxCharCount = Math.max(maxCharCount, map.get(ch));

            while ((right - left + 1) - maxCharCount > k) {

                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}