package cl_People;

import java.util.Date;

import cl_Services.*;
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
	
	public static Employee whoAreYou(Department_container default_Department_Group){
		Employee e;
		do{
			System.out.println("Who are you ? Please enter the id that refers to your name.");
			e = HumanRessources.selectEmployee(default_Department_Group);
		}while(e == null);
		return e;
	}
	
	public static int menu(){
		Scanner sc = new Scanner(System.in);
		int resp;
		do{
			System.out.println("What do you want to do now ?\n");
			System.out.println("1) Show all rooms.");
			System.out.println("2) Show my Cv.");
			System.out.println("3) Modify my Cv.");
			System.out.println("4) Block a new room.");
			System.out.println("5) Unblock your room.");
			System.out.println("6) Quit.");
			resp = sc.nextInt();
		}while(resp < 1 || resp > 6);
		return resp;
	}
}
