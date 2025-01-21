package b.assignment1.first;

public class as1eleventh {
    public static int[][][] multiarray = new int[][][]{{{4, 8, 15}, {16}}, {{23, 42}, {}},
        {{1}, {2}, {3}, {4, 5}}};
    public static void main(String[] args) {
        for(int i =0 ; i < multiarray.length;i++){
            for(int k = 0 ; k < multiarray[i].length; k++){
                for(int j = 0 ; j < multiarray[i][k].length; j++){
                    System.out.print(multiarray[i][k][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

        }

    }
}
