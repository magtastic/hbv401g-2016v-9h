import java.util.ArrayList;

public class Room {

	private Boolean breakfast;
	private Boolean disabledFriendly;
	private Boolean smoking;
	private Double price;
	private ArrayList<Date[]> date;
	private int roomID;

	public Room( int id, double price) {
		this.roomID = id;
		this.price = price;
	}

	public boolean isBreakfast() {
		return breakfast;
	}

	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

	public boolean isDisabledFriendly() {
		return disabledFriendly;
	}

	public void setDisabledFriendly(boolean disabledFriendly) {
		this.disabledFriendly = disabledFriendly;
	}

	public boolean isSmoking() {
		return smoking;
	}

	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ArrayList<Date[]> getDate() {
		return date;
	}
	

	public void setDate(ArrayList<Date[]> date) {
		this.date = date;
	}
	
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int id) {
		this.roomID = id;
	}
	

}
