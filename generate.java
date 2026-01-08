package basics;
import java.util.stream.Stream;

public class generate {

	public static void main(String[] args) {
		Stream<Double> randomNumbers=Stream.generate(Math::random).limit(5);
		randomNumbers.forEach(System.out::println);
	
	
	
	}

}
