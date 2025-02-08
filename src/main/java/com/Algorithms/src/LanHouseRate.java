import java.util.Scanner;

public class LanHouseRate {
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);

        System.out.println("Enter the number of hours");
        int hours=input.nextInt();
        System.out.println("Enter the number of minutes");
        double minutes=input.nextDouble();
        double totalMinutos= hours*60 +  minutes;

        double totalToPay=Math.round(totalMinutos/15)*2;

        System.out.println("Total to pay: "+totalToPay);
        input.close();
    }
    
}
