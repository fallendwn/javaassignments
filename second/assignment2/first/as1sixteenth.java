package b.assignment1.first;

import java.util.Scanner;
public class as1sixteenth {
    public static char[][] array;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        array = new char[n][n*2];
        int start = n*2-n;
        int end = n*2-n;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < start; k++) {
                array[i][k] = '1';
            }
            for (int r = end; r < n*2; r++) {
                array[i][r] = '1';
            }
            for (int j = start; j <= end; j++) {
                array[i][j] = '#';
            }
            start-=1;
            end+=1;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
