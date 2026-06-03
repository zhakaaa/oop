class Temperature{
    private double temperature;
    private char scale;

    // Accessors methods
    public double getTemperature() {
        if(scale == 'F' || scale == 'f') return getCelsiusFromFarenheit(temperature);
        return getFarenheitFromCelsius(temperature);
    }

    public char getScale() {
        if(scale == 'F' || scale == 'f')return 'C';
    return 'F'; }


    // 4 Constructors
    public Temperature(double temperature, char scale){
        this.temperature = temperature;

        if(scale == 'C' || scale == 'c') this.scale = scale;
        else if (scale == 'F' || scale == 'f') this.scale = scale;
        else System.out.println("Invalid scale value");}

    public Temperature(){
        temperature = 0;
        scale = 'C';}

    public Temperature(double temperature){
        this.temperature = temperature;
        scale = 'C';}

    public Temperature(char scale){
        temperature = 0;

        if(scale == 'C' || scale == 'c') this.scale = scale;
        else if (scale == 'F' || scale == 'f') this.scale = scale;
        else System.out.println("Invalid scale value");
    }


    // 2 methods to return temperature
    private double getCelsiusFromFarenheit(double farenheit){
        return (5 * (farenheit - 32)) / 9;
    }
    private double getFarenheitFromCelsius(double celsius){
        return (9 * (celsius / 5))  + 32;
    }


    // 3 methods to set the fields
    public void setTemperature(double temperature){
        this.temperature = temperature;}

    public void setScale(char scale){
        if(scale == 'C' || scale == 'c') this.scale = scale;
        else if (scale == 'F' || scale == 'f') this.scale = scale;
        else System.out.println("Invalid scale value");
    }

    public void setTemperatureAndScale(double temperature, char scale){
        this.temperature = temperature;


        if(scale == 'C' || scale == 'c') this.scale = scale;
        else if (scale == 'F' || scale == 'f') this.scale = scale;
        else System.out.println("Invalid scale value");
    }


    // Method to return scale
    public String returnScale() {
        if (scale == 'C') {
            return "Celsius";
        }
        return "Fahrenheit";
    }

    public void getTemperatureAndScale(){
        System.out.println("Temperature is: "+ getTemperature());
        System.out.println("Measured in : "+getScale());
//        return temp;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("Temperature 1");
        Temperature temperature1 = new Temperature();
        temperature1.getTemperatureAndScale();

        temperature1.setScale('F');
        temperature1.setTemperature(10);
        temperature1.getTemperatureAndScale();


        System.out.println("\nTemperature 2");
        Temperature temperature2 = new Temperature('F');
        temperature2.getTemperatureAndScale();

        temperature2.setTemperatureAndScale(25,'F');// 25 in faranheit
        temperature2.getTemperatureAndScale();


        System.out.println("\nTemperature 3");
        Temperature temperature3 = new Temperature(50);
        temperature3.getTemperatureAndScale();

        temperature3.setScale('F');
        temperature3.setTemperature(100); // in celcius
        temperature3.getTemperatureAndScale();


        System.out.println("\nTemperature 4");
        Temperature temperature4 = new Temperature(150,'F');
        temperature4.getTemperatureAndScale();

        temperature4.setScale('C');
        temperature4.setTemperature(-50);
        temperature4.getTemperatureAndScale();
    }
}