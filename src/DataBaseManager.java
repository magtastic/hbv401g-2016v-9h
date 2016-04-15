
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseManager {
	
	public ArrayList<Hotel> getInitHotels(String location) {
		
		ArrayList<Hotel> hotels = new ArrayList();
		//DATABASE
		//-----------------------------------
		
	    Connection connection = null;
	    try
	    {
	      // create a database connection
	      connection = DriverManager.getConnection("jdbc:sqlite:hotels.db");
	      Statement statement = connection.createStatement();
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.
	      PreparedStatement result1 = connection.prepareStatement(""
	      		+ "SELECT * "
	      		+ "FROM hotels "
	      		+ "WHERE location=?");
	      result1.setString(1, location);
	      
	      //statement.executeUpdate("create table person (id integer, name string)");
	      ResultSet rs1 = result1.executeQuery();
	      //ArrayList<Hotel> hotels = new ArrayList();
	      int i = 0;	      
	      while(rs1.next())
	      {
	        // read the result set	    	
	    	hotels.add(new Hotel(location));
	    	hotels.get(i).setHotelID(rs1.getInt("id"));
	    	hotels.get(i).setHotelInfo(rs1.getString("info"));
	    	hotels.get(i).setName(rs1.getString("name"));
	    	
	    	PreparedStatement result2 = connection.prepareStatement(""
	    			+ "SELECT typeOfRooms.id,typeOfRooms.numGuest,typeOfRooms.kingBed,typeOfRooms.singleBed "
	    			+ "FROM typeOfRooms,hotels "
	    			+ "WHERE hotels.id=typeOfRooms.hotelID "
	    			+ "AND hotels.id=? GROUP BY typeOfRooms.id");
		    result2.setInt(1, hotels.get(i).getHotelID());
		    ResultSet rs2 = result2.executeQuery();
		    ArrayList<TypeOfRoom> tor = new ArrayList();
		    int j = 0;
		    while(rs2.next()) 
		    {
		    	int tmpID = rs2.getInt("id");
		    	int tmpNumGuest = rs2.getInt("numGuest");
		    	int tmpDouble = rs2.getInt("kingBed");
		    	int tmpSingle = rs2.getInt("singleBed");
		    	
		    	tor.add(new TypeOfRoom(tmpSingle,tmpDouble,tmpNumGuest,tmpID));
		    	
		    	PreparedStatement result3 = connection.prepareStatement(""
		    			+ "SELECT rooms.id, rooms.price "
		    			+ "FROM typeOfRooms,rooms "
		    			+ "WHERE typeOfRooms.id=rooms.typeOfRoomID "
		    			+ "AND typeOfRooms.id=? GROUP BY rooms.id");
			    
		    	result3.setInt(1, tor.get(j).getTypeOfRoomID());
			    ResultSet rs3 = result3.executeQuery();
			    ArrayList<Room> rooms = new ArrayList();
			    int k = 0;
			    while(rs3.next()) 
			    {
			    	int tmpId = rs3.getInt("id");
			    	double tmpPrice = rs3.getDouble("price");
			    	
			    	rooms.add(new Room(tmpId,tmpPrice));
			    	//System.out.println(tmpId);
			    	
			    	PreparedStatement result4 = connection.prepareStatement(""
			    			+ "SELECT bookings.arrival, bookings.departure, bookings.id "
			    			+ "FROM bookings,rooms "
			    			+ "WHERE rooms.id=bookings.roomID "
			    			+ "AND rooms.id=?");
				    result4.setInt(1, rooms.get(k).getRoomID());
				    ResultSet rs4 = result4.executeQuery();
				    ArrayList<Date[]> bookings = new ArrayList();
				    
				    while(rs4.next())
				    {
				    	String arrival = rs4.getString("arrival");
				    	String departure = rs4.getString("departure");
				    	
				    	//correctstring
				    	while(arrival.length() != 6) {
				    		arrival = "0"+arrival;
				    	}
				    	while(departure.length() != 6) {
				    		departure = "0"+departure;
				    	}
				    	Date[] date = new Date[2];
				    	
				    	date[0] = stringToDate(arrival);
				    	date[1] = stringToDate(departure);
				    	
				    	bookings.add(date);
				    					    	
				    	
				    }
			    	rooms.get(k).setDate(bookings);
			    	k++;
			    }
		    	tor.get(j).setRooms(rooms);
		    	j++;
		    }
		    hotels.get(i).setRoomTypes(tor);
	        i++;
	      }
	    
	      //PRINT
	      /*for( i = 0 ; i<hotels.size() ; i++) {
	    	  for(int j = 0 ; j<hotels.get(i).getRoomTypes().size() ; j++) {
	    		  for(int k = 0 ; k<hotels.get(i).getRoomTypes().get(j).getRooms().size() ; k++) {
	    			  for(int m = 0 ; m<hotels.get(i).getRoomTypes().get(j).getRooms().get(k).getDate().size() ; m++) {
	    				  System.out.println(hotels.get(i).getRoomTypes().get(j).getRooms().get(k).getDate().get(m)[0].getDay());
	    				  System.out.println(hotels.get(i).getRoomTypes().get(j).getRooms().get(k).getDate().get(m)[1].getDay());
	    			  }	    			  
		    	  }
	    	  }    	    	  
	      }*/
	      //statement.executeUpdate("drop table if exists person");
	      //statement.executeUpdate("create table person (id intege
	    }
	    catch(SQLException e)
	    {
	      // if the error message is "out of memory", 
	      // it probably means no database file is found
	      System.err.println(e.getMessage());
	    }
	    finally
	    {
	      try
	      {
	        if(connection != null)
	          connection.close();
	      }
	      catch(SQLException e)
	      {
	        // connection close failed.
	        System.err.println(e);
	      }
	    }
	    return hotels;
	    //-----------------------------------
		}
	
		public void updateRoom(int hotelID, int typeOfRoomID, int roomID, Date dateIn, Date dateOut , int currBook) {
			// UPDATE SQL
			Connection connection = null;
		    try
		    {
		      // create a database connection
		      connection = DriverManager.getConnection("jdbc:sqlite:hotels.db");
		      Statement statement = connection.createStatement();
		      statement.setQueryTimeout(30);  // set timeout to 30 sec.
		      PreparedStatement result = connection.prepareStatement(""
		      		+ "INSERT INTO bookings(roomID,arrival,departure,id) "
		      		+ "VALUES (?,?,?,?) "
		      		+ "WHERE bookings.roomID=?");
		      
		      String arrival = dateToString(dateIn);
		      String departure = dateToString(dateOut);
		      
		      result.setInt(1, roomID);
		      result.setString(2, arrival);
		      result.setString(3, departure);
		      result.setInt(4, 900);
		      result.setInt(5, currBook);
		      
		      // tharf ad gera thetta? Er ekki viss
		      ResultSet rs1 = result.executeQuery();
		    }
		    catch(SQLException e)
		    {
		      // if the error message is "out of memory", 
		      // it probably means no database file is found
		      System.err.println(e.getMessage());
		    }
		    finally
		    {
		      try
		      {
		        if(connection != null)
		          connection.close();
		      }
		      catch(SQLException e)
		      {
		        // connection close failed.
		        System.err.println(e);
		      }
		    }
		    currBook++;
		}
	
	  

	public static void main(String[] args) 
	  {
		//DATABASE
		//-----------------------------------
		
	    Connection connection = null;
	    try
	    {
	      // create a database connection
	      connection = DriverManager.getConnection("jdbc:sqlite:hotels.db");
	      Statement statement = connection.createStatement();
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.
	      PreparedStatement result1 = connection.prepareStatement(""
	      		+ "SELECT * "
	      		+ "FROM hotels "
	      		+ "WHERE location=?");
	      result1.setString(1, "Reykjavik");
	      
	      //statement.executeUpdate("create table person (id integer, name string)");
	      ResultSet rs1 = result1.executeQuery();
	      ArrayList<Hotel> hotels = new ArrayList();
	      int i = 0;	      
	      while(rs1.next())
	      {
	        // read the result set	    	
	    	hotels.add(new Hotel("Reykjavik"));
	    	hotels.get(i).setHotelID(rs1.getInt("id"));
	    	hotels.get(i).setHotelInfo(rs1.getString("info"));	   
	    	
	    	PreparedStatement result2 = connection.prepareStatement(""
	    			+ "SELECT typeOfRooms.id,typeOfRooms.numGuest,typeOfRooms.kingBed,typeOfRooms.singleBed "
	    			+ "FROM typeOfRooms,hotels "
	    			+ "WHERE hotels.id=typeOfRooms.hotelID "
	    			+ "AND hotels.id=? GROUP BY typeOfRooms.id");
		    result2.setInt(1, hotels.get(i).getHotelID());
		    ResultSet rs2 = result2.executeQuery();
		    ArrayList<TypeOfRoom> tor = new ArrayList();
		    int j = 0;
		    while(rs2.next()) 
		    {
		    	int tmpID = rs2.getInt("id");
		    	int tmpNumGuest = rs2.getInt("numGuest");
		    	int tmpDouble = rs2.getInt("kingBed");
		    	int tmpSingle = rs2.getInt("singleBed");
		    	
		    	tor.add(new TypeOfRoom(tmpSingle,tmpDouble,tmpNumGuest,tmpID));
		    	
		    	PreparedStatement result3 = connection.prepareStatement(""
		    			+ "SELECT rooms.id, rooms.price "
		    			+ "FROM typeOfRooms,rooms "
		    			+ "WHERE typeOfRooms.id=rooms.typeOfRoomID "
		    			+ "AND typeOfRooms.id=? GROUP BY rooms.id");
			    
		    	result3.setInt(1, tor.get(j).getTypeOfRoomID());
			    ResultSet rs3 = result3.executeQuery();
			    ArrayList<Room> rooms = new ArrayList();
			    int k = 0;
			    while(rs3.next()) 
			    {
			    	int tmpId = rs3.getInt("id");
			    	double tmpPrice = rs3.getDouble("price");
			    	
			    	rooms.add(new Room(tmpId,tmpPrice));
			    	//System.out.println(tmpId);
			    	
			    	PreparedStatement result4 = connection.prepareStatement(""
			    			+ "SELECT bookings.arrival, bookings.departure, bookings.id "
			    			+ "FROM bookings,rooms "
			    			+ "WHERE rooms.id=bookings.roomID "
			    			+ "AND rooms.id=?");
				    result4.setInt(1, rooms.get(k).getRoomID());
				    ResultSet rs4 = result4.executeQuery();
				    ArrayList<Date[]> bookings = new ArrayList();
				    
				    while(rs4.next())
				    {
				    	String arrival = rs4.getString("arrival");
				    	String departure = rs4.getString("departure");
				    	
				    	//correctstring
				    	while(arrival.length() != 6) {
				    		arrival = "0"+arrival;
				    	}
				    	while(departure.length() != 6) {
				    		departure = "0"+departure;
				    	}
				    	Date[] date = new Date[2];
				    	
				    	date[0] = stringToDate(arrival);
				    	date[1] = stringToDate(departure);
				    	
				    	bookings.add(date);
				    					    	
				    	
				    }
			    	rooms.get(k).setDate(bookings);
			    	k++;
			    }
		    	tor.get(j).setRooms(rooms);
		    	j++;
		    }
		    hotels.get(i).setRoomTypes(tor);
	        i++;
	      }
	    
	      //PRINT
	      /*for( i = 0 ; i<hotels.size() ; i++) {
	    	  for(int j = 0 ; j<hotels.get(i).getRoomTypes().size() ; j++) {
	    		  for(int k = 0 ; k<hotels.get(i).getRoomTypes().get(j).getRooms().size() ; k++) {
	    			  for(int m = 0 ; m<hotels.get(i).getRoomTypes().get(j).getRooms().get(k).getDate().size() ; m++) {
	    				  System.out.println(hotels.get(i).getRoomTypes().get(j).getRooms().get(k).getDate().get(m)[0].getDay());
	    				  System.out.println(hotels.get(i).getRoomTypes().get(j).getRooms().get(k).getDate().get(m)[1].getDay());
	    			  }	    			  
		    	  }
	    	  }    	    	  
	      }*/
	      //statement.executeUpdate("drop table if exists person");
	      //statement.executeUpdate("create table person (id intege
	    }
	    catch(SQLException e)
	    {
	      // if the error message is "out of memory", 
	      // it probably means no database file is found
	      System.err.println(e.getMessage());
	    }
	    finally
	    {
	      try
	      {
	        if(connection != null)
	          connection.close();
	      }
	      catch(SQLException e)
	      {
	        // connection close failed.
	        System.err.println(e);
	      }
	    }
	    //return hotels;
	    //-----------------------------------
	  }

	private static Date stringToDate(String s) {
		
		int day = Integer.parseInt(s.substring(0,2));
		int month = Integer.parseInt(s.substring(2,4));
		int year = Integer.parseInt(s.substring(4,6));		
		
		Date d = new Date(day,month,year);
		
		return d;
	}
	private String dateToString(Date d) {
		
		String day = d.getDay() + "";
		String month = d.getMonth() + "";
		String year = d.getYear() + "";
		
		if(day.length() == 1) {
			day = "0"+day;
		}
		if(month.length() == 1) {
			month = "0"+month;
		}
		if(year.length() == 1) {
			year = "0"+year;
		}
		
		String dateResult = day+month+year;
		
		return dateResult;
	}
}
