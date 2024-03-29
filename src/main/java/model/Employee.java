package model;

import java.util.Random;

public class Employee {
	int companyId;
	int employeeId;
	String employeeName;
	String currentCity;
	double salary;
	
	public Employee() {}
	
	public Employee(int companyId, int employeeId, String employeeName, String currentCity) {
		this.companyId = companyId;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.currentCity = currentCity;
		this.salary = companyId * new Random().nextDouble() * 10;
	}
	
	public Employee(int employeeId, String employeeName, double salary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getCurrentCity() {
		return currentCity;
	}
	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return getEmployeeName() + " : " + (Math.round(salary * 100.0) / 100.0);
	}
}
