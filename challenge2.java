import java.io.*;
import java.util.regex.*;
import java.nio.file.*;
import java.util.List;
import java.util.ArrayList;

public class challenge2 {
	
	public static List<Pair<String, Integer>> variables = new ArrayList<>();
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter file name: ");
		Path path = "C:\\Users\\Miran\\OneDrive\\Documents\\University\\comp1312\\Space_Cadets\\" + reader.readLine() + ".txt"
		File textFile = new File(path);
		if (textFile.exists() && textFile.canRead())
		{
			List<String> lines = Files.readAllLines(path);
			for (String line : lines)
				Interpreter(line);
		}
		else {
			System.out.println("File error");
		}	
	}
	
	public static int Find(String key)
	{
		Integer i = 0;
		for (Pair<String, Integer> pair : challenge2.variables) {
			if (pair.getFirst().equals(key)) {
				return i;
			}
			i = i+1;
		}
		return -1;
	}
	
	public static void Clear(String word)
	{
		Integer index = Find(word);
		if (index == -1) {
			Pair<String, Integer> newPair =  new Pair(word, 0);
			variables.add(newPair);
		}
		else {
			variables[index].setSecond(0);
		}
	}
	
	public static void Incr(String word)
	{
		current = challenge2.variables[Find(word)].getSecond();
		challenge2.variables[Find(word)].setSecond(current + 1);
	}
	
	public static void Decr(String word)
	{
		current = challenge2.variables[Find(word)].getSecond();
		if (current == 0) {
			System.out.println("Variable must be non-negative integer");
			return;
		}
		challenge2.variables[Find(word)].setSecond(current - 1);
	}
	
	public static void Print(String line)
	{
		System.out.println(line);
		for (Pair<String, Integer> pair : challenge2.variables) {
			System.out.println(pair.getFirst() + ": " + pair.getSecond());
		}
		System.out.println();
	}
	
	public static void Interpreter(String line)
	{
		String regex = "[,\\.\\s\\;]";
		String[] words = line.split(regex);
		switch(words[0]) {
			case "clear":
				Clear(words[1]);
				break;
			case "incr":
				Incr(words[1]);
				break;
			case "decr":
				Decr(words[1]);
				break;
			case "while":
				break;
			default:
				System.out.println("Error");
		}
		Print(line);
		
	}
	
	
	
}
