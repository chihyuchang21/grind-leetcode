class Solution{
    public int[][] generateMatrix(int n){
        int loop = 0;   //循環次數
        int[][] res = new int[n][n];
        int start = 0;  //每次循環的開始點(start, start)
        int count = 1;  //定義填充數字
        int i,j;

        while (loop++ < n / 2){ //判斷邊界後，loop從1開始
            //模擬上端從左到右
            for (j = start; j < n - loop; j++){
                res[start][j] = count++;
            }

            //模擬右側從上到下
            for (i = start; i < n - loop; i++){
                res[i][j] = count++;
            }

            //模擬下側從右到左
            for (; j >= loop; j--){
                res[i][j] = count++;
            }

            //模擬左側從下到上
            for (; i >= loop; i--){
                res[i][j] = count++;
            }
            start++;
        }

        if (n % 2 ==1){
            res[start][start] = count;
        }

        return res;
    }
}