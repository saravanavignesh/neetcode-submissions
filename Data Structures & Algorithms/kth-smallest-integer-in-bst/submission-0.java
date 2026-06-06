/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        smallest(root, heap, k);
        return heap.peek();
    }
    public void smallest(TreeNode root, PriorityQueue<Integer> heap, int k){
        if(root==null) return;
        if(heap.size()>=k){
            if(heap.peek()>root.val){
                heap.poll();
                heap.offer(root.val);
            }
        }else{
            heap.offer(root.val);
        }
        smallest(root.left,heap,k);
        smallest(root.right,heap,k);
    }
}
