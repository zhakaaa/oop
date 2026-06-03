public class Jiraffe extends Animal{
    private int height;
    public Jiraffe(String type, int age, int height) {
        super(type, age);
        this.height = height;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Jiraffe jiraffe = (Jiraffe) o;
        return height == jiraffe.height;
    }

    @Override public int hashCode() {
        int hash = 7;
        hash = hash * 31 + height;
        return hash;
    }

    @Override public String toString() {
        return "Type " + super.getType() + " Age: " + super.getAge() + " Height: " + height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
