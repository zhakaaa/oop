import Time.Time;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Employee zhaka = new Employee("Zhaka", "0x00", 420000, new Date(2023,6,12));
        Employee azat = new Employee("Azat", "0x01", 1000000, new Date(2022,1,6));
        Employee maks = new Employee("Maks", "0x02", 565000, new Date(2020,10,27));
        Employee kayrat = new Employee("Kayrat", "0x03", 565000, new Date(2019,8,26));
        Manager manager = new Manager();

        manager.insert(zhaka);
        manager.insert(azat);
        manager.insert(maks);
        manager.insert(kayrat);

        Employee[] employees = new Employee[manager.getEmployeesList().size()];
        employees[0] = zhaka;
        employees[1] = azat;
        employees[2] = maks;
        employees[3] = kayrat;


        Chocolate[] chocolates = new Chocolate[5];
        chocolates[0] = new Chocolate("Twix", 50);
        chocolates[1] = new Chocolate("Mars", 48);
        chocolates[2] = new Chocolate("Snickers", 57);
        chocolates[3] = new Chocolate("Milky", 53);
        chocolates[4] = new Chocolate("Albeni", 60);


        Time[] times = new Time[8];
        times[0] = new Time(18,20,17);
        times[1] = new Time(1,59,59);
        times[2] = new Time(23,13,28);
        times[3] = new Time(16,2,32);
        times[4] = new Time(8,1,48);
        times[5] = new Time(18,20,17);
        times[6] = new Time(18,20,18);
        times[7] = new Time(18,19,17);

        Sort.mergeSort(times,0,times.length-1);
        for (Time time : times)
            System.out.println(time.toUniversal());


        Sort.bubbleSort(chocolates);
        for (Chocolate chocolate : chocolates){
            System.out.println(chocolate.toString());
        }


        System.out.println("\nMerge sort: ");
        Sort.mergeSort(employees, 0, employees.length-1);
        for (Employee e : employees){
            System.out.println(e);
        }

        System.out.println("\nBubble sort: ");
        Sort.bubbleSort(employees);
        for (Employee e : employees){
            System.out.println(e);
        }

    }
}