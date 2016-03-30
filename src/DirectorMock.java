import java.util.Date;

public class DirectorMock implements Director {
	private DataBaseMock dbMock = new DataBaseMock();
	private InterfaceMock intMock = new InterfaceMock();

	public Hotel[] handelRequest(Date date, String location, int numGuest){
		
		Hotel[] hotels = new Hotel[1];
		
		hotels[0] = dbMock.getInitHotels(location);
		
		hotels[0].getRoomTypes(numGuest);
		
		
		
		
		
		intMock.showResults(hotels);
		
		return (hotels);
	}

}