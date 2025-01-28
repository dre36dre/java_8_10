import java.util.Scanner;

public class Travel {
    public static void main(String[] args) {
    
    int day=0;
    int hours=0;
    int totalHours;
    Scanner in= new Scanner(System.in);
    System.out.println("Please inform the number of days of the trip:");
    day=in.nextInt();
    System.out.println("Please inform the number of hours of the trip");
        hours=in.nextInt();
        totalHours=day *24+hours;

        System.out.println("The total value of the trip hours in hours was: "+totalHours);
        in.close();
    }
}
