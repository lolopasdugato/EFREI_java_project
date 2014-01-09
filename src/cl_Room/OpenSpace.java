package cl_Room;

import cl_People.*;

public class OpenSpace extends Office {
	private Employee_container _roomMembers;
	private int _capacity;
	
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
	public boolean block(Employee e){
		if(this._reserved){
			System.out.println("This OpenSpace is already blocked by another group, trying to add the new member.");
			return add(e);
		}
		else{
			this._reserved = true;
			this._roomMembers.get_array().add(e);
			System.out.println("Open space blocked for: ");
			e.whoIAm();
			return true;
		}
	}
	
	// Allow to remove the whole group of workers in this OpenSpace
	public boolean unBlock(){
		if(!this._reserved){
			System.out.println("Cannot remove the Employee group in this open space, no group found");
			return false;
		}
		else{
			this._reserved = false;
			System.out.println("Open space unlocked.");
			return true;
		}
	}
	
	// Allow to add an employee to an OpenSpace, and check if this OpenSpace isn't full before adding.
	public boolean add(Employee e){
		if(_roomMembers.get_array().size() >= _capacity){
			System.out.println("Error, the OpenSpace is full ! (capacity: " + _capacity + ")\n");
			return false;
		}
		else{
			if(!this._reserved)
				this._roomMembers = new Employee_container();
			this._roomMembers.get_array().add(e);
			this._reserved = true;
			System.out.println("Member added.\n");
			return true;
		}
	}
	
	public void showDetails ()
	{
		System.out.println("Room type: Open Space.");
		System.out.println("Room ID: " + _id);
		System.out.println("Code Number: " + _code);
		System.out.println("Size: " + _size + "square meters.");
		System.out.println("Capacity: " + _capacity+ " persons.");
		if(_reserved){
			System.out.println("Reserved: yes");
			System.out.println("Current employee(s): ");
			_roomMembers.show();
		}
		else{
			if(_roomMembers == null || _roomMembers.get_array().size() == 0){
				System.out.println("No Room members.");
			}
			else{
				System.out.println("Last room members: ");
				_roomMembers.show();
			}
		}
		System.out.println("\n");
	}
}
