package b.assignment1.first;
import java.util.Scanner;
public class as1fifth{
public static void main(String[] args) {
    //write your code here
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    while(n<=0){
        System.out.println("Enter correct number higher than 0");
        n = scanner.nextInt();
    }
    int[] arr = new int[n];
    for(int i = 0 ; i < n ; i ++){
        arr[i] = scanner.nextInt();
    }
            if(n%2==0){
                for(int i = n-1; i >=0 ; i--){
                    System.out.println(arr[i]);
                }
            }
            else{
                for(int i = 0 ; i < n; i++){
                    System.out.println(arr[i]);
                }
            }

        }
    }
