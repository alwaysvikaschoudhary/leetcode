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
// Helper class to store the node and its position/index
class Solution {
    class Pair {
        TreeNode node;
        long idx;

        Pair(TreeNode node, long idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int ans = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            long min = q.peek().idx;
            long first = 0, last = 0;

            for(int i=0; i<size; i++) {
                Pair curr = q.poll();
                long idx = curr.idx-min;

                if(i == 0) first = idx;
                if(i == size-1) last = idx;

                if(curr.node.left != null)
                    q.offer(new Pair(curr.node.left, 2*idx+1));

                if(curr.node.right != null)
                    q.offer(new Pair(curr.node.right, 2*idx+2));
            }

            ans = Math.max(ans, (int)(last-first+1));
        }

        return ans;
    }
}