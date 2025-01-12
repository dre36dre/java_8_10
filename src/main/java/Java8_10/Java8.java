package Java8_10;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Java8 {
public static void main(String[] args) {
	arquivo();

	
}
public static void quadrado(){
	List<Integer> numeros=Arrays.asList(1,2,3,4);
	
	List<Integer> quadrados=numeros.stream()
			.map(numero -> numero *numero)
			.collect(Collectors.toList());
	
	System.out.println(quadrados);
	}
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

 public static void escritaArquivo()
 {
	try{
		String novoFuncionario ="""
				 {
    "nome": "Anderson ",
    "idade": 45,
    "cargo": "Desenvolvedor de sistemas",
    "departamento": "Projetos",
    "salario": 5700.00,
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

