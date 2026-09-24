class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int[] ans = new int[2];
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] > maxVal) {
                    maxVal = mat[i][j];
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        return ans;
    }
}