package basics;
import java.util.*;

public class FP2 {

	public static void main(String[] args) {
		List<Integer> l1=List.of(1,2,3,4,5,6,12,15,17,16,20,345,35346,456);
	//	l1.stream().filter(n -> n%2==0).forEach(System.out::println);
		Optional<Integer> sum= l1.stream().filter(n->n%2==0).reduce(Integer::sum);
		System.out.println(sum.get());
		
	
	
	
	}

}
