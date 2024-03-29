package multi_threading;

import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class FactorialThread implements Runnable {
	
	private static ConcurrentHashMap<Integer, Long> factMap = new ConcurrentHashMap<Integer, Long>(); 

	int number;
	
	private int factorial(int num) {
		return (num <= 1) ? 1 : num * factorial(num-1);
	}
	
	public FactorialThread(int number) {
		this.number = number;
	}
	
	@Override
	public void run() {
		long time = System.nanoTime();
		long factorial = factorial(number);
		Logger.getLogger(MTWithExecutorService.class.getName()).info("Factorial of " + number + " is " + factorial);
		factMap.put(number, factorial);
		Logger.getLogger(MTWithExecutorService.class.getName()).info("Factorial computed in " + (System.nanoTime() - time) + " nanoseconds");
	}
	
}