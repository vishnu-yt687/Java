package basics;
import java.util.Arrays;
import java.util.stream.IntStream;

public class arrayStream {

	public static void main(String[] args) {
		int[] nums= {2,4,6,8,10};
		IntStream intStream=Arrays.stream(nums);
		intStream.forEach(System.out::println);
		
	
	
	
	}

}
