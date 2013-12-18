package cl_Services;
import java.util.ArrayList;

public class Department_container {

	private ArrayList<Department> _array;
		
	public Department_container(ArrayList<Department> _array) {
		super();
		this._array = _array;
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

	
}