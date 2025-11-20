package Java8_Pratiksha;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DemoSTS {
	public static void main(String[] args) {
		List<Integer> num= Arrays.asList(12,1,23,24,56,1,87,98);
		Optional<Integer> res =num.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
		System.out.println(res);
	}
}
