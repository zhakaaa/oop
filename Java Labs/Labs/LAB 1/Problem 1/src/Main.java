import java.util.Scanner;

class Data{

    double average, maximum;
    int value,counter = 0;
    String data = "";


    public Data() {
        average = 0;
        maximum = 0;
        value = 0;
    }

    public void Run(){

            while (true) {

                addData();

                if(data.equalsIgnoreCase("Q")){
                    Analyzer analyzer = new Analyzer();
                    System.out.println("Average: " + analyzer.getAverage(average, counter));
                    System.out.println("Maximum: " + analyzer.getMaximum(maximum));
                    break;
                }

                try {
                    value = Integer.parseInt(data);
                    average += value;
                    if (value > maximum) {
                        maximum = value;
                    }
                    counter++;
                }
                catch (Exception e) {
                    System.out.println("Invalid input");
                }
            }
    }

    public void addData(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number (Q to quit): ");
        data = input.nextLine();
    }
}

class Analyzer {

    public double getAverage(double average,int counter){
        return average / counter;
    }

    public double getMaximum(double maximum){
        return maximum;
    }
}
public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        data.Run();
    }
}