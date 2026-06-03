
public class Cylinder extends Shape3D {
    private double radius, height;
    public Cylinder(double radius, double height){
        this.radius = radius;
        this.height = height;
    }
    @Override public double volume(){
        return Math.PI * Math.pow(radius, 2) * height;
    }

    @Override public double surfaceArea(){
        return 2 * (Math.PI * radius * radius + Math.PI * radius * height);
    }
}
