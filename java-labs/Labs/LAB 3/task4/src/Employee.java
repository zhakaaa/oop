import java.time.LocalDate;
import java.util.*;

public class Employee extends Person implements Comparable<Employee>, Cloneable {
    private String insuranceNumber;
    private double salary;
    private Date hireDate;
    private double bonus = 0;

    public Employee (String name, String insuranceNumber, double salary, Date hireDate) {
        this.name = name;
        this.insuranceNumber = insuranceNumber;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public Employee(){};

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void addBonus(double bonus) {
        this.bonus += bonus;
    }

    @Override public String toString() {
        LocalDate date = LocalDate.of(hireDate.getYear(), hireDate.getMonth(), hireDate.getDay());
        return "Name: " + name + " Salary: " + salary + "tg  Hire Date: " + date + " Insurance Number: " + insuranceNumber;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return insuranceNumber.equals(employee.insuranceNumber) &&
                name.equals(employee.name) &&
                hireDate.equals(employee.hireDate) &&
                salary == employee.salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public int compareTo(Employee employee2) {
        if(this.salary > employee2.salary) return 1;
        else if(this.salary < employee2.salary) return -1;
        else{
            if(this.getBonus() > employee2.getBonus()) return 1;
            else if(this.getBonus() < employee2.getBonus()) return -1;
            else return 0;
        }
    }

    @Override public Object clone() throws CloneNotSupportedException {
        return this.clone();
    }


    public static Comparator<Employee> compareByName = new Comparator<>() {
        @Override
        public int compare(Employee m1, Employee m2) {
            return m1.name.compareTo(m2.name);
        }
    };

    public static Comparator<Employee> compareByDate = new Comparator<>() {
        @Override
        public int compare(Employee m1, Employee m2) {
            return m1.getHireDate().compareTo(m2.getHireDate());
        }
    };




}
