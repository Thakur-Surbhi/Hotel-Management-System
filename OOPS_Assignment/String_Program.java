package OOPS_Assignment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class String_Program {

	public static void main(String[] args) {
		//1. Write a Java program to check if a string is a palindrome.
		String s="MADAN";
		String rev="";

		StringBuilder sb = new StringBuilder(s).reverse();
		rev= sb.toString();
		System.out.println("Reverse of string is : "+rev);

		if(s.equals(rev))
			System.out.println("String is Palindrom");
		else
			System.out.println("String is not palindrom");

		//2. Write a Java program to count the number of vowels in a string.
		String s1= "Surbhi";
		List<Character> vowels = Arrays.asList('A', 'E', 'I', 'O', 'U', 
				'a', 'e', 'i', 'o', 'u');
		List<Character> vowelCount = s1.chars().mapToObj(c->(char) c).filter(vowels::contains).collect(Collectors.toList());
		System.out.println("Vowel Count is " + vowelCount);

		//2. Write a Java program to count the number of consonant in a string.
		List<Character> ConsonantCount = s1.chars().mapToObj(c->(char) c).filter(c->!vowels.contains(c)).collect(Collectors.toList());
		System.out.println("Consonant Count is " + ConsonantCount);

		//5. Write a Java program to check if two strings are anagrams.
		String s3= "Listen";
		String s4 = "Silent";
		char[] ch= s3.toLowerCase().toCharArray();
		Arrays.sort(ch);
		System.out.println(ch);
		char[] ch1=s4.toLowerCase().toCharArray();
		Arrays.sort(ch1);
		System.out.println(ch1);
		if(Arrays.equals(ch, ch1))
			System.out.println("Strings are anagram ");
		else
			System.out.println("String are not anagram");

		//6. Write a Java program to remove all white spaces from a string.
		String s5="Sur bh i mandre  le";
		System.out.println("After removing whitespace   : "+s5.replaceAll(" ", ""));

		//7. Write a Java program to replace all occurrences of a character in a string.
		String s6="Surbhi";
		System.out.println(s6.replace("u", "ooo"));

		//8. Write a Java program to convert a string to lowercase.
		String s7="Surbhi Madansingh Mandrele";
		System.out.println("String in lower case : "+s7.toLowerCase());

		//9. Write a Java program to convert a string to uppercase.
		System.out.println("String in upper case : "+s7.toUpperCase());

		//10. Write a Java program to find the length of a string without using length() method.
		String s8="Surbhi";
		int count =0;
		char[] ch8 =s8.toCharArray();
		for (char c : ch8){
			count++;
		}
		System.out.println("Length of string :  " +count);
	}
}
