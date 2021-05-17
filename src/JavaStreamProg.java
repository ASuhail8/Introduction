import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class JavaStreamProg {

	public static void main(String[] args) {
		/*
		 * ArrayList<String> al = new ArrayList<String>(); al.add("Abdulla");
		 * al.add("Suhail"); al.add("Aziz"); al.add("Sana"); al.add("Azhar"); int count
		 * = 0; for (int i = 0; i < al.size(); i++) { String name = al.get(i); if
		 * (name.startsWith("A")) { count++; } } System.out.println(count); }
		 */

		ArrayList<String> al = new ArrayList<String>();
		al.add("Abdulla");
		al.add("Suhail");
		al.add("Aziz");
		al.add("Sana");
		al.add("Azhar");

		long c = al.stream().filter(s -> s.startsWith("A")).count();
		System.out.println();

		Stream.of("Minni", "Tiddu", "Gingu", "oreo").filter(s -> s.length() > 4).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		List<String> footballers = Arrays.asList("Abhi", "Azhar", "ronaldo", "messi", "messi");

		// footballers.stream().filter(s -> s.endsWith("i")).sorted().map(s ->
		// s.toUpperCase())
		// .forEach(s -> System.out.println(s));

		ArrayList<String> bl = new ArrayList<String>();
		bl.add("man");
		bl.add("woman");
		// merge 2 lists
		Stream<String> str = Stream.concat(al.stream(), bl.stream());
		// str.sorted().forEach(s->System.out.println(s));
		boolean flag = str.anyMatch(s -> s.equalsIgnoreCase("Sana"));
		Assert.assertTrue(flag);

		List<String> l = footballers.stream().filter(s -> s.endsWith("i")).map(s -> s.toUpperCase())
				.collect(Collectors.toList());
		System.out.println(l);
		System.out.println("-----------------");

		// Assignment
		
		Integer[] arr = {3,2,2,5,7,5,1,7,9};
		
		List<Integer> list = Arrays.asList(arr);
		list.stream().distinct().sorted().forEach(s->System.out.println(s));
		System.out.println(list.stream().distinct().sorted().collect(Collectors.toList()).get(2));
		
		

	}

}
