package studios.codelight.weatherdownloaderlibrary.util;

/**
 * Created by Inspiron on 17-01-2016.
 */
public class WeatherUnits {
    public static Double convertToCelsius(String kelvin) throws NumberFormatException{
        double inKelvin;
        try {
            inKelvin = Double.parseDouble(kelvin);
        } catch (NumberFormatException e) {
            throw e;
        }
        return inKelvin - 273.15;
    }
    public static Double convertToFahrenheit(String kelvin) throws NumberFormatException{
        double inKelvin;
        try {
            inKelvin = Double.parseDouble(kelvin);
        } catch (NumberFormatException e) {
            throw e;
        }
        return (9/5)*(inKelvin - 273) + 32;
    }
}
