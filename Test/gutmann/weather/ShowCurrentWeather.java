package gutmann.weather;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ShowCurrentWeather
{
    //we want to learn how to make a web request
    public static void main(String[] args) throws IOException
    {
        URL url = new URL("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
        URLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        //we wanted to read the webpage into sout
        //take 1: inefficient to use inputstream.read() because only reads one character at a time
//        int c;
//        while ((c = in.read()) != -1)
//            System.out.print((char) c);

//take 2: inefficient because just reading the webpage not using the api
//        String line;
//        while ((line = reader.readLine()) != null)
//        {
//            System.out.println(line);
//        }


     //   what we are supposed to do
        Gson gson = new Gson();
        CurrentWeather currentWeather = gson.fromJson(reader, CurrentWeather.class);

        System.out.println(currentWeather.name);

    }
}
