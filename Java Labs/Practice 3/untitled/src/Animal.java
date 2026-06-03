public class Animal
{
    public String name;
    public int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Animal(){
        System.out.println("Animal Constructor");
    }

    public void  show(){
        System.out.println(age +  "" + " "+name);
    }
}
