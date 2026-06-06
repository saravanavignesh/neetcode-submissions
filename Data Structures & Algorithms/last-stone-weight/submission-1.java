class Solution {
    public int lastStoneWeight(int[] stones) {
     PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
     for(int i=0;i<stones.length;i++) pq.offer(stones[i]);
     while(!pq.isEmpty()){
        int stone1 = pq.poll();
        if(pq.isEmpty()) return stone1;
        int stone2 = pq.poll();
        if(stone1<stone2){
            pq.offer(stone2-stone1);
        }else if(stone2<stone1){
            pq.offer(stone1-stone2);
        }else{
            if(pq.isEmpty()) return 0;
        }
     }
     return -1;   
    }
}
