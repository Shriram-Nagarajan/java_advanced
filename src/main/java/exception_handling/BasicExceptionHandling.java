package exception_handling;

import java.util.logging.Logger;

public class BasicExceptionHandling {
	
	private static final Logger log = Logger.getLogger(BasicExceptionHandling.class.getName());
	
	private static void read() {
		try {
			throw new InterruptedException("test");
		}	catch(Exception e) {
			log.warning("Exception occurred: "+ e.getMessage());
		}
	}

	public static void main(String[] args) {
		read();
	}
}
