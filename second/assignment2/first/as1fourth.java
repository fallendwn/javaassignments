package b.assignment1.first;

public class as1fourth
{
    public static int[] firstArray = new int[]{0, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9};
    public static int[] secondArray = new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    public static int length_ = firstArray.length + secondArray.length;
    public static int[] resultArray = new int[length_];
    public static void main(String[] args) {
        boolean flag = true;
        for(int i= 0 ; i <length_ ; i++){
            if(flag){
                resultArray[i] = firstArray[i];
            }
            else{
                resultArray[i] = secondArray[i-firstArray.length];
            }
            if(i== firstArray.length-1){
                flag = false;
            }

        }
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + ", ");
        }
    }
}
