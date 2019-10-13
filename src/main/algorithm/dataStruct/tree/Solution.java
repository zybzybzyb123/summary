package algorithm.dataStruct.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class Solution {
    //非递归中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}