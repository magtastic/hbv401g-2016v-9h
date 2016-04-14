import java.util.ArrayList;
import java.util.Collections;

public class Director {

	private DatabaseManager db = new DatabaseManager();
	private Interface UI = new Interface();
	private int currentBookingNum = 744;
	
	public void bookRoom(Hotel h , TypeOfRoom t, Date dateIn, Date dateOut) {
				
		ArrayList<Room> rooms = new ArrayList();
		rooms = t.getRooms();
		
		for(int i = 0 ; i<rooms.size() ; i++) {
			if(checkRoom(rooms.get(i),dateIn,dateOut)) {
				//BOKA
				db.updateRoom(h.getHotelID(),t.getTypeOfRoomID(),rooms.get(i).getRoomID(),dateIn,dateOut,currentBookingNum);
				currentBookingNum++;
				return;
			} else System.out.print("VILLA");
		}
		
	}

	
	public ArrayList<Hotel> handleRequest(Date dateIn, Date dateOut, String location, int numGuest){

		ArrayList<Hotel> hotels = db.getInitHotels(location);

		for(int i = 0; i<hotels.size() ; i++) {
			ArrayList<TypeOfRoom> t = filterTypeOfRooms(numGuest , hotels.get(i).getRoomTypes());
			

			for(int j = 0; j<t.size() ; j++) {
	
				if(t.get(j) != null) {
	
					if( !roomAvailable(dateIn , dateOut , t.get(j)) ) {
						t.set(j, null);
					}
				}
			}
			hotels.get(i).setRoomTypes(t);
		}

		return hotels;

	}

	
	public ArrayList<TypeOfRoom> filterTypeOfRooms(int numGuests , ArrayList<TypeOfRoom> t) {

		ArrayList<TypeOfRoom> tFilter = new ArrayList();
		Collections.copy(tFilter, t);
		//System.arraycopy(t, 0, tFilter, 0, t.size());

		for(int i=0; i<tFilter.size(); i++) {
			if(tFilter.get(i).getPeople() != numGuests) {
				tFilter.set(i, null);
			}
		}
		return tFilter;
	}

	
	public boolean roomAvailable(Date dateIn , Date dateOut , TypeOfRoom t) {

		ArrayList<Room> rooms = t.getRooms();

		for(int i = 0; i<rooms.size(); i++){
			if(checkRoom(rooms.get(i),dateIn,dateOut)==true) return true;
		}

		return false;
	}

	public boolean checkRoom(Room room, Date dateIn, Date dateOut) {
		
		ArrayList<Date[]> tmpDate = room.getDate();
		int numFoundDates = 0;

		for(int k = 0; k < tmpDate.size(); k++) {
			
			if( (isBefore(dateIn, tmpDate.get(k)[0]) &&
					 isBefore(dateOut, tmpDate.get(k)[0]))
					||
					(isBefore(tmpDate.get(k)[1], dateIn) &&
					 isBefore(tmpDate.get(k)[1], dateOut)) ){
				numFoundDates++;
			}
			else{
				break;
			}
		}
		if(numFoundDates == tmpDate.size()){
			return true;
		} else return false;
	}
	
	public boolean isBefore (Date d1, Date d2) {

		int d1Year = d1.getYear();
		int d1Month = d1.getMonth();
		int d1Day = d1.getDay();

		int d2Year = d2.getYear();
		int d2Month = d2.getMonth();
		int d2Day = d2.getDay();


		if(d1Year == d2Year){
			if(d1Month == d2Month){
				if(d1Day < d2Day){
					return true;
				}
				return false;
			}
			else if( d1Month < d2Month){
				return true;
			}
			return false;
		}
		else if( d1Year < d2Year){
			return true;
		}

		return false;
	}

	
}
