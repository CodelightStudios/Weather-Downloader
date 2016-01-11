package studios.codelight.weatherdownloaderlibrary;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import studios.codelight.weatherdownloaderlibrary.model.Clouds;
import studios.codelight.weatherdownloaderlibrary.model.Coord;
import studios.codelight.weatherdownloaderlibrary.model.Main;
import studios.codelight.weatherdownloaderlibrary.model.Sys;
import studios.codelight.weatherdownloaderlibrary.model.Weather;
import studios.codelight.weatherdownloaderlibrary.model.WeatherData;
import studios.codelight.weatherdownloaderlibrary.model.Wind;
import studios.codelight.weatherdownloaderlibrary.util.JsonUtil;

/**
 * The MIT License (MIT)
 * <p/>
 * Copyright (c) 2016 Codelight Studios
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * Created by kalyan on 9/1/16.
 */
public class WeatherDataBuilder {
    private static final String LOG_TAG = "WeatherDownloader";
    public static WeatherData buildWeatherData(String response) {
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(response);
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            return null;
        }

        WeatherData weatherData = new WeatherData();

        Clouds cloudsData = null;
        try {
            cloudsData = JsonUtil.getCloudsObjectFromJson(response);
            weatherData.setClouds(cloudsData);
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            weatherData.setClouds(cloudsData);
        }

        Coord coordData = null;
        try {
            coordData = JsonUtil.getCoordObjectFromJson(response);
            weatherData.setCoord(coordData);
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            weatherData.setCoord(coordData);
        }

        Main mainData = null;
        try {
            mainData = JsonUtil.getMainObjectFromJson(response);
            weatherData.setMain(mainData);
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            weatherData.setMain(mainData);
        }

        Sys sysData = null;
        try {
            sysData = JsonUtil.getSysObjectFromJson(response);
            weatherData.setSys(sysData);
        } catch (JSONException e) {
            weatherData.setSys(sysData);
            Log.e(LOG_TAG, e.getMessage());
        }


        Weather[] weatherObjectData = null;
        try {
            weatherObjectData = JsonUtil.getWeatherObjectFromJson(response);
            weatherData.setWeather(weatherObjectData);
        } catch (JSONException e) {
            weatherData.setWeather(weatherObjectData);
            Log.e(LOG_TAG, e.getMessage());
        }


        Wind windData = null;
        try {
            windData = JsonUtil.getWindObjectFromJson(response);
            weatherData.setWind(windData);
        } catch (JSONException e) {
            weatherData.setWind(windData);
            Log.e(LOG_TAG, e.getMessage());
        }


        try {
            weatherData.setBase(jsonObject.getString("base"));
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            weatherData.setBase(null);
        }
        try {
            weatherData.setVisibility(jsonObject.getString("visibility"));
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            weatherData.setVisibility(null);
        }
        try {
            weatherData.setDt(jsonObject.getString("dt"));
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            weatherData.setDt(null);

        }
        try {
            weatherData.setId(jsonObject.getString("id"));
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            weatherData.setId(null);
        }
        try {
            weatherData.setName(jsonObject.getString("name"));
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            weatherData.setName(null);
        }
        try {
            weatherData.setCod(jsonObject.getString("cod"));
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage());
            weatherData.setCod(null);
        }

        return weatherData;
    }
}
