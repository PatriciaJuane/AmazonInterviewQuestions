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
class Solution {   // simple BFS/Level order traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> list = new LinkedList<>();
        if(root==null) return list;
        
        // BFS -> queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean par = true;
        
        while(!queue.isEmpty()) {
            int n = queue.size();
            LinkedList<Integer> subList = new LinkedList<>();
            
            for(int i=0; i<n; i++) { // para cada nivel, añadir nodos en el sentido que corresponda
                TreeNode actual = queue.poll();
                if(actual.left != null) {
                    queue.add(actual.left);
                }
                if(actual.right != null) {
                    queue.add(actual.right);
                }
                
                if(par) {
                    subList.add(actual.val);
                } else {
                    subList.addFirst(actual.val); 
                }
            }
            
            list.add(subList);
            par = !par;
        }
        
        return list;
    }
}