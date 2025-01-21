package third.second.three;

public class Skyscraper {
    private int floorsCount;
    private String developer;
    public Skyscraper(int floorsCount, String developer) {
        this.floorsCount = floorsCount;
        this.developer = developer;
        System.out.println(this.developer);
        System.out.println(this.floorsCount);

    }
    public Skyscraper(){
        this.floorsCount = 5;
        this.developer = "JavaRushDevelopment";
        System.out.println(this.developer);
        System.out.println(this.floorsCount);
    }
    public static void main(String[] args) {
        Skyscraper skyscraper = new Skyscraper();
        Skyscraper skyscraperUnknown = new Skyscraper(50, "Unknown");
    }
}
