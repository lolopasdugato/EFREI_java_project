package cl_People;

import java.util.Date;

import cl_Services.Department;

public class Director extends Employee {

	private Department _belongsTo;
	
	public Director(int _socialId, String _firstname, String _lastname,
			String _phoneNumber, String _address, Date _birthDay,
			Date _recrutingDay, Employee_container _container,
			Department _belongsTo) {
		super(_socialId, _firstname, _lastname, _phoneNumber, _address,
				_birthDay, _recrutingDay, _container);
		this._belongsTo = _belongsTo;
	}

	public Department get_belongsTo() {
		return _belongsTo;
	}

	public void set_belongsTo(Department _belongsTo) {
		this._belongsTo = _belongsTo;
	}

	@Override
	public String toString() {
		return "Director [_belongsTo=" + _belongsTo + "]";
	}
	public void whoIAm(){
		System.out.println("I am " + get_firstname() + " " + get_lastname());
		System.out.println("My social ID is: " + get_socialId());
		System.out.println("My phone number is: " + get_phoneNumber());
		System.out.println("You can join me by using this address: " + get_address());
		System.out.println("My birthdate is: " + get_birthDay());
		System.out.println("I have been recruted the following day: " + get_recrutingDay() + "\n");
		System.out.println("Name of his departement: " + get_belongsTo().get_name());
		return;
	}
}
