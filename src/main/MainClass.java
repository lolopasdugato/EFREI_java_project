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
		default_Department_Group.get_array().add(new Department("Human Ressources", 15000, e, default_Department_Group));
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

	public static void main(String[] args) {		
		Office_container default_Building = MainClass.initDefaultBuilding();
		Employee_container default_Work_Group1 = MainClass.initDefaultEmployeeGroup();
		Department_container default_Department_Group = MainClass.initDefaultDepContainer(default_Work_Group1);
		int menu_Resp = 0;
		
		switch(Employee.whoAreYou()){
		case 1:
			Office o = null;
			int response = -1;
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
					System.out.println("Please, enter the number of the office (Be sure to type it's number, not it's ID or it's code).");
					do{
						response = scan2.nextInt();
					}while(response < 0 || response >= default_Building.get_array().size());
					if(o == null){
						System.out.println("Does that work?");
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
			break;
		default:
			break;
		}
		
		//Tests
		/*
		default_Building.show();
		default_Work_Group1.show();
		default_Department_Group.show();
		default_Department_Group.get_array().get(0).show();
		*/
		
		
		/*Employee e1 = new Employee(1000, "Jean", "Jacques", "1000", "Mimosa", new Date(), new Date(), staff);
		Employee e2 = new Employee(1950, "Zac", "Jaz", "174500", "Zougoulou", new Date(), new Date(), staff);
		
		IndividualOffice i1 = new IndividualOffice(0505, 15, building);
		OpenSpace o1 = new OpenSpace(0123, 25, building, 34);
		
		
		Department rh = new Department("Human-Ressources", 15000, staff, dep);
		Employee.promote(e2, rh);
		
		i1.unBlock();
		i1.block(e1);
		
		rh.show();
		staff.show();
		building.show();
		
		// o1.set_roomMembers(work_group1);
		// o1.add(e1);
		// System.out.println(e1.toString());
		// System.out.println(i1.toString());
		// e1.showCV();
		// e1.fillCV();
		// e1.showCV();
		 */
	}
}
