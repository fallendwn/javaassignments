package third.second.seventh;

public class Programmer {
    private int salary = 1000;
    public int getSalary(){
        return this.salary;
    }
    public void setSalary(int salary){
        if (salary> this.salary){
            this.salary = salary;
        }
    }
}
