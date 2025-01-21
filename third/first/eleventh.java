package third.first;

public class eleventh{
    public static void main(String[] args) {
    }
    //can move
    public interface Movable {
        void move();
    }

    public interface Edible {
        void beEaten();
    }
    public interface Eat {
        void eat();
    }

    public class Cat implements Movable, Edible, Eat{
        public void move(){

        }

        public void beEaten(){

        }

        public void eat(){

        }

    }
    public class Mouse implements Movable, Edible{
        public void move(){

        }
        public void beEaten(){

        }

    }
    public class Dog implements Movable, Eat{
        public void move(){

        }
        public void eat(){
            
        }

    }
}