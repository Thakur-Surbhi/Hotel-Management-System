package Client_Question;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringEx1 {
	public static void main(String[] args) {
		List<String> Str = Arrays.asList("Apple", "Bat", "Orange", "Avacado", "Banana", "Aeroplane");
		// 1. Find the string which starts with 'A'.
		List<String> Str1= Str.stream().filter(s->s.startsWith("A")).collect(Collectors.toList());
		System.out.println(Str1);

		List<String> str2 = Arrays.asList("101", "233", "124", "145", "345", "678");
		List<String> Str3= str2.stream().filter(s->s.startsWith("1")).map(Integer::parseInt).map(String::valueOf).collect(Collectors.toList());
		System.out.println(Str3);

		//2. Find the longest string word.
		Optional<String> str4 = Str.stream().max(Comparator.comparing(String::length));
		System.out.println(str4);



		//Q.2  String s="swiss";
		//Find the first count of each char.
		String s="swiss";

		Map<Character, Long> charCount = s.chars()
				
				.mapToObj(c -> (char) c)
				.collect(
						LinkedHashMap::new,
						(map, c) -> map.putIfAbsent(c, s.chars().filter(ch -> ch == c).count()),
						Map::putAll
						);

		charCount.forEach((k, v) -> System.out.println(k + ": " + v));

		//Find the first non repeated character
		Map<Character, Integer> firstnonrep = new HashMap<>();
		for(char c : s.toCharArray()) {
			firstnonrep.put(c, firstnonrep.getOrDefault(c, 0) +1);
		}

		for(Map.Entry<Character, Integer> entry :firstnonrep.entrySet()) {
			if(entry.getValue()==1)
				System.out.println("First Non Repeatating char : "+entry.getKey());
		}

		List<String> fruit = Arrays.asList("Apple", "banaana", "Orange", "Mango", "lemon");
		Map<Integer, List<String>> res= fruit.stream().collect(Collectors.groupingBy(String::length));

		res.forEach((length, word)->System.out.println("length"+ length + " :"+word));


		String s1 = " my name is haridini and my frinds name is abc "; 
		// - Calculate first non-repeating word . 
		String[] words = s1.trim().split("\\s+");

		Map<String, Integer> wordCount = new LinkedHashMap<>();
		for(String word :words) {
			wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
		}

		for( Map.Entry<String , Integer> entry  : wordCount.entrySet()) {
			if(entry.getValue()==1) {
				System.out.println("First Non reepeating character "+entry.getKey());
				break;
			}
		}
		
		//Frequenecy of words
		String s2 = " my name is haridini and my frinds name is abc ";
		String [] word1 = s2.trim().split(" ");
		
		Map<String, Integer> map = new LinkedHashMap<>();
		for(String word : word1) {
		map.put(word, map.getOrDefault(word, 0)+1);
		}
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue()>1) {
				System.out.println("First repeatating String is : "+entry.getKey());
				break;
			}
		}
		
	Map<String, Long> map1 = Arrays.stream(s2.trim().split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	map1.forEach((K,V)->System.out.println("String Count : "+K+" : "+V));	
	
	//given list of string "potato:veg" , "mango:fruits","banana:fruits"
	//use stream print the elements divided into two categories 
	//fruits and vegs
	List<String> items = Arrays.asList("potato:veg" , "mango:fruits","banana:fruits");
	Map<String, List<String>> grp= items.stream().map(d->d.split(":")).collect(Collectors.groupingBy(arr->arr[1], Collectors.mapping(arr->arr[0], Collectors.toList())));
	
	System.out.println("Fruit : "+grp.getOrDefault("fruits", Collections.emptyList()));
	System.out.println("veg : "+grp.getOrDefault("veg", Collections.emptyList()));
	
	}

}


