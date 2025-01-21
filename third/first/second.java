package third.first;

public class second {
    public static void main(String[] args) {
    }
    interface CanFly{
        public void fly();
    }
    interface CanMove{
        public void move();
    }
    interface CanEat{
        public void eat();
    }
    static class Dog implements CanEat,CanMove{
        public void eat(){

        }
        public void move(){

        }
    }
    static class Duck implements CanEat,CanMove, CanFly{
        public void eat(){

        }
        public void move(){

        }
        public void fly(){

        }
    }
    static class Car implements CanMove{
        public void move(){

        }
    }
    static class Plane implements CanMove, CanFly{
        public void move(){

        }
        
        public void fly(){

        }
    }
}
