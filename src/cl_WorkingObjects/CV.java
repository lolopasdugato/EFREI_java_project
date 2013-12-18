package cl_WorkingObjects;

import java.util.ArrayList;

public class CV {


	private ArrayList<String> _jobs;
	private ArrayList<String> _schooling;
	public CV(ArrayList<String> _jobs, ArrayList<String> _schooling, Cv_container _container) {
		super();
		this._jobs = _jobs;
		this._schooling = _schooling;
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
