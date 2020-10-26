/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution { // complejidad O(n) temporal y espacial
    
    private TreeNode answer;
    
    public Solution() {
      // Variable to store LCA node.
        this.answer = null;
    }
    
    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) { // DFS
        // If reached the end of a branch, return false.
        if(currentNode==null) { // caso base de nuestro algoritmo recursivo
            return false;
        }
        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
        // If any two of the flags left, right or mid become True
        if(mid + left + right >= 2) {
            this.answer = currentNode; // lowest common ancestor
        }
        return (mid + left + right > 0); // return true si alguna de las 3 variables es True.
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.recurseTree(root, p, q);
        return this.answer;
    }
}