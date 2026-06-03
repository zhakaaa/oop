public class Dog extends Animal {
    int age2;
    public Dog(String name, int age2, int age) {
        super(name,age);
        this.age2 = age2;
    }

    public void  show(){
        System.out.println(age +  "" + age2+" "+name);
    }
}
