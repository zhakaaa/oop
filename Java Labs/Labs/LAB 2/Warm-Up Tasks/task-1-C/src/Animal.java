public  class Animal {
    private String type;
    private int age;

    public Animal(String type, int age) {
        this.type = type;
        this.age = age;
    }

    public boolean equals(Object obj){
        return this == obj;
    };

    public int hashCode(){
        return type.hashCode();
    };

    public String toString() {
        return "Type: " + type + " Age " + age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
