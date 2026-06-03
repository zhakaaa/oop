package Abstract.example1;

public abstract class Human {
   String eyes, hair, nose, xChromosome;

   int height, weight, arm;


    // Конкретика
    abstract void eat();
    abstract void walk();
    abstract void sleep();

}


// Необходимо выделить общий код между несколькими связанными классами
// Создание иерархии по классам. Создать модель максимально похожим на реальную жизнь.