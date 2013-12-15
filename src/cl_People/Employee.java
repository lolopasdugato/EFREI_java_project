package cl_People;

import java.util.Date;

public class Employee {
	private int _socialId;
	private String _firstname;
	private String _lastname;
	private String _phoneNumber;
	private String _address;
	private Date _birthDay;
	private Date _recrutingDay;
	private Employee_container _container;
	//private Cv _myCv;
	public int get_socialId() {
		return _socialId;
	}
	public void set_socialId(int _socialId) {
		this._socialId = _socialId;
	}
	public String get_firstname() {
		return _firstname;
	}
	public void set_firstname(String _firstname) {
		this._firstname = _firstname;
	}
	public String get_lastname() {
		return _lastname;
	}
	public void set_lastname(String _lastname) {
		this._lastname = _lastname;
	}
	public String get_phoneNumber() {
		return _phoneNumber;
	}
	public void set_phoneNumber(String _phoneNumber) {
		this._phoneNumber = _phoneNumber;
	}
	public String get_address() {
		return _address;
	}
	public void set_address(String _address) {
		this._address = _address;
	}
	public Date get_birthDay() {
		return _birthDay;
	}
	public void set_birthDay(Date _birthDay) {
		this._birthDay = _birthDay;
	}
	public Date get_recrutingDay() {
		return _recrutingDay;
	}
	public void set_recrutingDay(Date _recrutingDay) {
		this._recrutingDay = _recrutingDay;
	}
	public Employee_container get_container() {
		return _container;
	}
	public void set_container(Employee_container _container) {
		this._container = _container;
	}
	public Employee(int _socialId, String _firstname, String _lastname,
			String _phoneNumber, String _address, Date _birthDay,
			Date _recrutingDay, Employee_container _container) {
		super();
		this._socialId = _socialId;
		this._firstname = _firstname;
		this._lastname = _lastname;
		this._phoneNumber = _phoneNumber;
		this._address = _address;
		this._birthDay = _birthDay;
		this._recrutingDay = _recrutingDay;
		_container.get_array().add(this);
	}
	@Override
	public String toString() {
		return "Employee [_socialId=" + _socialId + ", _firstname="
				+ _firstname + ", _lastname=" + _lastname + ", _phoneNumber="
				+ _phoneNumber + ", _address=" + _address + ", _birthDay="
				+ _birthDay + ", _recrutingDay=" + _recrutingDay
				+ "]";
	}
}
