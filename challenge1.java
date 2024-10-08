import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;

public class challenge1 {
	static String searchAddress = "https://www.ecs.soton.ac.uk/people/";
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter email ID: ");
		try {
			String emailId = reader.readLine();
			String webPageAddress = searchAddress + emailId;
			var url = URI.create(webPageAddress).toURL();
			BufferedReader fromURL = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = fromURL.readLine();
			String name = "";
			while (line != null) {
				if (line.length() < 35) {
					line = fromURL.readLine();
					continue;
				}
				if (line.substring(19,24).equals("title")) {
					name = line.substring(35);
					break;
				}
				
				line = fromURL.readLine();
			}
			System.out.println(name.substring(0, name.length()-4));
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

