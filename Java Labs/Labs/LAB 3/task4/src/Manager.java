import java.util.Collections;
import java.util.Date;
import java.util.Vector;

public class Manager extends Employee {
    double bonus = 0;
    private Vector<Employee> employees = new Vector<>();

    public Manager(String name, String insuranceNumber, double salary, Date hireDate) {
        super(name, insuranceNumber, salary, hireDate);
    }
    public Manager(){};

    public void insert(Employee emp) {
        employees.add(emp);
    }

    public Vector<Employee> getEmployeesList() {
        return employees;
    }

    public void addBonus(double bonus) {
        this.bonus += bonus;
    }

    public double getBonus() {return bonus;}

    @Override public String toString() {
        return "Name: " + name + " Salary: " + getSalary() + " Hire Date: " + getHireDate() + " Insurance Number: " + getInsuranceNumber();
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getInsuranceNumber().equals(employee.getInsuranceNumber()) &&
                name.equals(employee.name) &&
                getHireDate().equals(employee.getHireDate()) &&
                getSalary() == employee.getSalary();
    }


    @Override
    public int compareTo(Employee employee2) {
        if(this.getSalary() > employee2.getSalary()) return 1;
        else if(this.getSalary() < employee2.getSalary()) return -1;
        else{
            Manager employee = (Manager) employee2;
            if(this.getBonus() > employee.getBonus()) return 1;
            else if(this.getBonus() < employee.getBonus()) return -1;
            else return 0;
        }
    }

    @Override public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public void sort(){
        Collections.sort(employees);
    }
}
