package cl_People;

import java.util.Date;
import java.util.Scanner;

import cl_Room.*;
import cl_Services.*;

public class HumanRessources extends Employee {

	public HumanRessources(Employee e){
		super(e.get_socialId(), e.get_firstname(), e.get_lastname(), e.get_phoneNumber(), e.get_address(),
				e.get_age(), e.get_recrutingDay(), e.get_container());
		e.get_container().get_array().remove(e);
		e = null;
	}
	
	public HumanRessources(String _socialId, String _firstname, String _lastname,
			String _phoneNumber, String _address, int _age,
			Date _recrutingDay, Employee_container _container) {
		super(_socialId, _firstname, _lastname, _phoneNumber, _address,
				_age, _recrutingDay, _container);
		// TODO Auto-generated constructor stub
	}
	
	public static Employee selectEmployee(Department_container d){
		int response = -1;
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < d.get_array().size(); i++){
			do{
				System.out.println("Department: " + d.get_array().get(i).get_name());
				d.get_array().get(i).get_workgroup().show();
				System.out.println((d.get_array().get(i).get_workgroup().get_array().size()) + ") Not one of them.");
				response = scan.nextInt();
			}while(response > d.get_array().get(i).get_workgroup().get_array().size() || response < 0);
			
			if(response == d.get_array().get(i).get_workgroup().get_array().size())
				response = -1;
			else{
				return d.get_array().get(i).get_workgroup().get_array().get(response);
			}
		}
		return null;
	}
	
	public void showDetailsOnEmployees(Department_container d){
		for(int i = 0; i < d.get_array().size(); i++){
			System.out.println("Departement: " + d.get_array().get(i).get_name());
			for(int j = 0; j < d.get_array().get(i).get_workgroup().get_array().size(); j++){
				d.get_array().get(i).get_workgroup().get_array().get(j).whoIAm();
			}
		}
		return;
	}
	
	public void showDepartment(Department_container d){
		d.show();
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
	
	public void promoteToDirector(Department_container d){
		int response;
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < d.get_array().size(); i++){
			response = -1;
			System.out.println("Departement: " + d.get_array().get(i).get_name());
			d.get_array().get(i).get_workgroup().show();
			System.out.println(d.get_array().get(i).get_workgroup().get_array().size() + ") None of them");
			System.out.println("Please enter the number of the employee you want to promote to the director's position.");
			do{
				response = scan.nextInt();
			}while(response < 0 || response > d.get_array().get(i).get_workgroup().get_array().size());
			if(response != d.get_array().get(i).get_workgroup().get_array().size()){
				HumanRessources.promote(d.get_array().get(i).get_workgroup().get_array().get(response), d.get_array().get(i));
				return;
			}
		}
		return;
	}
	
	public void showACv(Department_container d){
		int response;
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < d.get_array().size(); i++){
			response = -1;
			System.out.println("Departement: " + d.get_array().get(i).get_name());
			d.get_array().get(i).get_workgroup().show();
			System.out.println(d.get_array().get(i).get_workgroup().get_array().size() + ") None of them");
			System.out.println("Please enter the number of the employee you want to see the CV.");
			do{
				response = scan.nextInt();
			}while(response < 0 || response > d.get_array().get(i).get_workgroup().get_array().size());
			if(response != d.get_array().get(i).get_workgroup().get_array().size()){
				d.get_array().get(i).get_workgroup().get_array().get(response).showCV();
				return;
			}
		}
		return;
	}
	
	public void blockARoom(Office_container o, Department_container d){
		Scanner scan = new Scanner(System.in);
		int response;
		o.show();
		System.out.println("Please, enter the number of the office (Be sure to type it's number, not it's ID or it's code).");
		do{
			response = scan.nextInt();
		}while(response < 0 || response >= o.get_array().size());
		int office = response;
		
		for(int i = 0; i < d.get_array().size(); i++){
			response = -1;
			System.out.println("Departement: " + d.get_array().get(i).get_name());
			d.get_array().get(i).get_workgroup().show();
			System.out.println(d.get_array().get(i).get_workgroup().get_array().size() + ") None of them");
			System.out.println("Please enter the number of the employee you want to use the office.");
			do{
				response = scan.nextInt();
			}while(response < 0 || response > d.get_array().get(i).get_workgroup().get_array().size());
			if(response != d.get_array().get(i).get_workgroup().get_array().size()){
				o.get_array().get(office).block(d.get_array().get(i).get_workgroup().get_array().get(response));
				return;
			}
		}
		return;
	}
	
	public void unBlockARoom(Office_container o){
		o.show();
		int response;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please, enter the number of the office (Be sure to type it's number, not it's ID or it's code).");
		do{
			response = scan.nextInt();
		}while(response < 0 || response >= o.get_array().size());
		o.get_array().get(response).unBlock();
	}
	
	public void addToAnOpenSpace(Office_container o, Department_container d){
		Employee e;
		int response = -1;
		String answer = "n";
		int cpt = 0;
		Office_container os = new Office_container();
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("Enter the number of the employee you want who will block the office.");
			e = selectEmployee(d);
		}while (e == null);
		for(int i = 0; i < o.get_array().size(); i++){
			if(o.get_array().get(i) instanceof OpenSpace)
				os.get_array().add(o.get_array().get(i));
		}
		os.show();
		System.out.println("Do you want to continue ? (y/n)");
		do{
			answer = scan.nextLine();
		}while(!answer.equals("y"));
		System.out.println("Please, enter the number of the office (Be sure to type it's number, not it's ID or it's code).");
		do{
			response = scan.nextInt();
		}while(response > os.get_array().size() || response < 0);
		os.get_array().get(response).block(e);
		return;
	}
	
	public void addEmployee(Department_container d){
		Scanner scan = new Scanner(System.in);
		int response = -1;
		
		System.out.println("You are going to add a new employee. Please select, first select his department: ");
		d.show();
		System.out.println("Please enter the number of the selected department: ");
		do{
			response = scan.nextInt();
		}while(response < 0 || response >= d.get_array().size());
		Department d_choosen = d.get_array().get(response);
		scan.nextLine();
		System.out.println("Enter the Employee's social id: ");
		String _socialId = scan.nextLine();
		System.out.println("Enter the Employee's first name: ");
		String _firstname = scan.nextLine();
		System.out.println("Enter the Employee's last name: ");
		String _lastname = scan.nextLine();
		System.out.println("Enter the Employee's phone number: ");
		String _phoneNumber = scan.nextLine();
		System.out.println("Enter the Employee's e-mail address: ");
		String _address = scan.nextLine();
		System.out.println("Enter the Employee's age: ");
		int _age = scan.nextInt();
		 
		Employee p = new Employee(_socialId, _firstname, _lastname, _phoneNumber, _address, _age, new Date(), d.get_array().get(response).get_workgroup());
		if(d_choosen.get_id() == d.get_array().get(0).get_id()){
			new HumanRessources(p);
		}
		return;
	}
	
	public void fireEmployee(Department_container d){
		Scanner scan = new Scanner(System.in);
		String answer = "n";
		Employee e = selectEmployee(d);
		System.out.println("This will erase him from his department. You may only see him in that database through 'Rooms details' unless you've delted him. ");
		e.whoIAm();
		System.out.println("Are you really sure you want to fire this employee from this firm ? (y/n)");
		do{
			answer = scan.nextLine();
		}while(!(answer.equals("y") || answer.equals("n")));
			if(answer.equals("y"))
				e.get_container().get_array().remove(e);
		return;
	}
	
	public static int menu(){
		Scanner sc = new Scanner(System.in);
		int resp;
		do{
			System.out.println("What do you want to do now ?\n");
			System.out.println("1) Show all rooms.");
			System.out.println("2) Show all employees.");
			System.out.println("3) Show Departments.");
			System.out.println("4) Promote an employee.");
			System.out.println("5) Show the CV of an employee.");
			System.out.println("6) Block a new room.");
			System.out.println("7) Unblock a room.");
			System.out.println("8) Add an employee to an open space.");
			System.out.println("9) Recruit an employee.");
			System.out.println("10) Fire an employee.");
			System.out.println("11) Quit.");
			resp = sc.nextInt();
		}while(resp < 1 || resp > 11);
		return resp;
	}
}
