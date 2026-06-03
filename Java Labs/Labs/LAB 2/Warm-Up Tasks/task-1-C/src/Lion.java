public class Lion extends Animal {
    private String color;

    public Lion(String type, int age, String color){
        super(type, age);
        this.color = color;
    }

    @Override public boolean equals(Object o) {
        i
    }

    @Override public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (color != null ? color.hashCode() : 0);
        return hash;
    }

    @Override public String toString() {
        return "Type " + super.getType() + " Age: " + super.getAge() + " Color: " + color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
