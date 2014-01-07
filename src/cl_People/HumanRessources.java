package cl_People;

import java.util.Date;
import java.util.Scanner;

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
	
	
}
