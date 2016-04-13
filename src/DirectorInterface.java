
public interface DirectorInterface {

	void handleRequest(Date dateIn, Date dateOut, String location, int numGuest);

	TypeOfRoom[] filterTypeOfRooms(int numGuests, TypeOfRoom[] t);

	boolean roomAvailable(Date dateIn, Date dateOut, TypeOfRoom t);

	boolean isBefore(Date d1, Date d2);

}