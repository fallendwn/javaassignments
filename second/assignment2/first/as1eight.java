package b.assignment1.first;

public class as1eight {
    public static int[][] MULTIPLICATION_TABLE = new int[10][10];
    public static void main(String[] args) {
        int a =1;
        for(int i = 0 ; i < 10 ; i ++){
            for(int j = 1 ; j <= 10 ; j ++){
                MULTIPLICATION_TABLE[i][j-1] = a*j;
            }
            a++;
        }
        for(int i = 0 ; i < 10 ; i ++){
            for(int j = 0 ; j < 10 ; j ++){
                System.out.print(MULTIPLICATION_TABLE[i][j]+" ");
            }
            System.out.println();
        }
    }
}
