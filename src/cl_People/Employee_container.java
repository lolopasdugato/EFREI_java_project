package cl_People;

import java.util.ArrayList;

public class Employee_container {
	
	private ArrayList<Employee> _array;
	public ArrayList<Employee> get_array() {
		return _array;
	}
	public void set_array(ArrayList<Employee> _array) {
		this._array = _array;
	}
	public Employee_container() {
		super();
		try{
			this._array = new ArrayList<Employee>();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void show ()
	{
		if (this._array.size() != 0){
			System.out.println("Employee(s): ");
			for (int cpt = 0; cpt < this._array.size(); cpt++){
				System.out.print(cpt + ": " + this._array.get(cpt).get_firstname() + " " + this._array.get(cpt).get_lastname() + "\n");
			}
		}
		else
			System.out.println("No employee in this group.");
		System.out.println("\n\n");
	}

}
