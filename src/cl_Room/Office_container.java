package cl_Room;

import java.util.ArrayList;
import cl_Room.Office;

public class Office_container {
	
	private ArrayList<Office> _array;

	public Office_container() {
		super();
		try{
			this._array = new ArrayList<Office>();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public ArrayList<Office> get_array() {
		return _array;
	}
	public void set_array(ArrayList<Office> _array) {
		this._array = _array;
	}
}
