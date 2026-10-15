import javax.swing.tree.TreeNode;

public class LowestCommonAncestorofaBinaryTree_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode leftChild=lowestCommonAncestor(root.left,p,q);
        TreeNode rightChild=lowestCommonAncestor(root.right,p,q);
        if(leftChild==null){
            return rightChild;
        }
        else if(rightChild==null){
            return leftChild;
        }
        else{
            return root;
        }
    }

}
