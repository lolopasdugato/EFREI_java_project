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

}
