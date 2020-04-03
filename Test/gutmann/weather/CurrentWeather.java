package gutmann.weather;

public class CurrentWeather
{
    //all variable names must be the same as the apis
    String base;
    int visibility;
    Coord coord;
    String name;
    Main main;
    Weather weather[];

    class Coord{
        double lon;
        double lat;
    }

    class Main{
        double temp;
        double feels_like;
    }

    class Weather{
        int id;
        String main;
        String description;
        String icon;
    }
}
