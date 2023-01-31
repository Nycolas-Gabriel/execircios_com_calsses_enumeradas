package exercicio1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String department= sc.nextLine();
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName= sc.nextLine();
		System.out.print("Level: ");
		String workerLevel= sc.nextLine();
		System.out.print("Base salary: ");
		Double baseSalary= sc.nextDouble();
		
		Worker worker= new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(department));
        System.out.print("How many contracts to this worker? ");
        Integer n = sc.nextInt();
        
        for(int i = 1; i <= n; i++) {
        	System.out.println("Enter contract #"+i+" data: ");
        	System.out.print("Date (DD/MM/YYYY): ");
        	Date contractDate = sfd.parse(sc.next());
        	System.out.print("Value per hour: ");
        	Double contractValue = sc.nextDouble();
        	System.out.print("Duration (hours): ");
        	Integer contractHours = sc.nextInt();
        	HourContract contract  = new HourContract(contractDate, contractValue, contractHours);
        	worker.addContract(contract);
        }
        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String date = sc.next();
        int month = Integer.parseInt(date.substring(0, 2));
        int year = Integer.parseInt(date.substring(3));
        System.out.println("Name: "+ worker.getName());
        System.out.println("Department: "+ worker.getDepartment().getName());
        System.out.println("Income for "+ date +": "+worker.inCome(year, month));
        sc.close();
	}
	
}
