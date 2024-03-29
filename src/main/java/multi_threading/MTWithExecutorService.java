package multi_threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MTWithExecutorService {
	
	public static void main(String[] args) {
		
		FactorialThread th1 = new FactorialThread(5);
		FactorialThread th2 = new FactorialThread(10);
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(th1);
		service.submit(th2);
		
		service.shutdown();
	}
}
