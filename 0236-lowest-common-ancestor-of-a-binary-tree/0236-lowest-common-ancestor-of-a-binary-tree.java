/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode findlca(TreeNode root, TreeNode p, TreeNode q){
        //Base cases
        if(root==null){return root;}
        if(root==p || root==q){return root;}


        TreeNode leftlca=findlca(root.left, p, q);
        TreeNode rightlca=findlca(root.right, p, q);

        if(leftlca!=null && rightlca!=null){return root;}

        return leftlca!=null?leftlca:rightlca;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findlca(root, p, q);
    }
}