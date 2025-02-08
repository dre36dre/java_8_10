import java.util.Scanner;

public class VehicleResale {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the vehicle model");
        String model= input.nextLine(); 
        System.out.println("Enter the vehicle model");
        double carPrice=input.nextDouble();
        double inputValue=0.5*carPrice;
        double remainder=carPrice*0.5/12;

        System.out.println("Vehicle name:"+model);

        System.out.println("Entry value:"+inputValue);
        System.out.println
        ("The value of the car with 50% down payment with the remaining balance of 12x installments: "+remainder);

    }
    
}
