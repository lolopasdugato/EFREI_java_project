package cl_WorkingObjects;

import java.util.ArrayList;
import java.util.Scanner;

import cl_People.Employee;

public class CV {


	private ArrayList<String> _jobs;
	private ArrayList<String> _schooling;
	public CV(Employee _employee) {
		super();
		_employee.set_curiculum(this);
		_jobs = new ArrayList<String>();
		_schooling = new ArrayList<String>();		
	}
	public ArrayList<String> get_jobs() {
		return _jobs;
	}
	public void set_jobs(ArrayList<String> _jobs) {
		this._jobs = _jobs;
	}
	public ArrayList<String> get_schooling() {
		return _schooling;
	}
	public void set_schooling(ArrayList<String> _schooling) {
		this._schooling = _schooling;
	}
	
	public void fill(){
		Scanner sc = new Scanner(System.in);
		String in;
		do{
			System.out.println("Do you want to enter a job ? (y/n)");
			in = sc.nextLine();
			if(in.equals("y")){
				System.out.println("Enter your new job: ");
				String in2 = sc.nextLine();
				this._jobs.add(in2);
			}
		}while(!in.equals("n"));
		
		do{
			System.out.println("Do you want to enter a special studie event ? (y/n)");
			in = sc.nextLine();
			if(in.equals("y")){
				System.out.println("Enter a new event: ");
				String in2 = sc.nextLine();
				this._schooling.add(in2);
			}
		}while(!in.equals("n"));
		return;
	}
	
	public void show(){
		if (_jobs.size() != 0){
			System.out.println("Jobs: ");
			for (int cpt = 0; cpt < _jobs.size(); cpt++){
				System.out.println("Job number " + (cpt + 1) + ": " + _jobs.get(cpt));
			}
		}
		else
			System.out.println("No Studies in this CV.");
		if (_schooling.size() != 0){
			System.out.println("Studies: ");
			for (int cpt = 0; cpt < _schooling.size(); cpt++){
				System.out.println("* " + _schooling.get(cpt));
			}
		}
		else
			System.out.println("No Studies in this CV.");
		return;
	}

}
