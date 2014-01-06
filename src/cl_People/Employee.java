package cl_People;

import java.util.Date;

import cl_WorkingObjects.CV;

import java.util.Scanner;

public class Employee {
	private int _socialId;
	private String _firstname;
	private String _lastname;
	private String _phoneNumber;
	private String _address;
	private Date _birthDay;
	private Date _recrutingDay;
	private CV _curiculum;
	private Employee_container _container;

	
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
	public CV get_curiculum() {
		return _curiculum;
	}
	public void set_curiculum(CV _curiculum) {
		this._curiculum = _curiculum;
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
		this._curiculum = new CV(this);
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
	
	public void whoIAm(){
		System.out.println("I am " + _firstname + " " + _lastname);
		System.out.println("My social ID is: " + _socialId);
		System.out.println("My phone number is: " + _phoneNumber);
		System.out.println("You can join me by using this address: " + _address);
		System.out.println("My birthdate is: " + _birthDay);
		System.out.println("I have been recruted the following day: " + _recrutingDay + "\n");
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
}
