package third.second.fifth;

public class Building {
    private String type;
    public Building(String type) {
        this.type = type;
    }
    public void initialize(String newtype){
        this.type = newtype;
    }
    public static void main(String[] args) {
        Building building = new Building("Restaurant");
        building.initialize("Barbershop");
    }
}