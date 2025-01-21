package third.first;

public class ninth {
    public static void main(String[] args){

    }
    interface CanMove{

        public double speed();
    }
    interface CanFly extends CanMove{

        public double speed(CanFly can);

    }
    
}
