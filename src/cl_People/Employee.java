package cl_People;

import java.util.Date;

import cl_Services.Department;
import cl_WorkingObjects.CV;
import cl_People.Director;

import java.util.Scanner;

public class Employee {
	private String _socialId;
	private String _firstname;
	private String _lastname;
	private String _phoneNumber;
	private String _address;
	private int _age;
	private Date _recrutingDay;
	private CV _curiculum;
	private Employee_container _container;

	
	public String get_socialId() {
		return _socialId;
	}
	public void set_socialId(String _socialId) {
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
	public int get_age() {
		return _age;
	}
	public void set_age(int _age) {
		this._age = _age;
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
	public CV get_curiculum() {
		return _curiculum;
	}
	public void set_curiculum(CV _curiculum) {
		this._curiculum = _curiculum;
	}
	public Employee(String _socialId, String _firstname, String _lastname,
			String _phoneNumber, String _address, int _age,
			Date _recrutingDay, Employee_container _container) {
		super();
		this._socialId = _socialId;
		this._firstname = _firstname;
		this._lastname = _lastname;
		this._phoneNumber = _phoneNumber;
		this._address = _address;
		this._age = _age;
		this._recrutingDay = _recrutingDay;
		this._curiculum = new CV(this);
		this._container = _container;
		_container.get_array().add(this);
		
	}
	@Override
	public String toString() {
		return "Employee [_socialId=" + _socialId + ", _firstname="
				+ _firstname + ", _lastname=" + _lastname + ", _phoneNumber="
				+ _phoneNumber + ", _address=" + _address + ", _age="
				+ _age + ", _recrutingDay=" + _recrutingDay
				+ "]";
	}
	
	public void whoIAm(){
		System.out.println(_firstname + " " + _lastname);
		System.out.println("Social ID is: " + _socialId);
		System.out.println("Phone number is: " + _phoneNumber);
		System.out.println("You can join him by using this address: " + _address);
		System.out.println("age: " + _age);
		System.out.println("Recruted the following day: " + _recrutingDay + "\n");
		return;
	}
	
	public void showCV(){
		_curiculum.show();
		return;
	}
	
	public void fillCV(){
		_curiculum.fill();
		return;
	}
	
	public static int whoAreYou(){
		Scanner sc = new Scanner(System.in);
		int in;
		do{
			System.out.println("Please select your Department: ");
			System.out.println("1) Employee.");
			System.out.println("2) Human Ressources.");
			in = sc.nextInt();
		}while(in < 1 && in > 2);
		return in;
	}
	
	public static Director promote(Employee temp, Department _belongsTo){
		if(_belongsTo.get_dir() != null){
			System.out.println("Cannot promote the employee in this department. There is already a director.");
			return null;
		}
		else{
			temp.get_container().get_array().remove(temp);
			Director dirlo = new Director(temp.get_socialId(), temp.get_firstname(), temp.get_lastname(), temp.get_phoneNumber(), temp.get_address(), temp.get_age(), temp.get_recrutingDay(), temp.get_container(), _belongsTo);
			dirlo.set_curiculum(temp.get_curiculum());
			_belongsTo.set_dir(dirlo);
			return dirlo;
		}
	}
}
