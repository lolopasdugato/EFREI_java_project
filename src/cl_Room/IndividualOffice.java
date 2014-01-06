package cl_Room;

import cl_People.Employee;

public class IndividualOffice extends Office{
	private Employee _worker;
	public Employee get_worker() {
		return _worker;
	}
	public void set_worker(Employee _worker) {
		this._worker = _worker;
	}
	public IndividualOffice(int _code, int _size, Office_container _container) {
		super(_code, _size, _container);
	}
	@Override
	public String toString() {
		return "IndividualOffice [_worker=" + _worker + "]";
	}
	public void showDetails ()
	{
		System.out.print("Room ID: " + _id);
		System.out.print("Code Number: " + _code);
		System.out.print("Size: " + _size);
		System.out.print("Reserved: " + _reserved);
		if (this._reserved == true)
		{
			System.out.print("Actual Worker:");
			_worker.whoIAm();
		}
		else
		{
			System.out.print("Formal Employee: ");
			 _worker.whoIAm(); 
		}
	}
	
	// Allow to block the Office for a particular employee. Check if it's not already blocked by someone else.
	public Boolean block(Employee e){
		if(this._reserved){
			System.out.println("Sorry but this Individual Office is already blocked by " +  this._worker.get_firstname() + " " + this._worker.get_lastname() + " !");
			return false;
		}
		else{
			this._worker = e;
			this._reserved = true;
			return true;
		}
	}
	
	// Allow to unblock the office. Check if the office isn't already free.
	public Boolean unBlock(){
		if(!this._reserved){
			System.out.println("This Office is already free.");
			return false;
		}
		else{
			this._reserved = false;
			return true;
		}
	}
	
}
