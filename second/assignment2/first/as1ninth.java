package b.assignment1.first;

public class as1ninth {
    public static int[][] result = new int[10][];
    public static void main(String[] args) {
        int num_of_col = 1 ;
        for(int i = 0 ; i < 10 ; i++){
            for(int j = 0 ; j < num_of_col ; j++){
                result[i] = new int[num_of_col];
                result[i][j] = i+j;
                System.out.print(result[i][j] + " ");
            }
            num_of_col ++;
            System.out.println();
        }
    }
}
