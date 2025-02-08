import java.util.Scanner;

public class Dinner {
    double waiter_rate= 0.1;

     Scanner input= new Scanner(System.in);
    double calculate(){
  
        double dinner_value;
        double total_value=0;
        System.out.println("Enter the value of the dinner:");
        dinner_value=input.nextDouble();
        System.out.println("Numero de clientes");
        double numeroCliente=input.nextDouble();

        //total_value=dinner_value+(waiter_rate  * dinner_value);
        double porCliente= dinner_value/numeroCliente;

        return porCliente;
            }
}
