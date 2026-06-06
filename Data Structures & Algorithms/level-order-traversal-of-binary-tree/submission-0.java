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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderTraversal(root, result, 0);
        return result;
    }

    public void levelOrderTraversal(TreeNode root, List<List<Integer>> result, int level){
        if(root==null) return;
        if (level >= result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        levelOrderTraversal(root.left, result, level+1);
        levelOrderTraversal(root.right, result, level+1);
    }
}
