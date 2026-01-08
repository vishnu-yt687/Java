package basics;
import java.util.stream.Stream;

public class iterate {

	public static void main(String[] args) {
		Stream<Integer> evenStream = Stream.iterate(0,a->a+2).limit(20);
		evenStream.forEach(System.out::println);
	
	
	
	}

}
