public class Cube extends Shape3D {
    private double length;
    public Cube(double length) {
        this.length = length;
    }
    // что лучше? получить данные через конструктор или через сеттеры?
    @Override public double volume(){
        return Math.pow(length, 3);
    }

    @Override public double surfaceArea(){
        return 6 * Math.pow(length, 2);
    }
}
