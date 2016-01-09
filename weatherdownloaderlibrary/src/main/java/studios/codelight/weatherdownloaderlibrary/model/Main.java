package studios.codelight.weatherdownloaderlibrary.model;

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
public class Main {
    private String humidity;

    private String pressure;

    private String temp_max;

    private String temp_min;

    private String temp;

    public String getHumidity () {
        return humidity;
    }

    public void setHumidity (String humidity) {
        this.humidity = humidity;
    }

    public String getPressure () {
        return pressure;
    }

    public void setPressure (String pressure) {
        this.pressure = pressure;
    }

    public String getTemp_max () {
        return temp_max;
    }

    public void setTemp_max (String temp_max) {
        this.temp_max = temp_max;
    }

    public String getTemp_min () {
        return temp_min;
    }

    public void setTemp_min (String temp_min) {
        this.temp_min = temp_min;
    }

    public String getTemp () {
        return temp;
    }

    public void setTemp (String temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Main [humidity = "+humidity+", pressure = "+pressure+", temp_max = "+temp_max+", temp_min = "+temp_min+", temp = "+temp+"]";
    }
}
