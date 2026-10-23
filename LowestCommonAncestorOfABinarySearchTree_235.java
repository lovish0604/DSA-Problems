import javax.swing.tree.TreeNode;
import java.util.*;

public class LowestCommonAncestorOfABinarySearchTree_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(p.val<root.val && q.val<root.val){
                root=root.left;
            }
            else if(p.val>root.val && q.val>root.val){
                root=root.right;
            }
            else{
                return root;
            }
        }
        return null;

}
