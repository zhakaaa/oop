package Interface.example3;

public abstract class Animal {
    String type;
    int age;
    String color;
    String eyes;

    abstract void eat();
    abstract void sleep();
}

// Также благодаря интерфейсам классы могут множественно неследоваться от них что невозможно с абстрактными классами.