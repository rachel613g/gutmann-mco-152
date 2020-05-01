package gutmann.neonasademo;
import retrofit2.Call;
import retrofit2.http.GET;
public interface NeoService{
        @GET("/neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key=DEMO_KEY")
        Call<NeoFeed> getAsteroids();
}

