package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StreamApi {

	// Basic filter and map
	private static List<String> cleanupString(List<String> strList) {
		return strList.stream()
				.filter(s -> s != null && !s.isBlank())
				.map(s -> s.trim())
				.toList();
	}
	
	// Flatmap
	private static List<Integer> flatten(List<List<Integer>> listOfIntList) {
		return listOfIntList.stream()
				.flatMap(innerList -> innerList.stream())
				.toList();
	}

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>() {
			{
				add("Hello");
				add(null);
				add("      ");
				add("             string with leading empty space");
			}
		};
		log.info("Cleaned strings: " + cleanupString(strList));
		
		List<Integer> intList = new ArrayList<Integer>() {{
			add(10);
			add(100);
			add(1000);
		}};
		
		List<Integer> intList2 = new ArrayList<Integer>() {{
			add(20);
			add(200);
			add(2000);
		}};
		
		List<List<Integer>> listOfIntList = new ArrayList<List<Integer>>() {{
			add(intList);
			add(intList2);
		}};
		log.info("Flattened integer list: "+ flatten(listOfIntList));
	}

	private static final Logger log = Logger.getLogger(StreamApi.class.getName());

}
