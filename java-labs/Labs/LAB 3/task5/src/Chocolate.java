public class Chocolate implements Comparable<Chocolate> {
    private double weight;
    private String name;

    Chocolate(String name, double weight) {
        this.weight = weight;
        this.name = name;
    }

    public Chocolate() {

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Chocolate chocolate) {
        return Double.compare(this.weight, chocolate.getWeight());
    }

    @Override public String toString() {
        return "Chocolate{" + "weight=" + weight + ", name=" + name + '}';
    }


}
