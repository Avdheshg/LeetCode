class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        helper(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public void helper(int[][] image, int i, int j, int newColor, int sourceColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[i].length || image[i][j] != sourceColor) {
            return;
        }

        image[i][j] = newColor;

        helper(image, i-1, j, newColor, sourceColor);
        helper(image, i+1, j, newColor, sourceColor);
        helper(image, i, j-1, newColor, sourceColor);
        helper(image, i, j+1, newColor, sourceColor);
    }
}