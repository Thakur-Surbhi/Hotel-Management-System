package Client_Question;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo3 {
	public static void main(String[] args) {
		String str = "Hello world";
		Map<Character, Long> res =str.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(res);
	}

}
