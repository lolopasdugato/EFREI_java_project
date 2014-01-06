package cl_WorkingObjects;

import java.util.ArrayList;
import cl_People.Employee;

public class CV {


	private ArrayList<String> _jobs;
	private ArrayList<String> _schooling;
	public CV(Cv_container _container, Employee _employee) {
		super();
		_employee.set_curiculum(this);
		_container.get_array().add(this);
	}
	public ArrayList<String> get_jobs() {
		return _jobs;
	}
	public void set_jobs(ArrayList<String> _jobs) {
		this._jobs = _jobs;
	}
	public ArrayList<String> get_schooling() {
		return _schooling;
	}
	public void set_schooling(ArrayList<String> _schooling) {
		this._schooling = _schooling;
	}
	

}
