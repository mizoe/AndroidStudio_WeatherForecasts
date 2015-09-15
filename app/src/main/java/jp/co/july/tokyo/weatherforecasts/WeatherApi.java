package jp.co.july.tokyo.weatherforecasts;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
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
        String resultStr = new String();
        // ここから拝借 http://tikuflower.blogspot.jp/2012/12/jsontwitter-api.html
        try {
            // コネクション生成
            HttpURLConnection connection = null;
            URL url = new URL(WebAPI + pointId);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");

            // リクエスト送信
            connection.connect();

            // レスポンスコードチェック
            if(connection.getResponseCode() != 200) {
                resultStr = "検索失敗！！";
                return resultStr;
            }

            // レスポンス文字列取得
            BufferedInputStream inputStream = new BufferedInputStream(connection.getInputStream());
            ByteArrayOutputStream responseArray = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];

            int length;
            while((length = inputStream.read(buff)) != -1) {
                if(length > 0) {
                    responseArray.write(buff, 0, length);
                }
            }

            // JSONをパース
            JSONObject jsonObj = new JSONObject(new String(responseArray.toByteArray()));
            resultStr = jsonObj.toString();

        } catch(Exception e) {
            resultStr = e.getMessage();
        }
        return resultStr;
    }
}
