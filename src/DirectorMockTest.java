import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DirectorMockTest {
	private DirectorInterface dir;
	private Date dateA1;
	private Date dateA2;
	private Date dateB1;
	private Date dateB2;
	private Date dateC1;
	private Date dateC2;
	private Date dateD1;
	private Date dateD2;
	private TypeOfRoom[] t;
	private Room[] r;
	private TypeOfRoom[] expectedResults;

	@Before
	public void setUp(){
		dir = new DirectorMock();
		
		dateA1 = new Date(11,4,2016);
		dateA2 = new Date(20,4,2016);

		dateB1 = new Date(0,4,2016);
		dateB2 = new Date(20,4,2017);

		dateC1 = new Date(20,4,2016);
		dateC2 = new Date(22,4,2016);

		dateD1 = new Date(2,1,2016);
		dateD2 = new Date(20,1,2016);

		r = new Room[3];

		ArrayList<Date[]> visitTime1 = new ArrayList<Date[]>();
		ArrayList<Date[]> visitTime2 = new ArrayList<Date[]>();
		ArrayList<Date[]> visitTime3 = new ArrayList<Date[]>();

		visitTime1.add(new Date[]{new Date(4,4,2016),
								  new Date(26,4,2016)});
		r[0] = new Room(true, false, true, 3000.0, visitTime1);

		visitTime2.add(new Date[]{new Date(4,4,2016),
				                  new Date(9,4,2016)});
		visitTime2.add(new Date[]{new Date(21,4,2016),
				                  new Date(6,5,2016)});
		r[1] = new Room(true, false, false, 3000.0, visitTime2);

		visitTime3.add(new Date[]{new Date(12,4,2016),
                                  new Date(19,4,2016)});
		visitTime3.add(new Date[]{new Date(23,4,2016),
                                  new Date(28,4,2016)});
		visitTime3.add(new Date[]{new Date(29,4,2016),
                                  new Date(4,5,2016)});
		r[2] = new Room(false, false, false, 3000.0, visitTime3);

		t = new TypeOfRoom[5];
		t[0] = new TypeOfRoom(1,2,5,1);
		t[0].setRooms(r);
		t[1] = new TypeOfRoom(1,0,1,2);
		t[2] = new TypeOfRoom(0,1,2,3);
		t[3] = new TypeOfRoom(2,1,4,4);
		t[4] = new TypeOfRoom(3,1,5,5);
	}

	@After
	public void clearUp(){
		dir = null;
		dateA1 = null;
		dateA2 = null;
		dateB1 = null;
		dateB2 = null;
		dateC1 = null;
		dateC2 = null;
		dateD1 = null;
		dateD2 = null;
		t = null;
		r = null;
		expectedResults = null;
	}

	@Test
	public void testIsBefore() {
		assertTrue("testIsBefore", dir.isBefore(dateA1, dateA2));

		assertFalse("testIsBefore", dir.isBefore(dateA2, dateA1));

		assertFalse("testIsBefore", dir.isBefore(dateA1, dateA1));
	}

	@Test
	public void testRoomAvailable() {
		assertTrue("testRoomAvailable", dir.roomAvailable(dateA1, dateA2, t[0]));

		assertFalse("testRoomAvailable", dir.roomAvailable(dateB1, dateB2, t[0]));

		assertTrue("testRoomAvailable", dir.roomAvailable(dateC1, dateC2, t[0]));

		assertTrue("testRoomAvailable", dir.roomAvailable(dateD1, dateD2, t[0]));
	}

	@Test
	public void testFilterTypeOfRoom(){
		expectedResults = new TypeOfRoom[5];

		expectedResults[0] = new TypeOfRoom(1,2,5,1);
		expectedResults[1] = null;
		expectedResults[2] = null;
		expectedResults[3] = null;
		expectedResults[4] = new TypeOfRoom(3,1,5,5);
		
		t = dir.filterTypeOfRooms(5,t);
		
		boolean l = true;
		
		for(int i = 0; i < 5; i++){
			if(expectedResults[i] == null && t[i] == null ){
			}
			else if (expectedResults[i] == null && t[i] != null){
				l = false;
			}
			else if (expectedResults[i] != null && t[i] == null){
				l = false;
			}
			else if( expectedResults[i].getPeople() != t[i].getPeople() ){
				l = false;	
			}
		}
		
		assertTrue("testFilterTypeOfRoom",l);
	}
}
