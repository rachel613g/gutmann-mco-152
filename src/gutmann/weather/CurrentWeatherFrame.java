package gutmann.weather;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CurrentWeatherFrame extends JFrame
{
    private URL url;
    private URLConnection connection;
    InputStream input;
    BufferedReader reader;
    Gson gson;
    CurrentWeather currentWeather;

    JPanel panel;
    JLabel cityLabel;
    JLabel tempLabel;
    JLabel weatherMainLabel;
    JLabel weatherDescriptionLabel;
    JLabel inputLabel;
    JTextField inputCityTF;
    JButton searchButton;


    public CurrentWeatherFrame() throws IOException
    {
        setUpWeatherFrame();
    }

    private void enterUserInput() throws IOException
    {
        //input validation
        if (inputCityTF.getText().contains(" "))
        {
            throw new IOException("No spaces permitted in user entry. Please try again.");
        }

        setUpConnectionToAPI();
        cityLabel.setText(currentWeather.name);
        tempLabel.setText(String.valueOf(currentWeather.main.temp) + " degrees");
        weatherMainLabel.setText(currentWeather.weather[0].main);
        weatherDescriptionLabel.setText(currentWeather.weather[0].description);

    }




    private void setUpWeatherFrame()
    {
        setSize(new Dimension(400, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Current Weather");
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setContentPane(panel);

        cityLabel = new JLabel();
        panel.add(cityLabel);

        tempLabel = new JLabel();
        panel.add(tempLabel);

        weatherMainLabel = new JLabel();
        panel.add(weatherMainLabel);

        weatherDescriptionLabel = new JLabel();
        panel.add(weatherDescriptionLabel);

        inputLabel = new JLabel("Enter City,Country Code to retrieve weather information i.e. Dublin,IE ");
        panel.add(inputLabel);

        inputCityTF = new JTextField();
        panel.add(inputCityTF);

        searchButton = new JButton("Search");
        panel.add(searchButton);
        searchButton.addActionListener(actionEvent ->
        {
            try
            {
                enterUserInput();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        });
    }

    private void setUpConnectionToAPI() throws IOException
    {
        url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + inputCityTF.getText() + "&appid=b0eff9d1eef0a4c976c42442142c256b&units=imperial");
        connection = (HttpURLConnection) url.openConnection();
        input = connection.getInputStream();
        reader = new BufferedReader(new InputStreamReader(input));

        gson = new Gson();
        currentWeather = gson.fromJson(reader, CurrentWeather.class); //what does a .class really mean?
    }

    public static void main(String[] args) throws IOException
    {
        new CurrentWeatherFrame().setVisible(true);
    }
}
