package cl_WorkingObjects;

import java.util.ArrayList;

public class Cv_container {

	private ArrayList<CV> _array;

	public Cv_container(ArrayList<CV> _array) {
		super();
		this._array = _array;
	}

	public ArrayList<CV> get_array() {
		return _array;
	}

	public void set_array(ArrayList<CV> _array) {
		this._array = _array;
	}

	@Override
	public String toString() {
		return "Cv_container [_array=" + _array + "]";
	}

}