import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interface {

	private JFrame frame;
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
	
	public void Test(){
		Date dateIn = new Date(29,3,16);
		Date dateOut = new Date(1,5,16);
		ArrayList<Hotel> hotels = new Director().handleRequest(dateIn,dateOut,"Reykjavik",200);
		for( int i = 0 ; i<hotels.size() ; i++) {
			for(int j = 0 ; j<hotels.get(i).getRoomTypes().size() ; j++) {
				System.out.println(hotels.get(i).getRoomTypes());
			}    	    	  
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
		
		JButton btnHandlerequest = new JButton("handleRequest");
		btnHandlerequest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("oyoyo");
				Test();
			}
		});
		frame.getContentPane().add(btnHandlerequest, BorderLayout.CENTER);
	}
	
	public void showResults(Hotel[] results){
		return;
	}

}