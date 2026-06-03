public class Dog extends Animal {
   @Override public void property(){
       super.property();
       System.out.println("gaw-gaw");
    }

    @Override public void property(int i){
        super.property(i);
        System.out.println(i);
    }
}
