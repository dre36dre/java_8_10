import java.util.Scanner;

public class Dinner {
    double waiter_rate= 0.1;

     Scanner input= new Scanner(System.in);
    double calculate(){
  
        double dinner_value;
        double total_value;
        System.out.println("Enter the value of the dinner:");
        dinner_value=input.nextDouble();

        total_value=dinner_value+(waiter_rate  * dinner_value);

        return total_value;
            }
}
