import java.util.ArrayList;
public class Hotel {

	private String location;
	private Long roomsCount;
	private Long roomsAvailable;
	private Double[] priceRange;
	private Double stars;
	private ArrayList<TypeOfRoom> roomTypes;
	private Boolean parking;
	private Boolean bar;
	private Boolean resturant;
	private Boolean breakfast;
	private Boolean gym;
	private Boolean roomService;
	private Boolean laundryService;
	private Boolean touristInfo;
	private Boolean bikeRent;
	private Boolean airportShuttle;
	private Boolean disabledFriendly;

	public Hotel(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getRoomsCount() {
		return roomsCount;
	}

	public void setRoomsCount(Long roomsCount) {
		this.roomsCount = roomsCount;
	}

	public Long getRoomsAvailable() {
		return roomsAvailable;
	}

	public void setRoomsAvailable(Long roomsAvailable) {
		this.roomsAvailable = roomsAvailable;
	}

	public Double[] getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(Double[] priceRange) {
		this.priceRange = priceRange;
	}

	public Double getStars() {
		return stars;
	}

	public void setStars(Double stars) {
		this.stars = stars;
	}

	public ArrayList<TypeOfRoom> getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(ArrayList<TypeOfRoom> roomTypes) {
		this.roomTypes = roomTypes;
	}

	public Boolean getParking() {
		return parking;
	}

	public void setParking(Boolean parking) {
		this.parking = parking;
	}

	public Boolean getBar() {
		return bar;
	}

	public void setBar(Boolean bar) {
		this.bar = bar;
	}

	public Boolean getResturant() {
		return resturant;
	}

	public void setResturant(Boolean resturant) {
		this.resturant = resturant;
	}

	public Boolean getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(Boolean breakfast) {
		this.breakfast = breakfast;
	}

	public Boolean getGym() {
		return gym;
	}

	public void setGym(Boolean gym) {
		this.gym = gym;
	}

	public Boolean getRoomService() {
		return roomService;
	}

	public void setRoomService(Boolean roomService) {
		this.roomService = roomService;
	}

	public Boolean getLaundryService() {
		return laundryService;
	}

	public void setLaundryService(Boolean laundryService) {
		this.laundryService = laundryService;
	}

	public Boolean getTouristInfo() {
		return touristInfo;
	}

	public void setTouristInfo(Boolean touristInfo) {
		this.touristInfo = touristInfo;
	}

	public Boolean getBikeRent() {
		return bikeRent;
	}

	public void setBikeRent(Boolean bikeRent) {
		this.bikeRent = bikeRent;
	}

	public Boolean getAirportShuttle() {
		return airportShuttle;
	}

	public void setAirportShuttle(Boolean airportShuttle) {
		this.airportShuttle = airportShuttle;
	}

	public Boolean getDisabledFriendly() {
		return disabledFriendly;
	}

	public void setDisabledFriendly(Boolean disabledFriendly) {
		this.disabledFriendly = disabledFriendly;
	}

}
