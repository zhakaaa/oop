public class Cow extends Animal{
    @Override public void property(){
        super.property();
        System.out.println("myy-myy");
    }

    @Override public void property(int i){
        super.property(i);
        System.out.println(i );
    }
}
