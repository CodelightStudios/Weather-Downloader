package studios.codelight.weatherdownloaderlibrary.model;

import java.util.Arrays;

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
public class WeatherData {
    private String id;

    private String dt;

    private Clouds clouds;

    private Coord coord;

    private Wind wind;

    private String cod;

    private String visibility;

    private Sys sys;

    private String name;

    private String base;

    private Weather[] weather;

    //private Rain rain;

    private Main main;

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getDt () {
        return dt;
    }

    public void setDt (String dt) {
        this.dt = dt;
    }

    public Clouds getClouds () {
        return clouds;
    }

    public void setClouds (Clouds clouds) {
        this.clouds = clouds;
    }

    public Coord getCoord () {
        return coord;
    }

    public void setCoord (Coord coord) {
        this.coord = coord;
    }

    public Wind getWind () {
        return wind;
    }

    public void setWind (Wind wind) {
        this.wind = wind;
    }

    public String getCod () {
        return cod;
    }

    public void setCod (String cod) {
        this.cod = cod;
    }

    public String getVisibility () {
        return visibility;
    }

    public void setVisibility (String visibility) {
        this.visibility = visibility;
    }

    public Sys getSys () {
        return sys;
    }

    public void setSys (Sys sys) {
        this.sys = sys;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getBase () {
        return base;
    }

    public void setBase (String base) {
        this.base = base;
    }

    public Weather[] getWeather () {
        return weather;
    }

    public void setWeather (Weather[] weather) {
        this.weather = weather;
    }

    /*public Rain getRain () {
        return rain;
    }

    public void setRain (Rain rain) {
        this.rain = rain;
    }*/

    public Main getMain () {
        return main;
    }

    public void setMain (Main main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "WeatherData [id = "+id+", dt = "+dt+", clouds = "+clouds+", coord = "+coord+", wind = "+wind+", cod = "+cod+", visibility = "+visibility+", sys = "+sys+", name = "+name+", base = "+base+", weather = "+ Arrays.toString(weather) +", main = "+main+"]";
    }
}
