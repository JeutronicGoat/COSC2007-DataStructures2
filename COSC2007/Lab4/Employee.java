
public class Employee implements Comparable<Employee> {

	private int id;
	private String FName;
	private String LName;
	
	Employee(){}
	
	Employee(int id, String LName, String FName){
		this.id = id;
		this.FName = FName;
		this.LName = LName;
	}
	
	@Override
	public String toString() {
		return "(Emp_ID: " + id + ", First_Name: " + FName + ", Last_Name: " + LName + ")";
	}
	
	@Override
	public int compareTo(Employee e) {
		if(e.id < id) return -1;
		else if(e.id == id) return 0;
		return 1;
	}

}
