import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum Gender{
    B,
    G
}

class Person{

    String boy, girl;

    public Person(){
        this.boy = Gender.B.toString();
        this.girl = Gender.G.toString();
    }

    public String toStringBoy(){
        return boy;
    }

    public String toStringGirl(){
        return girl;
    }
}

class DragonLaunch {
    private String launch,notLaunch;

    private List <Character> kidnappedPerson = new ArrayList<>();

    public DragonLaunch(String launch){
        this.launch = launch;
    }

    public void kidnap(Person p){
        notLaunch = p.toStringBoy() + p.toStringGirl();
        willDragonEatOrNot();
        for(int i = 0; i < launch.length(); i++){
            kidnappedPerson.add(launch.charAt(i));
        }

        if(!kidnappedPerson.isEmpty())
            System.out.println("Kidnapped people: " + kidnappedPerson);
        else
            System.out.println("No kidnapped person");
    }

    private void willDragonEatOrNot(){
        while(launch.contains(notLaunch)){
            launch = launch.replaceAll(notLaunch,"");
        }
//        int i = 0;
//        while(true){
//            boolean flag = false;
//            if(person.toStringBoy().equals(launch.charAt(i)) && person.toStringGirl().equals(launch.charAt(i+1))){
//                flag = true;
//                launch.replace(launch.charAt(i), ' ');
//                launch.replace(launch.charAt(i+1), ' ');
//                i++;
//                i++;
//
//            }
//            i++;
//
//            if(!flag) break;
//            if(i == launch.length() - 1) i=0;
//        }
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String boysGirls = sc.nextLine();

        Person person = new Person();

        DragonLaunch dragonLaunch = new DragonLaunch(boysGirls);
        dragonLaunch.kidnap(person);

    }
}