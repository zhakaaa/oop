import java.util.*;

public class Example4
{
    public static void main(String[] args)
    {
        double leftOperand,result, rightOperand;
        String leftString, operator, rightString;
        StringTokenizer tokenizer1;
        Scanner in = new Scanner(System.in);

        tokenizer1 = new StringTokenizer(in.nextLine(), " ", false);

        while(tokenizer1.hasMoreTokens()){
            StringTokenizer tokenizer  = new StringTokenizer(tokenizer1.nextToken(), "+-*/", true);
            try
            {
                leftString   = tokenizer.nextToken();  // NoSuchElementException, try to get value that don't exist. when inserted only one input while it need 3 operands
                operator     = tokenizer.nextToken();
                rightString  = tokenizer.nextToken();


                try{
                    leftOperand  = Double.parseDouble(leftString);
                }
                catch(NumberFormatException e){
                    System.out.println(leftString + " is not a number");
                }
                try{
                    rightOperand = Double.parseDouble(rightString);}

                catch(NumberFormatException e){
                    System.out.println(rightString + " is not a number");
                }

                leftOperand = Double.parseDouble(leftString);
                rightOperand = Double.parseDouble(rightString);

                if (operator.equals("+")) {result = leftOperand + rightOperand;System.out.println("Result: " + result);}
                else if(operator.equals("-")){ result = leftOperand - rightOperand;System.out.println("Result: " + result);}
                else if(operator.equals("*")){ result = leftOperand * rightOperand;System.out.println("Result: " + result);}
                else if(operator.equals("/")) {
                    if(rightOperand == 0) System.out.println("Division by zero");
                    else System.out.println("Result: " + leftOperand / rightOperand);
    //                try{
    //                    result = leftOperand / rightOperand;
    //                    System.out.println("Result: " + result);
    //                }
    //                catch (ArithmeticException e){System.out.println("Divide by zero");}

                }
                else result = 0.0;
            }

            catch (NoSuchElementException nsee)
            {
                System.out.println("Invalid syntax");
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("One or more operands is not a number");
            }
        }


    }
}
