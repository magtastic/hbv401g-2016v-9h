public class TypeOfRoom {

	private int singleBed;
	private int doubleBed;
	private int people;
	private int typeOfRoomID;
	private Room[] rooms;
	
	public TypeOfRoom(int singleBed, int doubleBed, int people, int typeOfRoomID) {
	
		this.singleBed = singleBed;
		this.doubleBed = doubleBed;
		this.people = people;
		this typeOfRoomID = typeOfRoomID;
	
	}

	public int getSingleBed() {
		return singleBed;
	}

	public void setSingleBed(int singleBed) {
		this.singleBed = singleBed;
	}

	public int getDoubleBed() {
		return doubleBed;
	}

	public void setDoubleBed(int doubleBed) {
		this.doubleBed = doubleBed;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public int getTypeOfRoomID() {
		return typeOfRoomID;
	}

	public void setTypeOfRoomID(int typeOfRoomID) {
		this.typeOfRoomID = typeOfRoomID;
	}

	public Room[] getRooms() {
		return rooms;
	}

	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}
	
}