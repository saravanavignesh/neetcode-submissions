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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return deleteLeaf(root, new TreeNode(-1), false, target);

    }

    public TreeNode deleteLeaf(TreeNode root, TreeNode parent, boolean isLeft, int target){
        if(root==null) return root;
        deleteLeaf(root.left, root, true, target);
        deleteLeaf(root.right, root, false, target);
        if(todeleteLeaf(root, target)){
            if(parent.val==-1) return null;
            if(isLeft) parent.left = null;
            else parent.right = null;
        }
        return root;
    }

    public boolean todeleteLeaf(TreeNode node, int target){
        return node.left==null && node.right==null && node.val==target;
    }

}