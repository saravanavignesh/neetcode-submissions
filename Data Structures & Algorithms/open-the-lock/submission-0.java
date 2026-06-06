class Solution {
    public int openLock(String[] deadends, String target) {
    Set<String> dead = new HashSet<>(Arrays.asList(deadends));
    Set<String> visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.offer("0000");
    visited.add("0000");
    int moves = 0;

    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String curr = queue.poll();
            if (dead.contains(curr)) continue;
            if (curr.equals(target)) return moves;

            for (int j = 0; j < 4; j++) {
                char[] chars = curr.toCharArray();
                // Turn wheel up
                chars[j] = chars[j] == '9' ? '0' : (char)(chars[j] + 1);
                String up = new String(chars);
                if (!visited.contains(up) && !dead.contains(up)) {
                    queue.offer(up);
                    visited.add(up);
                }
                // Turn wheel down
                chars[j] = curr.charAt(j) == '0' ? '9' : (char)(curr.charAt(j) - 1);
                String down = new String(chars);
                if (!visited.contains(down) && !dead.contains(down)) {
                    queue.offer(down);
                    visited.add(down);
                }
            }
        }
        moves++;
    }
    return -1;
}
}