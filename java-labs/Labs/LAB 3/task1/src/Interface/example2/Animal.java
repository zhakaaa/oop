package Interface.example2;

public abstract class Animal {
    String type;
    int age;
    String color;
    String eyes;

    abstract void eat();
    abstract void sleep();

}

//public abstract class Animal {
//    String type;
//    int age;
//    String color;
//    String eyes;
//
//    abstract void eat();
//    abstract void sleep();
//    abstract void fly();
//    abstract void jump();
//    abstract void swim();
//    abstract void walk();
//}

// С помощью абстрактных классов мы задаем общую, базовую функциональность и с помощью интерфейсов мы говорим
// "что должен делать конкретно этот класс".
// Также благодаря интерфейсам мы избавляемся от ненужного нам функционала для конкретного класса
// Что упрощает код и считается логичной.