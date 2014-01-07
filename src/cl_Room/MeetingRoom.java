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
			System.out.println("Meeting room blocked for: ");
			_manager.whoIAm();
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
			System.out.println("Meeting Room unlocked.");
			return true;
		}
	}
	public void showDetails ()
	{
		System.out.println("Room type: Meeting Room.");
		System.out.println("Room ID: " + _id);
		System.out.println("Code Number: " + _code);
		System.out.println("Size: " + _size);
		System.out.println("Reserved: " + _reserved);
		System.out.println("Manager Details: ");
		
		if(_reserved){
			System.out.println("Current manager: ");
			_manager.whoIAm();
		}
		else{
			System.out.println("Last manager: ");
			if(_manager == null)
				System.out.println("No manager.");
			else
				_manager.whoIAm();
		}
		if(_projector)
			System.out.println("Projector: yes.");
		else
			System.out.println("Projector: no.");
	}
}
