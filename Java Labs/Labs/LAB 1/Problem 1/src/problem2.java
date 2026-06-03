class Temperature{
    private double temperature;
    private char scale;

    public double getTemperature() {
        return temperature;
    }

    public char getScale()
    {
        return scale;
    }

    public Temperature(double temperature, char scale){
        this.temperature = temperature;
        this.scale = scale;
    }

    public Temperature(){
        temperature = 0;
        scale = 'C';
    }

    public Temperature(double temperature){
        this.temperature = temperature;
        scale = 'C';
    }

    public Temperature(char scale){
        temperature = 0;
        this.scale = scale;
    }

    public double getCelsiusFromFarenheit(double farenheit){
        return (5 * (farenheit - 32)) / 9;
    }

    public double getFarenheitFromCelsius(double celsius){
        return (9 * (celsius / 5))  + 32;
    }

    public void setTemperature(double temperature){
        this.temperature = temperature;
    }

    public void setScale(char scale){
        this.scale = scale;
    }

    public void setTemperatureAndScale(double temperature, char scale){
        this.temperature = temperature;
        this.scale = scale;
    }

//    public Temperature getScaledTemperature(){
//        if(scale == 'C'){
//
//        }
//    }
}

public class problem2
{
    Temperature temperature1 = new Temperature();
    //temperature1.
}
