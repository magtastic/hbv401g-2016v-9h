public class DataBaseMock implements DataBaseManager {

	public Hotel getInitHotels(String location) {
		
		TypeOfRoom[] types = new TypeOfRoom[3];
		
		types[0] = new TypeOfRoom(1,2,3,1);
		types[1] = new TypeOfRoom(3,0,3,2);
		types[2] = new TypeOfRoom(2,2,6,3);
		
		
		Hotel hotel1 = new Hotel(location);
		
		return hotel1;
	}
	
}