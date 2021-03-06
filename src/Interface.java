import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

public class Interface {

	private JFrame frame;
	JTextPane textPane = new JTextPane();
	JTextPane textPane_1 = new JTextPane();
	JTextPane textPane_2 = new JTextPane();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ArrayList<Hotel> Test(){
		Date dateIn = new Date(29,1,11);
		Date dateOut = new Date(30,1,11);
		ArrayList<Hotel> hotels = new Director().handleRequest(dateIn,dateOut,"Akureyri",3);
		System.out.println(hotels);
		return hotels;
	}
	
	public void showHotelNames(Hotel h, int i){
		System.out.println(i);
		String hotelName = "";
	    ArrayList<TypeOfRoom> t = h.getRoomTypes();
    	JTextPane[] typePane = new JTextPane[t.size()];
		switch(i){
			case 0:
				hotelName = h.getName();
				textPane.setBounds(38,68,100,16);
			    textPane.setText(hotelName);
			    
			    for(int k = 0; k<t.size(); k++){
			    	typePane[k] = new JTextPane();
			    	typePane[k].setBounds(38,68+(32*(k+1)),100,16);
			    	frame.getContentPane().add(typePane[k]);
			    	String tmpText = t.get(k).getDoubleBed() + " (d)."+t.get(k).getSingleBed()+" (s).";			    	
			    	typePane[k].setText(tmpText);
			    }
			    break;
			case 1:
				hotelName = h.getName();
				System.out.println(hotelName);
				textPane_1.setBounds(204,68,200,16);
				textPane_1.setText(hotelName);
				
				for(int k = 0; k<t.size(); k++){
			    	typePane[k] = new JTextPane();
			    	typePane[k].setBounds(204,68+(32*(k+1)),100,16);
			    	frame.getContentPane().add(typePane[k]);
			    	String tmpText = t.get(k).getDoubleBed() + " (d)."+t.get(k).getSingleBed()+" (s).";	
			    	typePane[k].setText(tmpText);
			    }
			    break;
			case 2:
				hotelName = h.getName();
				textPane_2.setBounds(362,68,100,16);
				textPane_2.setText(hotelName);
				
				for(int k = 0; k<t.size(); k++){
			    	typePane[k] = new JTextPane();
			    	typePane[k].setBounds(362,68+(32*(k+1)),100,16);
			    	frame.getContentPane().add(typePane[k]);
			    	String tmpText = t.get(k).getPeople() + "";
			    	typePane[k].setText(tmpText);
			    }
			    break;
		}
	}
	
	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnHandlerequest = new JButton("handleRequest");
		btnHandlerequest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Hotel> h = Test();
				for(int i = 0; i < h.size(); i++){
					showHotelNames(h.get(i),i);	
				}
			}
		});
		btnHandlerequest.setBounds(158, 19, 117, 29);
		frame.getContentPane().add(btnHandlerequest);
		
		textPane.setBounds(38, 84, 1, 16);
		frame.getContentPane().add(textPane);
		
		textPane_1.setBounds(204, 84, 1, 16);
		frame.getContentPane().add(textPane_1);
		
		textPane_2.setBounds(363, 84, 1, 16);
		frame.getContentPane().add(textPane_2);
		
		JButton btnBookroom = new JButton("bookRoom");
		btnBookroom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//boka
				test2();
				
			}

			
		});
		btnBookroom.setBounds(169, 199, 97, 25);
		frame.getContentPane().add(btnBookroom);
	}
	public void test2() {
		// TODO Auto-generated method stub
		
		ArrayList<Hotel> h = Test();
		
		Director dir = new Director();
		Date dateIn = new Date(29,1,10);
		Date dateOut = new Date(30,1,10);
		
		ArrayList<TypeOfRoom> t = h.get(0).getRoomTypes();
		
		dir.bookRoom(h.get(0), t.get(0), dateIn, dateOut);
	}
	public void showResults(Hotel[] results){
		return;
	}
}