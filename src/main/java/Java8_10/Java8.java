package Java8_10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Java8 {
public static void main(String[] args) {
	List<Integer> numeros=Arrays.asList(1,2,3,4);
	
	List<Integer> quadrados=numeros.stream()
			.map(numero -> numero *numero)
			.collect(Collectors.toList());
	
	System.out.println(quadrados);
}
}

