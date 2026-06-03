public abstract class Chef implements MakePizza {

    @Override public void addCheese() {
        System.out.println("Cheese was added");
    }

    @Override public void addPepperoni() {
        System.out.println("Pepperoni was added");
    }

    @Override public void addSauce() {
        System.out.println("Sauce was added");
    }

    @Override public void addTomato(){
        System.out.println("Tomato was added");
    }
}
