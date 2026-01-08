package basics;
import java.util.*;

public class FirstClass {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		System.out.println("Enter any positive number :");
		int num=input.nextInt();
		for(int i=0;i<=num;i++) {
			if (i%2!=0) {
				System.out.println(i);
			}
		}
		
		
		
		
		
		
		input.close();

	}

}
