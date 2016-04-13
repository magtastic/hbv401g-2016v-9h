import java.util.ArrayList;

public class DataBaseMock implements DataBaseManagerInterface {

	public Hotel[] getInitHotels(String location) {
		
		Hotel[] hotels = new Hotel[1];
		
		hotels[0] = new Hotel(location);
		
		hotels[0] = createDummyHotel(hotels[0]);
		
		return hotels;
	}
	
	public Hotel createDummyHotel(Hotel h) {
		
		TypeOfRoom[] t = new TypeOfRoom[2];
		
		Room[] tRooms = new Room[3];
		
		ArrayList<Date[]> visitTime1 = new ArrayList<Date[]>();
		
		Date[] tmpDate = new Date[2];
		
		tmpDate[0] = new Date(4,4,2016);
		tmpDate[1] = new Date(26,4,2016);
		visitTime1.add(tmpDate);
		tRooms[0] = new Room(true, false, true, 3000.0, visitTime1);
		
		tmpDate[0] = new Date(26,4,2016);
		tmpDate[1] = new Date(2,5,2016);
		visitTime1.add(tmpDate);
		tRooms[1] = new Room(true, false, false, 3000.0, visitTime1);
		
		tmpDate[0] = new Date(8,5,2016);
		tmpDate[1] = new Date(12,5,2016);
		visitTime1.add(tmpDate);
		tRooms[2] = new Room(false, false, false, 3000.0, visitTime1);
		
		t[0] = new TypeOfRoom(1,2,5,1);
		t[0].setRooms(tRooms);
		

		ArrayList<Date[]> visitTime2 = new ArrayList<Date[]>();
		
		tmpDate[0] = new Date(8,4,2016);
		tmpDate[1] = new Date(12,4,2016);
		visitTime2.add(tmpDate);
		tRooms[0] = new Room(true, false, true, 3000.0, visitTime2);
		
		tmpDate[0] = new Date(20,4,2016);
		tmpDate[1] = new Date(23,4,2016);
		visitTime2.add(tmpDate);
		tRooms[1] = new Room(true, false, false, 3000.0, visitTime2);
		
		tmpDate[0] = new Date(24,4,2016);
		tmpDate[1] = new Date(1,5,2016);
		visitTime2.add(tmpDate);
		tRooms[2] = new Room(false, false, false, 3000.0, visitTime2);
		
		t[1] = new TypeOfRoom(2,2,6,2);
		t[1].setRooms(tRooms);
		
		h.setRoomTypes(t);
		
		return h;
	}
	
}