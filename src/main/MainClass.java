package main;

import cl_Room.*;
import cl_People.*;
import java.util.Date;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Office_container building = new Office_container();
		Employee_container staff = new Employee_container();
		// Employee_container work_group1 = new Employee_container();
		
		Employee e1 = new Employee(1000, "Jean", "Jacques", "1000", "Mimosa", new Date(), new Date(), staff);
		IndividualOffice i1 = new IndividualOffice(0505, 15, building);
		OpenSpace o1 = new OpenSpace(0123, 25, building, 34);
		i1.unBlock();
		i1.block(e1);
		// o1.set_roomMembers(work_group1);
		o1.add(e1);
		System.out.println(e1.toString());
		System.out.println(i1.toString());
		e1.showCV();
		e1.fillCV();
		e1.showCV();
	}
}
