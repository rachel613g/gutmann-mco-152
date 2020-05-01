
import org.junit.Test

class NeoServiceTest  {
    @Test
    public void getAsteroids()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NeoService service = retrofit.create(NeoService.class);

        //when
        NeoFeed feed = service.getAsteroids().execute().body();

        //then
        assertNotNull(feed);
        asserFalse(feed.near_earth_objects.isEmpty())
    }

}
