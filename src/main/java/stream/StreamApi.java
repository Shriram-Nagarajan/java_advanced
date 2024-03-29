package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static util.Utils.stringify;

import model.Employee;

public class StreamApi {

	// Basic filter and map
	private static List<String> cleanupString(List<String> strList) {
		return strList.stream()
				.filter(s -> s != null && !s.isBlank())
				.map(s -> s.trim())
				.toList();
	}
	
	// List to Array
	private static String[] listToArray() {
		List<String> list = Arrays.asList("Shriram", "Shalini", "Aumkar");
		return list.stream().toArray(String[]:: new);
	}
	
	// Increment salary of all employees by 10%
	private static List<Employee> incrementSalary(List<Employee> employee) {
		return employee.stream()
				.peek(emp -> emp.setSalary(emp.getSalary() * 1.10d))
				.toList();
	}
	
	// Flatmap
	private static List<Integer> flatten(List<List<Integer>> listOfIntList) {
		return listOfIntList.stream()
				.flatMap(innerList -> innerList.stream())
				.toList();
	}
	
	// Group by one of the attributes
	private static Map<Integer, List<Employee>> groupEmployeeByCountry(List<Employee> employees) {
		return employees.stream().collect(Collectors.groupingBy(Employee::getCompanyId));
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
		
		List<Employee> employeeList = new ArrayList<Employee>() {{
			add(new Employee(1, 1, "Shriram", "Chennai"));
			add(new Employee(2, 4, "Shalini", "Chennai"));
			add(new Employee(1, 2, "Kanthasamy", "Chennai"));
			add(new Employee(2, 5, "Dhana", "Madurai"));
		}};
		log.info("Group employee by company Id: " + groupEmployeeByCountry(employeeList));
		
		log.info("List of String to Array: " + stringify(listToArray()));
		
		List<Employee> empList = new ArrayList<Employee>() {{
			add(new Employee(1, "X", 45));
			add(new Employee(2, "Y", 64));
			add(new Employee(3, "Z", 31));
		}};
		
		log.info("Increment salary on Employee list: " +incrementSalary(empList));
	}

	private static final Logger log = Logger.getLogger(StreamApi.class.getName());

}
