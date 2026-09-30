class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length(), curr = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(')
                arr[i] = curr++ % 2;
            else
                arr[i] = --curr % 2;
        }
        return arr;
    }
}