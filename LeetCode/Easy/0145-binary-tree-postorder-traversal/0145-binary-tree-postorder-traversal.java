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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        TreeNode curr=root;
        if(curr==null) {
            return new ArrayList<>();
        }
        TreeNode lastPrinted=null;
        while(curr!=null || !stack.isEmpty()) {
            if(curr!=null)  {
                stack.push(curr);
                curr=curr.left;
            }
            else {
                TreeNode node=stack.peek();
                if(node.right==null || node.right==lastPrinted) {
                    ans.add(node.val);
                    lastPrinted=stack.pop();
                }
                else {
                    curr=node.right;
                }
            }
        }
        return ans;
    }
}