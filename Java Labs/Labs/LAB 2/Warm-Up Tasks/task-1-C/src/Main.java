public class Main {
    public static void main(String[] args) {
        Animal lion = new Lion("Lion", 10, "Yellow");
        Animal lion2 = new Lion("Lion", 11, "Brown");
        Animal lion3 = new Lion("iLon", 10, "Yellow");
        Animal jiraffe = new Jiraffe("Lion", 10, 5);
        Animal animal = new Animal("Bird",10);

        System.out.println(lion.equals(lion2));
        System.out.println(lion.hashCode());
        System.out.println(lion2.hashCode());

        System.out.println(lion.equals(lion3));
        System.out.println(lion.hashCode());
        System.out.println(lion3.hashCode());

        System.out.println(animal.equals(lion));
        System.out.println(animal.hashCode());
        System.out.println(lion.hashCode());

        System.out.println(lion3.equals(jiraffe));
        System.out.println(lion3.hashCode());
        System.out.println(jiraffe.hashCode());



    }
}