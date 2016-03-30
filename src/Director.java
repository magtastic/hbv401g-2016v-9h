import java.util.Date;

public interface Director {
	public Hotel[] handelRequest(Date date,String location, int numGuest);
}
