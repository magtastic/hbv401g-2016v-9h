import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DirectorMockTest {
	private DirectorMock dir;
	
	public void setUp(){
		dir = new DirectorMock();
	}
	
	public void clearUp(){
		dir = null;
	}

	@Test
	public void test() {
		Calendar cal = Calendar.getInstance();
		cal.set(2013, Calendar.JANUARY, 9); //Year, month and day of month
		Date date = cal.getTime();
		
		assertEquals("Reykjavík",dir.handelRequest( date, "Reykjavík", 3)[0].getLocation());
	}

}
