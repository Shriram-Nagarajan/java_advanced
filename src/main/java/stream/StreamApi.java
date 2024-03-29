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
	}

	private static final Logger log = Logger.getLogger(StreamApi.class.getName());

}
