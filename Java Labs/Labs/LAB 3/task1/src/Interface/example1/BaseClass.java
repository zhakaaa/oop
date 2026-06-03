package Interface.example1;

public abstract class BaseClass {
    String eyes;  // for cat
    String vehicle; // for car
    double radius; // for moon

    abstract void move();
}


// Конечно, мы можем использовать абстрактный класс и создать в нем метод move() для наших конкретных классов.
// Но эти классы не имеют ничего общего между собой, и наследоваться от абстрактного класса ради одного метода
// противоречить логике абстрактных классов.