public class Hadamard{

    public static void hadamard(
            int [][]matrix,
            int length,
            int start_x, 
            int start_y,
            int type){

        if(length == 1){
            matrix[start_x][start_y] = type;
            return;
        }
        int new_length = length/2;
        hadamard(matrix, new_length, start_x, start_y, type);
        hadamard(matrix, new_length, start_x+new_length, start_y, type);
        hadamard(matrix, new_length, start_x, start_y+new_length, type);
        hadamard(matrix, new_length, start_x+new_length, start_y+new_length, (type+1)%2);

    }

    public static void main (String []args){
        int n = Integer.parseInt(args[0]);
        int length = 1 << (n-1);
        int [][]matrix = new int[length][length];
        hadamard(matrix, length, 0, 0, 1);
        for (int i = 0; i < length; ++i){
            for (int j = 0; j < length; ++j){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

}




