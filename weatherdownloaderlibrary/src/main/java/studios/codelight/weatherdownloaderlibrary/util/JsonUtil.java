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

package studios.codelight.weatherdownloaderlibrary.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import studios.codelight.weatherdownloaderlibrary.model.Clouds;
import studios.codelight.weatherdownloaderlibrary.model.Coord;
import studios.codelight.weatherdownloaderlibrary.model.Main;
import studios.codelight.weatherdownloaderlibrary.model.Sys;
import studios.codelight.weatherdownloaderlibrary.model.Weather;
import studios.codelight.weatherdownloaderlibrary.model.Wind;

public class JsonUtil {
    public static Coord getCoordObjectFromJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject coordJson = jsonObject.getJSONObject("coord");
        if(coordJson != null) {
            Coord coord = new Coord();
            coord.setLon(coordJson.getString("lon"));
            coord.setLat(coordJson.getString("lat"));
            return coord;
        } else {
            return null;
        }
    }

    public static Sys getSysObjectFromJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject sysJson = jsonObject.getJSONObject("sys");
        if(sysJson != null) {
            Sys sys = new Sys();
            sys.setId(sysJson.getString("id"));
            sys.setType(sysJson.getString("type"));
            sys.setMessage(sysJson.getString("message"));
            sys.setCountry(sysJson.getString("country"));
            sys.setSunrise(sysJson.getString("sunrise"));
            sys.setSunset(sysJson.getString("sunset"));
            return sys;
        } else {
            return null;
        }
    }

    public static Weather[] getWeatherObjectFromJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONArray weatherJsonArray = jsonObject.getJSONArray("weather");
        if(weatherJsonArray != null) {
            Weather[] weatherArray = new Weather[weatherJsonArray.length()];
            for (int i = 0; i < weatherJsonArray.length(); i++) {
                Weather weather = new Weather();
                JSONObject weatherJsonObject = weatherJsonArray.getJSONObject(i);
                weather.setId(weatherJsonObject.getString("id"));
                weather.setDescription(weatherJsonObject.getString("description"));
                weather.setIcon(weatherJsonObject.getString("icon"));
                weather.setMain(weatherJsonObject.getString("main"));
                weatherArray[i] = weather;
            }
            return weatherArray;
        } else {
            return null;
        }
    }

    public static Main getMainObjectFromJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject mainJsonObject = jsonObject.getJSONObject("main");
        if(mainJsonObject != null) {
            Main main = new Main();
            main.setHumidity(mainJsonObject.getString("humidity"));
            main.setPressure(mainJsonObject.getString("pressure"));
            main.setTemp(mainJsonObject.getString("temp"));
            main.setTemp_max(mainJsonObject.getString("temp_max"));
            main.setTemp_min(mainJsonObject.getString("temp_min"));
            return main;
        } else {
            return null;
        }
    }

    public static Wind getWindObjectFromJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject windJson = jsonObject.getJSONObject("wind");
        if(windJson != null) {
            Wind wind = new Wind();
            wind.setDeg(windJson.getString("deg"));
            wind.setSpeed(windJson.getString("speed"));
            return wind;
        } else {
            return null;
        }
    }

    public static Clouds getCloudsObjectFromJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject cloudsJson = jsonObject.getJSONObject("clouds");
        if(cloudsJson != null) {
            Clouds clouds = new Clouds();
            clouds.setAll(cloudsJson.getString("all"));
            return clouds;
        } else {
            return null;
        }
    }
}
