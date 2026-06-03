public class Staff extends Person{
    private String school;
    private double pay;

    public Staff(String name, String address, String school, double pay) {
        this.name = name;
        this.address = address;
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {return school;}
    public double getPay() {return pay;}

    public void setSchool(String school) {this.school = school;}
    public void setPay(double pay) {this.pay = pay;}

    @Override public String toString() {
        return "Name: " + name + " Address: " + address + " School: " + school + " Pay: " + pay + "tg";
    }
}
