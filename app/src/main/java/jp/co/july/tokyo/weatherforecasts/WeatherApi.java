package jp.co.july.tokyo.weatherforecasts;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by it on 2015/09/15.
 */
public class WeatherApi {
    private static final String USER_AGENT = "WeatherForecasts Sample";
    private static final String WebAPI = "http://weather.livedoor.com/forecast/webservice/json/v1?city=";

    public static String getWeather(Context context, String pointId) throws IOException{
        URL url = new URL(WebAPI + pointId);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        StringBuilder sb = new StringBuilder();
        try {
            urlConnection.getResponseMessage();

        }finally {
            urlConnection.disconnect();
        }
        //return sb.toString();
        return "abc";
    }
}
