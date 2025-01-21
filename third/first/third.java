package third.first;

public class third {
    public static void main(String[] args){

    }
    interface CanFly{
        public void fly();
    }
    interface CanRun{
        public void run();
    }
    interface CanSwim{
        public void swim();
    }
    public class Human implements CanRun,CanSwim{
        public void run(){

        }

        public void swim(){

        }

    }

    public class Duck implements CanRun,CanSwim,CanFly{
        public void fly(){

        }

        public void run(){

        }
        public void swim(){

        }
    }
    public class Penguin implements CanRun, CanSwim {
        public void run(){

        }
        public void swim(){

        }
    }
    public class Airplane {
        public void fly(){
            
        }
    }
}
