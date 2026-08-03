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
    class Tuple {
        TreeNode node;
        int row, col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root, 0, 0));

        while(!q.isEmpty()) {
            Tuple curr = q.poll();

            map.putIfAbsent(curr.col, new TreeMap<>());
            map.get(curr.col).putIfAbsent(curr.row, new PriorityQueue<>());
            map.get(curr.col).get(curr.row).offer(curr.node.val);

            if(curr.node.left != null) {
                q.offer(new Tuple(curr.node.left, curr.row+1, curr.col-1));
            }

            if(curr.node.right != null) {
                q.offer(new Tuple(curr.node.right, curr.row+1, curr.col+1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> list = new ArrayList<>();

            for(PriorityQueue<Integer> pq : rows.values()) {
                while(!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }

            ans.add(list);
        }

        return ans;
    }
}