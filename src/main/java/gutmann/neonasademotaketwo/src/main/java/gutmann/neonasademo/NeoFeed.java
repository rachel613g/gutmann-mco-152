package gutmann.neonasademo;
import java.util.HashMap;
import java.util.List;


public class NeoFeed
{
    //you can tell something is a hashmap when the name is a variable type
    //this hashmap has a date key that is linked to a nearEarthObject
    HashMap<String, List<NearEarthObject>> near_earth_objects;
    class NearEarthObject{
        String id;
        String name;
        String nasa_jpl_url;
        boolean is_potentially_HazardousAsteroid;
    }
}