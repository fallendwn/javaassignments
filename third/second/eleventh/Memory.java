package third.second.eleventh;
import java.util.*;
public class Memory {
    public static void main(String[] args) {
        String[] memory = {"object15", null, null, "object2", null, null, null, null,
                "object32", null, "object4"};
        executeDefragmentation(memory);
        System.out.println(Arrays.toString(memory));
    }
    public static void executeDefragmentation(String[] array) {
        int point = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                array[point] = array[i];
                point++;
            }
        }
        for (int i = point; i < array.length; i++) {
            array[i] = null;
        }
    }
}