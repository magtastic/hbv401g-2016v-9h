import java.util.ArrayList;

public class Room {

	private Boolean breakfast;
	private Boolean disabledFriendly;
	private Boolean smoking;
	private Double price;
	private ArrayList<Date[]> date;
	private int roomID;

	public Room( Boolean breakfast, Boolean disabledFriendly, Boolean smoking,
							 Double price, ArrayList<Date[]> date) {
		this.breakfast = breakfast;
		this.disabledFriendly = disabledFriendly;
		this.smoking = smoking;
		this.price = price;
		this.date = date;
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
	

}
