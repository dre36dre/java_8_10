package Java_8_10;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Java8 {
 void main(String[] args) {
idade();
	
}
//Api Date Time
public static void idade(){
	LocalDate hoje=LocalDate.now();

	System.out.println(hoje);

	LocalDate aniversario=LocalDate.of(1979,Month.FEBRUARY,28);
	DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd 'de'  MMMM 'de' yyyy");

	String dataFormatada= aniversario.format(formatter);

	System.out.println("Aniversário: "+dataFormatada);

	int idade=aniversario.until(hoje).getYears();

	System.out.println("Idade: "+idade);
}



//Método sum()
public static void soma(){
	IntStream numbers=IntStream.of(1,2,3,5);
	 int sum=numbers.sum();
	System.out.println("Soma: "+sum);
}

//Método count() 
public static void quantidadeElementos(){
	List<Integer> numeros=Arrays.asList(5,6,3,7,8);
	long  numero=numeros.stream().count();

	System.out.println("Quantidade: "+numero);
}


//Método sorted
public static void listaOrdenada(){
	List<Integer> numeros= Arrays.asList(6,3,4,8,7,1);
	List<Integer> ordenados=numeros.stream().sorted().collect(Collectors.toList());
	System.out.println("Original: "+ numeros);
	System.out.println("Ordenados: "+ordenados);
}


//Método reduce
public static void somaTodos(){
	List<Integer> numbers= Arrays.asList(1,2,3,4,5,6);

	int sum = numbers.stream().reduce(0,(a,b) -> a + b );

	System.out.println("Soma: "+sum);
}

public static void numeroPar(){
	List<Integer> numeros= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	List<Integer> numerosPares= numeros.stream().filter(numero -> numero % 2 == 0)
	.collect(Collectors.toList());

	System.out.println("Numeros pares: "+numerosPares);
}

//Ao quadrado
public static void quadrado(){
	List<Integer> numeros=Arrays.asList(1,2,3,4);
	
	List<Integer> quadrados=numeros.stream()
			.map(numero -> numero *numero)
			.collect(Collectors.toList());
	
	System.out.println("Quadrados: "+quadrados);
	}

	//Arquivo
 public static void arquivo()
 {
	try {
		String texto=Files.readString(Path.of
		("/workspaces/java_8_10/src/main/resources/funcionarios.json"));
	//	/workspaces/java_8_10/src/main/resources/funcionarios.json
	System.out.println(texto);
	}catch(IOException e)
	{
		e.printStackTrace();
	}

 }

 //Escrita de arquivo
 public static void escritaArquivo()
 {
	try{
		String novoFuncionario ="""
				 {
    "nome": "Anderson ",
    "idade": 45,
    "cargo": "Desenvolvedor de sistemas",
    "departamento": "Projetos",
    "salario": 100000.00,
    "endereco": {
      "rua": "Avenida dos Projetos",
      "numero": 123,
      "cidade": "São Paulo",
      "estado": "SP",
      "cep": "87654-321"
    }
				""";
				Files.writeString(Path.of("/workspaces/java_8_10/src/main/resources/funcionarios.json"),
				novoFuncionario,StandardOpenOption.APPEND);
	}catch(IOException e){
		e.printStackTrace();
	}
 }

}

