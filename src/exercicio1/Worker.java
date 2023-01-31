package exercicio1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void setContracts(List<HourContract> contracts) {
		this.contracts = contracts;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
public void addContract(HourContract contract) {
	contracts.add(contract);
}
public void removeContract(HourContract contract) {
	contracts.remove(contract);
}
public Double inCome(Integer year, Integer month ) {
	Double sum = baseSalary;
	
	Calendar cal = Calendar.getInstance();
	for(HourContract a: contracts) {
		cal.setTime(a.getDate());
		Integer c_month= cal.get(Calendar.MONTH);
		Integer c_year = 1 + cal.get(Calendar.YEAR);
		if(year == c_year && month == c_month) {
		sum += a.totalValue();
	}
}
	return sum;
}
}