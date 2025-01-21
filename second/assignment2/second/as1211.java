package b.assignment1.second;

public class as1211 {
    public static void main(String[] args) {
        int[] array = {15,64,9,51,42};
        printSqrt(array);
    }
    public static void printSqrt(int[] array) {
        String elementSqrt = "The square root for the number ";
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            double elementSqrt1 = Math.sqrt(element);
            System.out.println(elementSqrt + element + " equals " + elementSqrt1);
        }
    }
}
