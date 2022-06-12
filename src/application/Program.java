package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;


public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> emps = new ArrayList<>(); 
		
		System.out.print("Nome do departamento: ");
		String name = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		Integer payDay = sc.nextInt();
		sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Telefone: ");
		String phone = sc.nextLine();	    
		
		System.out.println();
		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i=0;i<n;i++) {
			System.out.println("Dados do funcionário " + (i+1) + ":");
			System.out.print("Nome: ");
			String empName = sc.nextLine();
			System.out.print("Salário: ");
			Double empSalary = sc.nextDouble();
			sc.nextLine();
			
			Employee emp = new Employee(empName, empSalary);
			
			emps.add(emp);
			
		}
		
		Department dep = new Department(name, payDay, new Address(email, phone), emps);
		
		showReport(dep);
		
		
        sc.close();
	}

	private static void showReport(Department dept) {

          System.out.printf("%nFOLHA DE PAGAMENTO: ");
          System.out.printf("%nDepartamento de " + dept.getName() + " = R$ " + dept.payroll());
          System.out.printf("%nPagamento realizado no dia " + dept.getPayDay());
          System.out.printf("%nFuncionários: ");
          
          for (Employee emp : dept.getEmployees()) {
        	  System.out.printf(emp.getName() + "%n");
          }
          
          System.out.printf("%nPara dúvidas favor entrar em contato: " + dept.getAddress().getEmail());
		 }
	
	
	
}
