package third.second.two;

public class Skyscraper {
    public Skyscraper() {
        final String SKYSCRAPER_WAS_BUILD = "Skyscraper is built.";
        System.out.println(SKYSCRAPER_WAS_BUILD);
    }
    public Skyscraper(int a) {
        final String SKYSCRAPER_WAS_BUILD_FLOORS_COUNT = String.format("Skyscraper is built. The number of floors - %d",a);
        System.out.println(SKYSCRAPER_WAS_BUILD_FLOORS_COUNT);
    }
    public Skyscraper(String b) {
       final String SKYSCRAPER_WAS_BUILD_DEVELOPER = String.format("Skyscraper is built. Developer - %s", b);
       System.out.println(SKYSCRAPER_WAS_BUILD_DEVELOPER);
    }
    public static void main(String[] args) {
        Skyscraper skyscraper = new Skyscraper();
        Skyscraper skyscraperTower = new Skyscraper(50);
        Skyscraper skyscraperSkyline = new Skyscraper("JavaRushDevelopment");
    }
}