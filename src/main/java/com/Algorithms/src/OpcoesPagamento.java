import java.util.Scanner;

public class OpcoesPagamento {
    public static void main(String[] args) {
        
    
    Scanner input= new Scanner(System.in);
    System.out.println("Digite o valor do produto");
    double valorProduto=input.nextDouble();

    System.out.println("Valor a vista: "+valorProduto*0.9);
    System.out.println("Parcelado: "+valorProduto/3);
    
}
}