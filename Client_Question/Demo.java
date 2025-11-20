package Client_Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo {
	public static void main(String[] args) {
		String s = "naman";
		String temp=s;
		String s1 = new StringBuffer(s).reverse().toString();
		//Arrays.stream(s.split("")).map(new StringBuffer(s))
		if(temp.equals(s1)) {
			System.out.println("Palindrom");
		}
		else {
			System.out.println("Not");
		}
		
		//a[]={1,5,-1,-1,0,-1,7.=1}  o/p 0,1,57,-1-1,-1,-1 
		//1
		int[] a = {1, 5, -1, -1, 0, -1, 7, 1};
		List<Integer> list = IntStream.of(a).boxed().collect(Collectors.toList());
		List<Integer> res1= list.stream().filter(n->n!=-1).collect(Collectors.toList());
		List<Integer> res2= list.stream().filter(n->n==-1).collect(Collectors.toList());
		List<Integer> finalRes = new ArrayList<>();
		finalRes.addAll(res1);
		finalRes.addAll(res2);
		System.out.println(finalRes);
		//2
		Map<Boolean, List<Integer>> res4= list.stream().collect(Collectors.partitioningBy(x->x!=-1));
		List<Integer> result = new ArrayList<>();
		result.addAll(res4.get(true));
		result.addAll(res4.get(false));
		System.out.println(result);
		
		// Output: {1=[a], 2=[bb, dd], 3=[ccc]}
		List<String> words = Arrays.asList("a", "bb", "ccc", "dd");
		Map<Integer, List<String>> res=  words.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(res);
		
		//List<Integer> numbers = Arrays.asList(1, 2, 3, 4);//o/p 24
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		Optional<Integer> res3= numbers.stream().reduce((c,b)->c*b);
		System.out.println(res3);
		
		
		
		
		
		
		
		
		
	}

}
