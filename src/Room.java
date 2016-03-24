import java.util.Date;

public class Room {

	private Boolean breakfast;
	private Boolean disabledFriendly;
	private Boolean smoking;
	private Double price;
	private Date[] date2dArray;

	public Room( Boolean breakfast, Boolean disabledFriendly, Boolean smoking,
							 Double price, Date[] date2dArray) {
		this.breakfast = breakfast;
		this.disabledFriendly = disabledFriendly;
		this.smoking = smoking;
		this.price = price;
		this.date2dArray = date2dArray;
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

	public Date[] getDate2dArray() {
		return date2dArray;
	}

	public void setDate2dArray(Date[] date2dArray) {
		this.date2dArray = date2dArray;
	}

}
