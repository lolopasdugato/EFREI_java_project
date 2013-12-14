package cl_Room;

public class MeetingRoom extends Office {
	// Missing the attribute that represent the manager of this room
	private Boolean _projector;

	public Boolean get_projector() {
		return _projector;
	}

	public void set_projector(Boolean _projector) {
		this._projector = _projector;
	}
	
	public MeetingRoom(int _code, int _size, Boolean _reserved, Boolean _projector) {
		super(_code, _size, _reserved);
		this._projector = _projector;
	}

}
