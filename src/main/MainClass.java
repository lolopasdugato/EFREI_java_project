package main;

import cl_Room.*;
import cl_Services.*;
import cl_People.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class MainClass {
	
	public static Office_container initDefaultBuilding(){
		Office_container default_Building = new Office_container();
		
		new IndividualOffice(2459, 15, default_Building);
		new IndividualOffice(4567, 15, default_Building);
		new IndividualOffice(9875, 11, default_Building);
		new IndividualOffice(3654, 15, default_Building);
		new IndividualOffice(9885, 15, default_Building);
		new IndividualOffice(8954, 12, default_Building);
		new OpenSpace(9875, 200, default_Building, 10);
		new OpenSpace(8998, 200, default_Building, 11);
		new MeetingRoom(0365, 30, default_Building, true);

		return default_Building;
	}
	
	public static Employee_container initDefaultEmployeeGroup(){
		Employee_container work_Group = new Employee_container();
		
		new Employee("025589036021365", "Jack", "Madon", "0658962136", "jack@madon.com", 42, new Date(), work_Group);
		new Employee("165890366582969", "Merrick", "Persid", "0665875469", "mer@gmail.com", 51, new Date(), work_Group);
		new Employee("645122151652312", "Mirranda", "Daniels", "0656752401", "mimi@hotmail.com", 24, new Date(), work_Group);
		new Employee("654654156546570", "Frederic", "Koney", "0698774210", "fefe@koney.com", 29, new Date(), work_Group);
		return work_Group;
	}
	
	public static Department_container initDefaultDepContainer(Employee_container e){
		Department_container default_Department_Group = new Department_container();
		new Department("Human Ressources", 15000, e, default_Department_Group);
		return default_Department_Group;
	}
	
	public static int menuEmployee(){
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
	
	public static int menuRh(){
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
			System.out.println("9) Quit.");
			resp = sc.nextInt();
		}while(resp < 1 || resp > 9);
		return resp;
	}

	public static void main(String[] args) {		
		Office_container default_Building = MainClass.initDefaultBuilding();
		Employee_container default_Work_Group1 = MainClass.initDefaultEmployeeGroup();
		Department_container default_Department_Group = MainClass.initDefaultDepContainer(default_Work_Group1);
		int menu_Resp = 0;
		int response = -1;
		
		switch(Employee.whoAreYou()){
		case 1:
			Office o = null;
			Employee e = null;
			Scanner scan = new Scanner(System.in);
			System.out.println("Hello ! Welcome to our brand new program (beta)!\n\nYou are logged in as a simple Employee\n\n");
			do{
				System.out.println("Who are you ? Please enter the id that refers to your name.");
				for(int i = 0; i < default_Department_Group.get_array().size(); i++){
					do{
						for(int j = 0; j < default_Department_Group.get_array().get(i).get_workgroup().get_array().size(); j++){
							default_Department_Group.get_array().get(i).get_workgroup().show();
						}
						System.out.println((default_Department_Group.get_array().get(i).get_workgroup().get_array().size()) + ") Not one of them.");
						response = scan.nextInt();
					}while(response > default_Department_Group.get_array().get(i).get_workgroup().get_array().size() || response < 0);
					
					if(response == default_Department_Group.get_array().get(i).get_workgroup().get_array().size())
						response = -1;
					else{
						e = default_Department_Group.get_array().get(i).get_workgroup().get_array().get(response);
						i = default_Department_Group.get_array().size();
					}
				}
			}while(e == null);
			
			do{
				String answer;
				Scanner scan2 = new Scanner(System.in);
				menu_Resp = menuEmployee();
				switch(menu_Resp){
				case 1:
					default_Building.show();
					System.out.println("Do you want to see more details on a specific room ? (y/n)");
					do{
						answer = scan2.nextLine();
					}while(!(answer.equals("y") || answer.equals("n")));
					if(answer.equals("y")){
						System.out.println("Please, enter the number of the office (Be sure to type it's number, not it's ID or it's code).");
						do{
							response = scan2.nextInt();
						}while(response < 0 || response >= default_Building.get_array().size());
						default_Building.get_array().get(response).showDetails();
					}
						
					break;
				case 2:
					e.showCV();
					break;
				case 3:
					e.fillCV();
					break;
				case 4:
					default_Building.show();
					System.out.println("Please, enter the number of the office (Be sure to type it's number, not it's ID or it's code).");
					do{
						response = scan2.nextInt();
					}while(response < 0 || response >= default_Building.get_array().size());
					if(o == null){
						if(default_Building.get_array().get(response).block(e))
							o = default_Building.get_array().get(response);
					}
					else
						System.out.println("You cannot reserve more than one room.");
					break;
				case 5:
					o.unBlock();
					break;
				case 6:
					System.out.println("Have a good day !");
					break;
				default:
					System.out.println("Unknown error, exiting.");
					return;
				}
				
			}while(menu_Resp != 6);
			break;
		case 2:
			System.out.println("Hello ! Welcome to our brand new program (beta)!\n\nYou are logged in as a member of the human ressources department.\n\n");
			do{
				String answer;
				response = -1;
				Scanner scan2 = new Scanner(System.in);
				menu_Resp = menuRh();
				switch(menu_Resp){
				case 1:
					default_Building.show();
					System.out.println("Do you want to see more details on a specific room ? (y/n)");
					do{
						answer = scan2.nextLine();
					}while(!(answer.equals("y") || answer.equals("n")));
					if(answer.equals("y")){
						System.out.println("Please, enter the number of the office (Be sure to type it's number, not it's ID or it's code).");
						do{
							response = scan2.nextInt();
						}while(response < 0 || response >= default_Building.get_array().size());
						default_Building.get_array().get(response).showDetails();
					}
					break;
				case 2:
					for(int i = 0; i < default_Department_Group.get_array().size(); i++){
						System.out.println("Departement: " + default_Department_Group.get_array().get(i).get_name());
						for(int j = 0; j < default_Department_Group.get_array().get(i).get_workgroup().get_array().size(); j++){
							default_Department_Group.get_array().get(i).get_workgroup().get_array().get(j).whoIAm();
						}
					}
					break;
				case 3:
					default_Department_Group.show();
					break;
				case 4:
					for(int i = 0; i < default_Department_Group.get_array().size(); i++){
						response = -1;
						System.out.println("Departement: " + default_Department_Group.get_array().get(i).get_name());
						default_Department_Group.get_array().get(i).get_workgroup().show();
						System.out.println(default_Department_Group.get_array().get(i).get_workgroup().get_array().size() + ") None of them");
						System.out.println("Please enter the number of the employee you want to promote to the director's position.");
						do{
							response = scan2.nextInt();
						}while(response < 0 || response > default_Department_Group.get_array().get(i).get_workgroup().get_array().size());
						if(response != default_Department_Group.get_array().get(i).get_workgroup().get_array().size()){
							Employee.promote(default_Department_Group.get_array().get(i).get_workgroup().get_array().get(response), default_Department_Group.get_array().get(i));
							i = default_Department_Group.get_array().size();
						}
					}
					break;
				case 5:
					for(int i = 0; i < default_Department_Group.get_array().size(); i++){
						response = -1;
						System.out.println("Departement: " + default_Department_Group.get_array().get(i).get_name());
						default_Department_Group.get_array().get(i).get_workgroup().show();
						System.out.println(default_Department_Group.get_array().get(i).get_workgroup().get_array().size() + ") None of them");
						System.out.println("Please enter the number of the employee you want to see the CV.");
						do{
							response = scan2.nextInt();
						}while(response < 0 || response > default_Department_Group.get_array().get(i).get_workgroup().get_array().size());
						if(response != default_Department_Group.get_array().get(i).get_workgroup().get_array().size()){
							default_Department_Group.get_array().get(i).get_workgroup().get_array().get(response).showCV();
							i = default_Department_Group.get_array().size();
						}
					}
					break;
				case 6:
					default_Building.show();
					System.out.println("Please, enter the number of the office (Be sure to type it's number, not it's ID or it's code).");
					do{
						response = scan2.nextInt();
					}while(response < 0 || response >= default_Building.get_array().size());
					int office = response;
					
					for(int i = 0; i < default_Department_Group.get_array().size(); i++){
						response = -1;
						System.out.println("Departement: " + default_Department_Group.get_array().get(i).get_name());
						default_Department_Group.get_array().get(i).get_workgroup().show();
						System.out.println(default_Department_Group.get_array().get(i).get_workgroup().get_array().size() + ") None of them");
						System.out.println("Please enter the number of the employee you want to use the office.");
						do{
							response = scan2.nextInt();
						}while(response < 0 || response > default_Department_Group.get_array().get(i).get_workgroup().get_array().size());
						if(response != default_Department_Group.get_array().get(i).get_workgroup().get_array().size()){
							default_Building.get_array().get(office).block(default_Department_Group.get_array().get(i).get_workgroup().get_array().get(response));
							i = default_Department_Group.get_array().size();
						}
					}
					break;
				case 7:
					default_Building.show();
					System.out.println("Please, enter the number of the office (Be sure to type it's number, not it's ID or it's code).");
					do{
						response = scan2.nextInt();
					}while(response < 0 || response >= default_Building.get_array().size());
					default_Building.get_array().get(response).unBlock();
					break;
				case 8:
					System.out.println("Not yet implemented");
					break;
				case 9:
					System.out.println("Have a good day !");
					break;
				default:
					System.out.println("Unknown error, exiting.");
					return;
				}
			}while(menu_Resp != 9);
				break;
		default:
			break;
		}
	}
}
