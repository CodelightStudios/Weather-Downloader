# Weather-Downloader    [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Weather--Downloader-green.svg?style=true)](https://android-arsenal.com/details/1/3061)

Want to show the weather information in your app, here is a simple and efficient solution for you.
Now show the weather information you need in your app without deviating away from your app's core idea.
This is a helper library to get basic weather information into your app (not into a weather app of course).
It uses the [openweathermap api](http://openweathermap.org/api) to get the weather data. Please note that this is still in beta phase and is limited to
get the current weather conditions only. Forecast and Historical data will be added in future releases.

**Note: In Progress. Our aim is to simply the process of getting weather information for developers. In coming versions you will get weather icons along with weather based on conditions.**

# Include in your project
## Using Gradle
Add this in `dependencies` of your app's `build.gradle` file.
```javascript
compile 'codelight.studios.android:weather-downloader:0.1'
```

## How to use
### 1. Implement the WeatherDataDownloadListener in your Activity
`WeatherDataDownloadListener` implements the callback functions to be called after the weather info is loaded.

```java
    
    public class MainActivity extends AppCompatActivity implements WeatherDownloader.WeatherDataDownloadListener {
    
        ...
        
        @Override
        public void onWeatherDownloadComplete(WeatherData data, WeatherDownloader.Mode mode) {
            
        }
    
        @Override
        public void onWeatherDownloadFailed(Exception e) {
            
        }
    }

```

### 2. Invoke the getCurrentWeatherData to get the current weather conditions
Invoke the `getCurrentWeatherData` method by passing your Api Key and the Query (location name/zipcode/id/coordinates) strings. 

```java

    //Get data by city name
    WeatherDownloader downloader = new WeatherDownloader(MainActivity.this, WeatherDownloader.Mode.CITYNAME);
    downloader.getCurrentWeatherData(getResources().getString(R.string.weather_api_key), locationQuery);
    
    //Get data by city ID
    WeatherDownloader downloader = new WeatherDownloader(MainActivity.this, WeatherDownloader.Mode.CITYID);
    downloader.getCurrentWeatherData(getResources().getString(R.string.weather_api_key), cityIdQuery);
    
    //Get data by zip code
    WeatherDownloader downloader = new WeatherDownloader(MainActivity.this, WeatherDownloader.Mode.ZIPCODE);
    downloader.getCurrentWeatherData(getResources().getString(R.string.weather_api_key), zipCodeQuery);
    
    //Get data by coordinates.
    //In this method, the coordinatesQuery should be in the form of latitude:longitude format only.
    WeatherDownloader downloader = new WeatherDownloader(MainActivity.this, WeatherDownloader.Mode.COORDINATES);
    downloader.getCurrentWeatherData(getResources().getString(R.string.weather_api_key), coordinatesQuery);
    
```

That's it! Once the weather is downloaded in the background thread, you will be notified via the above mentioned
`onWeatherDownloadComplete` or `onWeatherDownloadFailed` listeners.

# Other features
By default the weather data is downloaded in KELVIN units. You can easily convert it into CELSIUS or FAHRENHEIT by using 
`WeatherUnits` class. For example, take a look into the sample app in repo.

```java

    @Override
    public void onWeatherDownloadComplete(WeatherData data, WeatherDownloader.Mode mode) {
        if (mode == WeatherDownloader.Mode.CITYNAME) {
            cityNameTextView.
                    setText(String.format("%.2f", WeatherUnits.convertToCelsius(data.getMain().getTemp())));
        } else if (mode == WeatherDownloader.Mode.CITYID) {
            cityIdProgress.setVisibility(View.GONE);
            cityIdTextView.
                    setText(String.format("%.2f", WeatherUnits.convertToFahrenheit(data.getMain().getTemp())));
        }
    }

```

# Contribution
I would love to welcome everyone of you to contribute to this project and make it better.
Currently we are focusing on the current weather data only, 
but other forecast and historical data features would be a great addition.
Encounter any issue? Don't hesitate to [open an issue](https://github.com/CodelightStudios/Weather-Downloader/issues).

Convention I would like to follow: **Master branch** would be the development branch. 
So feel free to fork from the Master branch. **Release branch** will be merged with master branch after every major release.


# Our other libraries
## [Android Smart Login library](https://github.com/CodelightStudios/Android-Smart-Login)
An easy and efficient way to add login functionality into your app.


# License
    The MIT License (MIT)

    Copyright (c) 2016 Codelight Studios
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
