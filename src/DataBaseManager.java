
public class DatabaseManager {
	public Hotel[] getInitHotels(String location) {
			
			Hotel[] hotels = new Hotel[1];
			
			hotels[0] = new Hotel(location);
			
			//hotels[0] = createDummyHotel(hotels[0]);
			
			return hotels;
		}
}
