package cl_Services;
import java.util.ArrayList;

import cl_Room.Office;

public class Department_container {

	private ArrayList<Department> _array;
		
	public Department_container() {
		super();
		try{
			this._array = new ArrayList<Department>();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public ArrayList<Department> get_array() {
		return _array;
	}

	public void set_array(ArrayList<Department> _array) {
		this._array = _array;
	}

	@Override
	public String toString() {
		return "Department_container [_array=" + _array + "]";
	}
	
	public void show ()
	{
		if (this._array.size() != 0){
			for (int cpt = 0; cpt < this._array.size(); cpt++){
				System.out.print("Department :" );
				this._array.get(cpt).show();
			}
		}
		else
			System.out.println("No Department");
	}
	
}