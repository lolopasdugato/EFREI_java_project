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
	
	public static Employee_container initDefaultRhGroup(){
		Employee_container rh = new Employee_container();
		new HumanRessources("897198496523605", "Danielle", "Donagan", "0754625126", "dan@gmail.com", 35, new Date(), rh);
		new HumanRessources("687016233645016", "Jennifer", "O'Connel", "6978149754", "jen666@gmail.com", 24, new Date(), rh);
		return rh;
	}
	
	public static Department_container initDefaultDepContainer(Employee_container e, Employee_container rh){
		Department_container default_Department_Group = new Department_container();
		new Department("Human Ressources", 15000, rh, default_Department_Group);
		new Department("Ingeniering", 160000, e, default_Department_Group);
		return default_Department_Group;
	}

	public static void main(String[] args) {		
		Office_container default_Building = MainClass.initDefaultBuilding();
		Employee_container default_Work_Group1 = MainClass.initDefaultEmployeeGroup();
		Employee_container default_Rh = MainClass.initDefaultRhGroup();
		Department_container default_Department_Group = MainClass.initDefaultDepContainer(default_Work_Group1, default_Rh);
		int menu_Resp = 0;
		int response = -1;
		int type = 0;
		// Determine the person who is using the program
		Employee e = Employee.whoAreYou(default_Department_Group);
		if(e instanceof HumanRessources)
			type = 2;	// Human ressources
		else
			type = 1;	// Simple Employee
		
		switch(type){
		case 1:			// Simple Employee
			Office o = null;
			System.out.println("Hello ! Welcome to our brand new program (beta)!\n\nYou are logged in as a simple Employee\n\n");
			do{
				String answer;
				Scanner scan2 = new Scanner(System.in);
				menu_Resp = Employee.menu();	// Show the menu for a simple Employee
				switch(menu_Resp){
				case 1:							// Show rooms
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
				case 2:							// Show employee's CV
					e.showCV();
					break;
				case 3:							// Starts to fill CV
					e.fillCV();
					break;
				case 4:							// Block a room
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
				case 5:							// Unblock a room
					o.unBlock();
					break;
				case 6:							// Exit the programm
					System.out.println("Have a good day !");
					break;
				default:						// Error case
					System.out.println("Unknown error, exiting.");
					return;
				}
			}while(menu_Resp != 6);
			break;
		case 2:									// Human Ressources
			HumanRessources h = new HumanRessources(e);
			System.out.println("Hello ! Welcome to our brand new program (beta)!\n\nYou are logged in as a member of the human ressources department.\n\n");
			do{
				String answer;
				response = -1;
				Scanner scan2 = new Scanner(System.in);
				menu_Resp = HumanRessources.menu();	// Start the Human ressources menu
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
				case 2:							// Show all details on each employees
					h.showDetailsOnEmployees(default_Department_Group);
					break;
				case 3:							// Show details on each departments
					h.showDepartment(default_Department_Group);
					break;
				case 4:							// Promote an employee to the director's position
					h.promoteToDirector(default_Department_Group);
					break;
				case 5:							// Permit to select an employee and see his Cv
					h.showACv(default_Department_Group);
					break;
				case 6:							// Permit to select an employee and block a room for him
					h.blockARoom(default_Building, default_Department_Group);
					break;
				case 7:							// permit to select a room and unblock it
					h.unBlockARoom(default_Building);
					break;
				case 8:							// Allow to add an employee to an openspace (or reserve the open space)
					h.addToAnOpenSpace(default_Building, default_Department_Group);
					break;
				case 9:							// Allow the Human ressources employee to recruit a new person
					h.addEmployee(default_Department_Group);
					break;
				case 10:						// Allow the human ressources employee to fire an employee
					h.fireEmployee(default_Department_Group);
					break;
				case 11:						// Quit the programm
					System.out.println("Have a good day !");
					break;
				default:
					System.out.println("Unknown error, exiting.");
					return;
				}
			}while(menu_Resp != 11);
				break;
		default:
			break;
		}
	}
}
