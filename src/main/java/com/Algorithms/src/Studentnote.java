import java.util.Scanner;

public class Studentnote {
    public static void main(String[] args) {
        
    Scanner input=new Scanner(System.in);

    double note1,note2,note3,note4;
    System.out.println("Nota 1:");
    note1=input.nextDouble();
    System.out.println("Nota 2:");
    note2=input.nextDouble();
    System.out.println("Nota 3:");
    note3=input.nextDouble();
    System.out.println("Nota 4:");
    note4=input.nextDouble();
    
    double average=(note1+note2+note3+note4)/4;
    
    System.out.println("Arithmetic mean: "+average);
    }
}
