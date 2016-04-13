import java.util.ArrayList;

public class Director {

	private DatabaseManager db = new DatabaseManager();
	private Interface UI = new Interface();

	
	public void handleRequest(Date dateIn, Date dateOut, String location, int numGuest){

		Hotel[] hotels = db.getInitHotels(location);

		for(int i = 0; i<hotels.length ; i++) {
			TypeOfRoom[] t = filterTypeOfRooms(numGuest , hotels[i].getRoomTypes());
			

			for(int j = 0; j<t.length ; j++) {
	
				if(t[j] != null) {
	
					if( !roomAvailable(dateIn , dateOut , t[j]) ) {
						t[j]=null;
					}
				}
			}
			hotels[i].setRoomTypes(t);
		}

		UI.showResults(hotels);

	}

	
	public TypeOfRoom[] filterTypeOfRooms(int numGuests , TypeOfRoom[] t) {

		TypeOfRoom[] tFilter = new TypeOfRoom[t.length];
		System.arraycopy(t, 0, tFilter, 0, t.length);

		for(int i=0; i<tFilter.length; i++) {
			if(tFilter[i].getPeople() != numGuests) {
				tFilter[i] = null;
			}
		}
		return tFilter;
	}

	
	public boolean roomAvailable(Date dateIn , Date dateOut , TypeOfRoom t) {

		Room[] rooms = t.getRooms();

		for(int i = 0; i<rooms.length; i++){
			ArrayList<Date[]> tmpDate = rooms[i].getDate();
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
			}

		}

		return false;
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
