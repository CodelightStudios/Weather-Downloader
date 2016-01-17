/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Codelight Studios
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * Created by kalyan on 9/1/16.
 */

package studios.codelight.weatherdownloaderlibrary;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import studios.codelight.weatherdownloaderlibrary.model.WeatherData;

public class WeatherDownloader {
    public static final String LOG_TAG = "WeatherDownloader";
    private WeatherDataDownloadListener downloadListener;
    private Mode mode;

    private final String BASE_URL = "api.openweathermap.org";
    private final String DATA_PATH = "data";
    private final String VERSION_PATH = "2.5";
    private final String WEATHER_PATH = "weather";


    public WeatherDownloader(WeatherDataDownloadListener downloadListener, Mode mode) {
        this.downloadListener = downloadListener;
        this.mode = mode;
    }

    public void getCurrentWeatherData(String apiKey, String query) {
        if(apiKey != null) {
            try {
                String url = buildUrl(apiKey, mode, query);
                new DownloadCurrentData().execute(url);
            } catch (Exception e) {
                Log.e(LOG_TAG, e.getMessage());
            }
        } else {
            Log.e(LOG_TAG, "ApiKey cannot be null");
        }
    }

    private String buildUrl(String apiKey, Mode mode, String query) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority(BASE_URL)
                .appendPath(DATA_PATH)
                .appendPath(VERSION_PATH)
                .appendPath(WEATHER_PATH)
                .appendQueryParameter("appid", apiKey);
        switch (mode) {
            case CITYNAME:
                builder.appendQueryParameter("q", query);
                return builder.build().toString();
            case ZIPCODE:
                builder.appendQueryParameter("zip", query);
                return builder.build().toString();
            case COORDINATES:
                String[] coord = query.split(":");
                builder.appendQueryParameter("lat", coord[0]);
                builder.appendQueryParameter("lon", coord[1]);
                return builder.build().toString();
            case CITYID:
                builder.appendQueryParameter("id", query);
                return builder.build().toString();
            default:
                break;
        }
        return null;
    }

    public interface WeatherDataDownloadListener {
        void onWeatherDownloadComplete(WeatherData data, Mode mode);
        void onWeatherDownloadFailed(Exception e);
    }


    private class DownloadCurrentData extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            InputStream inputStream = null;
            URL url;
            HttpURLConnection httpURLConnection = null;
            try {
                url = new URL(params[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(15000); //15 sec
                inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                return convertInputStreamToString(inputStream);
            } catch (IOException e) {
                Log.e(LOG_TAG, e.getMessage());
            } finally {
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (IOException e) {
                    Log.e(LOG_TAG, e.getMessage());
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String response) {
            if(response == null){
                Log.e(LOG_TAG, "Response is null");
                downloadListener.onWeatherDownloadComplete(null, mode);
            } else {
                try {
                    downloadListener.onWeatherDownloadComplete(WeatherDataBuilder.buildWeatherData(response), mode);
                } catch (Exception e) {
                    Log.e(LOG_TAG, "Invalid data");
                    downloadListener.onWeatherDownloadFailed(e);
                }
            }
        }

        private String convertInputStreamToString(InputStream inputStream) throws IOException{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            String result = "";
            while((line = bufferedReader.readLine()) != null) {
                result += line;
            }
            inputStream.close();
            return result;
        }
    }

    public enum Mode {
        ZIPCODE,
        COORDINATES,
        CITYID,
        CITYNAME
    }
}
