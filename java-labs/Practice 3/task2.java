import java.util.HashSet;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        HashSet<Person> persons = new HashSet<Person>();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("1:Add user\n2:Print list\n0:Exit ");
            int choice = sc.nextInt();

            if(choice == 2) {
                if(!persons.isEmpty()){
                    for(Person person : persons){
                        System.out.println(person.toString());
                    }
                }
                else
                    System.out.println("No persons found");
            }
            else if(choice == 1) {
                Scanner sc1 = new Scanner(System.in);
                sc1.useDelimiter("\\n");
                System.out.println("Do you want to add \n1:Person\n2:Student\n3:Staff");
                int choice2 = sc1.nextInt();

                if(choice2 == 1){
                    System.out.println("Enter person Name: ");
                    String name = sc1.next();
                    System.out.println("Enter person Address: ");
                    String address = sc1.next();
                    Person person = new Person(name, address);
                    persons.add(person);
                }

                else if(choice2 == 2) {
                    System.out.println("Enter student Name: ");
                    String name = sc1.next();
                    System.out.println("Enter student Address: ");
                    String address = sc1.next();
                    System.out.println("Enter student Program: ");
                    String program = sc1.next();
                    System.out.println("Enter student Year: ");
                    int year = sc1.nextInt();
                    System.out.println("Enter student Fee: ");
                    double fee = sc1.nextDouble();
                    Student student = new Student(name,address,program,year,fee);
                    persons.add(student);

                }
                else if(choice2 == 3) {
                    System.out.println("Enter staff Name: ");
                    String name = sc1.next();
                    System.out.println("Enter staff Address: ");
                    String address = sc1.next();
                    System.out.println("Enter staff School: ");
                    String school = sc1.next();
                    System.out.println("Enter staff Pay: ");
                    double pay = sc1.nextDouble();

                    Staff staff  = new Staff(name,address,school,pay);
                    persons.add(staff);
                }
                else System.out.println("Invalid choice");
            }

            else if(choice == 0) {
                break;
            }
            else System.out.println("Invalid choice");
        }
    }
}
