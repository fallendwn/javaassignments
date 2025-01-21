package third.first;

public class fifth{
    public interface Drinker {
        void askForMore(String message);
        void sayThankYou();
        boolean isReadyToGoHome();
    }

    public interface Alcoholic extends Drinker {
        boolean READY_TO_GO_HOME = false;
        void sleepOnTheFloor();
    }

    public static class BeerLover implements Alcoholic {
        String ask = "more alcohol please";
        public void askForMore(String message){

        }
        public void sayThankYou(){

        }
        public void sleepOnTheFloor(){

        }
        public boolean isReadyToGoHome(){
            return READY_TO_GO_HOME;
        }

    }
}
