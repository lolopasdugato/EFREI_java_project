package cl_Room;

import cl_Room.Office;

public class OpenSpace extends Office {
	// Missing the attribute that represents the employees
	private int _capacity;
	
	public OpenSpace(int _code, int _size, Boolean _reserved, int _capacity) {
		super(_code, _size, _reserved);
		this._capacity = _capacity;
	}

	public int get_capacity() {
		return _capacity;
	}

	public void set_capacity(int _capacity) {
		this._capacity = _capacity;
	}
	
}
