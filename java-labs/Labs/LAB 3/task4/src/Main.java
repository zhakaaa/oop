import java.util.Collections;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Employee zhaka = new Employee("Zhaka", "0x00", 420000, new Date(2023,6,12));
        Employee azat = new Employee("Azat", "0x01", 1000000, new Date(2022,1,6));
        Employee maks = new Employee("Maks", "0x02", 565000, new Date(2020,10,27));
        Employee kayrat = new Employee("Kayrat", "0x03", 565000, new Date(2019,8,26));
        maks.addBonus(100);

        try{
            Employee copyKayrat = (Employee) kayrat.clone();
            System.out.println(copyKayrat.toString());
            System.out.println(kayrat.toString());
            System.out.println("clone() method implementation\n");
        }
        catch(CloneNotSupportedException e){
            e.printStackTrace();
        }


        Manager manager = new Manager();

        manager.insert(zhaka);
        manager.insert(azat);
        manager.insert(maks);
        manager.insert(kayrat);

        Collections.sort(manager.getEmployeesList(), Employee.compareByName);

        for (Employee e : manager.getEmployeesList()){
            System.out.println(e);
        }

    }
}