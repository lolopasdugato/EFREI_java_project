package cl_Services;
import cl_People.*;

public class Department {
	
	protected int _id;
	protected String _name;
	protected int _budget;
	protected Director _dir;
	protected Employee_container _workgroup;
	protected static int _nbOfInstance;
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public int get_budget() {
		return _budget;
	}
	public void set_budget(int _budget) {
		this._budget = _budget;
	}
	public Director get_dir() {
		return _dir;
	}
	public void set_dir(Director _dir) {
		this._dir = _dir;
	}
	public Employee_container get_workgroup() {
		return _workgroup;
	}
	public void set_workgroup(Employee_container _workgroup) {
		this._workgroup = _workgroup;
	}
	public static int get_nbOfInstance() {
		return _nbOfInstance;
	}
	public static void set_nbOfInstance(int _nbOfInstance) {
		Department._nbOfInstance = _nbOfInstance;
	}
	public Department(String _name, int _budget, Director _dir,
			Employee_container _workgroup, Department_container _array) {
		super();
		this._name = _name;
		this._budget = _budget;
		this._dir = _dir;
		this._workgroup = _workgroup;
		_nbOfInstance++;
		this._id = _nbOfInstance;
		_array.get_array().add(this);
	}
	@Override
	public String toString() {
		return "Department [_id=" + _id + ", _name=" + _name + ", _budget="
				+ _budget + ", _dir=" + _dir + ", _workgroup=" + _workgroup
				+ "]";
	}
	public void show ()
	{
		System.out.print("ID: " + _id);
		System.out.print("Name of the departement:  " + _name);
		System.out.print("Budget: " + _budget);
		System.out.print("Director: ");
		_dir.whoIAm();
	}

	

}
