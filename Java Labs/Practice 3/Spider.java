public class Spider extends Animal {
    @Override public void property(){
        super.property();
        System.out.println("shh-shh");
    }

    @Override public void property(int i){
        super.property(i);
        System.out.println(i);
    }
}
