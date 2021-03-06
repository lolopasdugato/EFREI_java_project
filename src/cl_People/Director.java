package cl_People;

import java.util.Date;

import cl_Services.Department;

public class Director extends Employee {

	private Department _belongsTo;
	
	public Director(String _socialId, String _firstname, String _lastname,
			String _phoneNumber, String _address, int _age,
			Date _recrutingDay, Employee_container _container,
			Department _belongsTo) {
		super(_socialId, _firstname, _lastname, _phoneNumber, _address,
				_age, _recrutingDay, _container);
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
		System.out.println(get_firstname() + " " + get_lastname());
		System.out.println("Social ID is: " + get_socialId());
		System.out.println("Phone number is: " + get_phoneNumber());
		System.out.println("You can join him by using this address: " + get_address());
		System.out.println("age: " + get_age());
		System.out.println("Recruted the following day: " + get_recrutingDay());
		System.out.println("Director of departement: " + get_belongsTo().get_name() + "\n\n");
		return;
	}
}
