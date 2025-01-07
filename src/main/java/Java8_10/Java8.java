package Java8_10;

import java.util.Arrays;
import java.util.List;


public class Java8 {
public static void main(String[] args) {
	List<Integer> integers= Arrays.asList(1,2,3,4,5);
	
	integers.forEach(x->System.out.println(x));
}
}