class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;

        int pcolor = image[sr][sc];

        flood(image, sr, sc, pcolor, color);
        return image;
    }

    public void flood(int[][] image, int sr, int sc, int pcolor, int color) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) return;
        if(image[sr][sc] == color || image[sr][sc] != pcolor) return;
        
        if(image[sr][sc] == pcolor) image[sr][sc] = color;
        
        flood(image, sr+1, sc, pcolor, color);
        flood(image, sr-1, sc, pcolor, color);
        flood(image, sr, sc+1, pcolor, color);
        flood(image, sr, sc-1, pcolor, color);
    }
}