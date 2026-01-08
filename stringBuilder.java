package basics;
import java.util.stream.Stream;

public class stringBuilder {

	public static void main(String[] args) {
		Stream.Builder<String> builder=Stream.builder();
		builder.add("C").add("Python").add("Java");
		Stream<String> strStream=builder.build();
		strStream.forEach(System.out::println);
		
	
	
	
	}

}
