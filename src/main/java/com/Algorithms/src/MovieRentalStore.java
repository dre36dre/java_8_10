import java.util.Scanner;

public class MovieRentalStore {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("Enter the movie title:");
        String movieTitle=input.nextLine();
        System.out.println("Enter the duration in hours:");
        int durationHours=input.nextInt();
        System.out.println("Enter the duration in minutes:");
        int durationMinutes=input.nextInt();
        int totalDuration=durationHours*60+durationMinutes;

        System.out.println("Total duration in minutes: "+totalDuration);
    }
}
