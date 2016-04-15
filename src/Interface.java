import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Interface {

	private JFrame frame;
	private JTextPane txtpnResults = new JTextPane();
	private final JTextPane txtpnStars = new JTextPane();
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
		Date dateIn = new Date(29,3,16);
		Date dateOut = new Date(1,5,16);
		ArrayList<Hotel> hotels = new Director().handleRequest(dateIn,dateOut,"Reykjavik",200);
		return hotels;
	}
	
	public void showHotelNames(ArrayList<Hotel> h){
		String names = "Names: ";
		String stars = "Stars: ";
		for(int i = 0 ; i < h.size() ; i++ ){
			names = names + h.get(i).getName() + ", ";
			stars += String.valueOf(h.get(i).getStars()) + ", ";
		}
		txtpnStars.setText(stars);
		txtpnResults.setText(names);
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
				ArrayList<Hotel> hotels = Test();
				showHotelNames(hotels);
			}
		});
		frame.getContentPane().add(btnHandlerequest, BorderLayout.NORTH);
		txtpnStars.setText("Stars:");
		
		frame.getContentPane().add(txtpnStars, BorderLayout.CENTER);
		
		txtpnResults.setText("Results:");
		frame.getContentPane().add(txtpnResults, BorderLayout.WEST);
	}
	
	public void showResults(Hotel[] results){
		return;
	}

}