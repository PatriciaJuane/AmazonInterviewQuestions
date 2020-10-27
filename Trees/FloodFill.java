class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color == newColor) return image;
        dfs(image, color, sr, sc, newColor);
        return image;
    }
    
    public void dfs(int[][] image, int color, int sr, int sc, int newColor) {
        //caso base -> limites de la matriz y color diferente al previo
        if(sr < 0 || sc <0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }
        
        image[sr][sc] = newColor;
        dfs(image, color, sr-1, sc, newColor);
        dfs(image, color, sr, sc-1, newColor);
        dfs(image, color, sr+1, sc, newColor);
        dfs(image, color, sr, sc+1, newColor);
    }
   
}
