package b.assignment1.first;
import java.util.Scanner;
public class as1seventh {
    public static String[] strings = new String[6];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < 6 ; i ++){
            strings[i] = scanner.nextLine();
        }
        boolean flag =true;
        for(int i = 0 ; i <6 ; i++){
            for(int j = 1+i ; j <6 ; j++){

                if ((strings[j] !=null &&strings[i]!=null)&&strings[i].equals(strings[j])){
                    strings[j] = null;
                    flag = false;
                }
            }
            if(!flag){
                strings[i] = null;
                flag = true;
            }
            if(i ==5){
                break;
            }
        }
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + ", ");
        }
    }
}