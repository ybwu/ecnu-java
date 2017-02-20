public class Snake{
    public static void snake(int [][]matrix, int n, int start, int value){
        if (n == 1){
            matrix[start][start]=value;
            return;
        }
        if (n == 0)
            return;

        for (int i = 0; i < n-1; ++i)
            matrix[start][start+i] = value++;
        for (int i = 0; i < n-1; ++i)
            matrix[start+i][start+n-1] = value++;
        for (int i = 0; i < n-1; ++i)
            matrix[start+n-1][start+n-1-i] = value++;
        for (int i = 0; i < n-1; ++i)
            matrix[start+n-1-i][start] = value++;
        snake(matrix, n-2, start+1, value);
    }

    public static void main(String []args){
        int n = Integer.parseInt(args[0]);
        int [][] matrix = new int[n][n];
        snake(matrix, n, 0, 1);
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < n; ++j)
                System.out.print(matrix[i][j]+"\t");
            System.out.print("\n");
        }

    }
}
