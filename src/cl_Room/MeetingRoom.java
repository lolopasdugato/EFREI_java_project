package cl_Room;

import cl_People.*;

public class MeetingRoom extends Office {
	private Employee _manager;
	private Boolean _projector;

	public Boolean get_projector() {
		return _projector;
	}
	public void set_projector(Boolean _projector) {
		this._projector = _projector;
	}
	public Employee get_manager() {
		return _manager;
	}
	public void set_manager(Employee _manager) {
		this._manager = _manager;
	}
	public MeetingRoom(int _code, int _size, Office_container _container, Boolean _projector) {
		super(_code, _size, _container);
		this._projector = _projector;
	}
	
	// Allow to block the Office for a particular employee. Check if it's not already blocked by someone else.
	public Boolean block(Employee e){
		if(_reserved != false){
			System.out.println("Sorry but this meetin room is already blocked by " +  _manager.get_firstname() + " " + _manager.get_lastname() + " !");
			return false;
		}
		else{
			_manager = e;
			_reserved = true;
			return true;
		}
	}
		
	// Allow to unblock the office. Check if the office isn't already free.
	public Boolean unBlock(){
		if(!this._reserved){
			System.out.println("This Meeting Room is already free.");
			return false;
		}
		else{
			this._reserved = false;
			return true;
		}
	}
	public void showDetails ()
	{
		System.out.print("Room ID: " + _id);
		System.out.print("Code Number: " + _code);
		System.out.print("Size: " + _size);
		System.out.print("Reserved: " + _reserved);
		System.out.print("Manager Details: ");
		_manager.whoIAm();
		System.out.print("Projector: " + _projector);
	}
}
