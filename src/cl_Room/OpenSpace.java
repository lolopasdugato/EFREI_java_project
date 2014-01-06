package cl_Room;

import cl_People.*;

public class OpenSpace extends Office {
	private Employee_container _roomMembers;
	private int _capacity;
	
	public void showDetails ()
	{
		System.out.print("Room ID: " + _id);
		System.out.print("Code Number: " + _code);
		System.out.print("Size: " + _size);
		System.out.print("Reserved: " + _reserved);
		System.out.print("Capacity: " + _capacity);
	}
	
	public OpenSpace(int _code, int _size, Office_container _container, int _capacity) {
		super(_code, _size, _container);
		this._capacity = _capacity;
		this._roomMembers = new Employee_container();
	}
	public int get_capacity() {
		return _capacity;
	}
	public void set_capacity(int _capacity) {
		this._capacity = _capacity;
	}
	public Employee_container get_roomMembers() {
		return _roomMembers;
	}
	public void set_roomMembers(Employee_container _roomMembers) {
		this._roomMembers = null;
		this._roomMembers = _roomMembers;
	}
	
	// Allow to block an OpenSpace for a special group of Employees.
	public Boolean block(Employee_container e){
		if(this._reserved){
			System.out.println("Sorry, this OpenSpace is already blocked by another group");
			return false;
		}
		else{
			this._reserved = true;
			this._roomMembers = e;
			return true;
		}
	}
	
	// Allow to remove the whole group of workers in this OpenSpace
	public Boolean unBlock(){
		if(!this._reserved){
			System.out.println("Cannot remove the Employee group, no group found");
			return false;
		}
		else{
			this._reserved = false;
			return true;
		}
	}
	
	// Allow to add an employee to an OpenSpace, and check if this OpenSpace isn't full before adding.
	public Boolean add(Employee e){
		if(_roomMembers.get_array().size() >= _capacity){
			System.out.println("Error, the OpenSpace is full ! (capacity: " + _capacity + ")");
			return false;
		}
		else{
			if(!this._reserved)
				this._roomMembers = new Employee_container();
			this._roomMembers.get_array().add(e);
			this._reserved = true;
			return true;
		}
	}
}
