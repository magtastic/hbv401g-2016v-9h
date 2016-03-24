import TypeOfRoom;

public class Hotel {

	private String location;
	private Long roomsCount;
	private Long roomsAvailable;
	private Double[] priceRange;
	private Double stars;
	private TypeOfRoom[] roomTypes;
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

	public Hotel(String location, Long roomsCount, Long roomsAvailable,
	 						 Double[] priceRange, Double stars, TypeOfRoom[] roomTypes,
							 Boolean parking, Boolean bar, Boolean resturant,
							 Boolean breakfast, Boolean gym, Boolean roomService,
							 Boolean laundryService, Boolean touristInfo, Boolean bikeRent,
							 Boolean airportShuttle, Boolean disabledFriendly) {
		
		this.location = location;
		this.roomsCount = roomsCount;
		this.roomsAvailable = roomsAvailable;
		this.priceRange = priceRange;
		this.stars = stars;
		this.roomTypes = roomTypes;
		this.parking = parking;
		this.bar = bar;
		this.resturant = resturant;
		this.breakfast = brekfast;
		this.gym = gym;
		this.roomService = roomService;
		this.laundryService = laundryService;
		this.touristInfo = touristInfo;
		this.bikeRent = bikeRent;
		this.airportShuttle = airportShuttle;
		this.disabledFriendly = disabledFriendly;
		
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

	public TypeOfRoom[] getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(TypeOfRoom[] roomTypes) {
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
