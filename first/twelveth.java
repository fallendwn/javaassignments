package a;

public class twelveth {
    public static void main(String[] args){
        int dvigaem = 1;
        int sum = 0;
        while(dvigaem!=101){
            if(dvigaem%3!=0){
                sum+=dvigaem;
            }
            dvigaem++;
            continue;
        }
        System.out.println(sum);
    }
}
