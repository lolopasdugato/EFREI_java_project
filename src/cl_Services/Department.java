package cl_Services;
import cl_People.*;

public abstract class Department {
	
	protected int _id;
	protected String _name;
	protected int _budget;
	protected Director _dir;
	protected Employee_container _workgroup;
	
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
	public Department(int _id, String _name, int _budget, Director _dir,
			Employee_container _workgroup) {
		super();
		this._id = _id;
		this._name = _name;
		this._budget = _budget;
		this._dir = _dir;
		this._workgroup = _workgroup;
	}
	@Override
	public String toString() {
		return "Department [_id=" + _id + ", _name=" + _name + ", _budget="
				+ _budget + ", _dir=" + _dir + ", _workgroup=" + _workgroup
				+ "]";
	}

	

}
