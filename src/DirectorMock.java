import java.util.Date;

public class DirectorMock implements Director {
	private DataBaseMock dbMock = new DataBaseMock();
	private InterfaceMock intMock = new InterfaceMock();

	public Hotel[] handelRequest(Date date, String location, int numGuests ){
		
		Hotel[] hotels = new Hotel[1];
		
		hotels[0] = dbMock.getInitHotels(date,location,numGuests);
		
		intMock.showResults(hotels);
		
		return (hotels);
	}

}