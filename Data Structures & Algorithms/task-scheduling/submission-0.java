

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count frequencies
        Map<Character, Integer> freq = new HashMap<>();
        for (char t : tasks) {
            freq.put(t, freq.getOrDefault(t, 0) + 1);
        }
        
        // Step 2: Max heap on counts
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(freq.values());
        
        int cycles = 0;
        
        // Step 3: Process until all tasks are done
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int time = 0;
            
            // Pick up to n+1 tasks
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll() - 1);
                    time++;
                }
            }
            
            // Push remaining counts back
            for (int count : temp) {
                if (count > 0) maxHeap.offer(count);
            }
            
            // If heap is empty → all tasks done → add only the actual time taken
            cycles += maxHeap.isEmpty() ? time : (n + 1);
        }
        
        return cycles;
    }
}
