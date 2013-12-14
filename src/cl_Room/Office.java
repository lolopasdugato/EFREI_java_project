package cl_Room;

public abstract class Office {
	protected int _code;
	protected int _size;
	protected int _id;
	protected static int _nbOfInstance;
	protected Boolean _reserved;
	
	public Boolean get_reserved() {
		return _reserved;
	}
	public void set_reserved(Boolean _reserved) {
		this._reserved = _reserved;
	}
	public int get_code() {
		return _code;
	}
	public void set_code(int _code) {
		this._code = _code;
	}
	public int get_size() {
		return _size;
	}
	public void set_size(int _size) {
		this._size = _size;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public static int get_nbOfInstance() {
		return _nbOfInstance;
	}
	public static void set_nbOfInstance(int _nbOfInstance) {
		Office._nbOfInstance = _nbOfInstance;
	}
	public Office(int _code, int _size, Boolean _reserved) {
		super();
		this._code = _code;
		this._size = _size;
		_nbOfInstance++;
		this._id = _nbOfInstance;
		this._reserved = _reserved;
	}
}
