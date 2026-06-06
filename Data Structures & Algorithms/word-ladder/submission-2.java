class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList); // ✅ convert to set
        if (beginWord.equals(endWord) || !dict.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                for (int pos = 0; pos < curr.length(); pos++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (curr.charAt(pos) == c) continue;
                        String newWord = curr.substring(0, pos) + c + curr.substring(pos + 1);
                        if (dict.contains(newWord) && !visited.contains(newWord)) {
                            if (newWord.equals(endWord)) return res + 1;
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }
        return 0; // ✅ not res
    }
}
