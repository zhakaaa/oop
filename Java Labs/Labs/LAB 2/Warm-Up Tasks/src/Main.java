public class Main {
    public static void main(String[] args) {
        Shape3D cube = new Cube(5);
        System.out.println("Cube volume = " + cube.volume());
        System.out.println("Cube surface area = " + cube.surfaceArea());

        Shape3D cylinder = new Cylinder(5,10);
        System.out.println("Cylinder volume = " + cylinder.volume());
        System.out.println("Cylinder surface area = " + cylinder.surfaceArea());

        Shape3D sphere = new Sphere(5);
        System.out.println("Sphere volume = " + sphere.volume());
        System.out.println("Sphere surface area = " + sphere.surfaceArea());
    }
}