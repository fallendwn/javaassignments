package third.second.fourteenth;
import third.second.fourteenth.City;
public class Solution {
    public static void showWeather(City city) {
        String output = String.format("In the city %s today the air temperature %d",city.getName(), city.getTemperature());
        System.out.println(output);
    }
    public static void main(String[] args) {
        String city1 = "Dubai";
        int temperature = 40;
        City city = new City(city1, temperature);
        showWeather(city);

    }
}