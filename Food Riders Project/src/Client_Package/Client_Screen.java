package Client_Package;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.commons.lang.StringUtils;

import Handler_Package.Handler;
import Handler_Package.Order;
import Handler_Package.Restaurant;
import Login_Screen_Package.Client;
import Login_Screen_Package.Login_Screen;

public class Client_Screen {

	private JFrame frame;
	private Point frameLocation;
	
	private JTextField prepTimeTextField;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public void showClientScreen(Handler aData, Client aClient) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_Screen window = new Client_Screen(aData, aClient);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Client_Screen(Handler aData, Client aClient) {
		initialize(aData, aClient);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Handler aData, Client aClient) {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(165, 42, 42));
		frame.getContentPane().setForeground(SystemColor.desktop);
		frame.getContentPane().setLayout(null);
		
		prepTimeTextField = new JTextField();
		prepTimeTextField.setText("Minutes");
		prepTimeTextField.setBounds(245, 88, 86, 20);
		frame.getContentPane().add(prepTimeTextField);
		prepTimeTextField.setColumns(10);
		
		JButton logOutBtn = new JButton("Log out");
		logOutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login_Screen loginScreen;
				try {
					loginScreen = new Login_Screen(aData,frameLocation);
					try {
						URL url = getClass().getResource("/MainMenu_Screen_Package/skypeLogOutSound.wav");
						AudioClip clip = Applet.newAudioClip(url);
						clip.play();
						loginScreen.showLoginScreen(aData,frameLocation);
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		logOutBtn.setBounds(213, 298, 89, 23);
		frame.getContentPane().add(logOutBtn);
		
		JLabel readyLbl = new JLabel("Rider request in:");
		readyLbl.setForeground(SystemColor.text);
		readyLbl.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		readyLbl.setBounds(110, 86, 127, 20);
		frame.getContentPane().add(readyLbl);
		
		JLabel titleLbl = new JLabel("Rider Request");
		titleLbl.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		titleLbl.setBounds(191, 39, 143, 20);
		
		JLabel messageLbl = new JLabel("");
		messageLbl.setBounds(10, 133, 507, 14);
		
		
		URL url = this.getClass().getResource("smileyFace.png");
        Icon icon = new ImageIcon(url);
		JLabel smileyFaceLbl = new JLabel(icon);
		smileyFaceLbl.setBounds(203, 158, 110, 68);
		smileyFaceLbl.setVisible(false);
		
		JButton sendBtn = new JButton("Send");
		sendBtn.setBounds(213, 237, 89, 23);
		frame.getContentPane().add(sendBtn);
		sendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Restaurant restaurant = null ;
				if(!(prepTimeTextField.getText().trim().isEmpty()) && StringUtils.isNumeric(prepTimeTextField.getText().trim())){     
					int prepareTime = Integer.valueOf(prepTimeTextField.getText().trim());
					if(prepareTime !=0) {
						if (aData.findRestaurantFromClient(aClient.getRestaurantID()) != null){
							restaurant = aData.findRestaurantFromClient(aClient.getRestaurantID());
							int orderCode = aData.getRunningOrders().size() + aData.getOrderHistory().size() + 1;
							Order order = new Order(restaurant, prepareTime, orderCode);
							aData.orderStart(order);
							messageLbl.setForeground(Color.yellow);
							
							if(!(aData.getStaffAvailable().isEmpty() || aData.getVehiclesAvailable().isEmpty())) {
								messageLbl.setText(" Thank you! Order has been sent! A Food Rider will be there just on time!");
								smileyFaceLbl.setVisible(true);
								prepTimeTextField.setText("");
							}else {
								messageLbl.setText(" Thank you! There is a high demand right now but we will be there as soon as possible!");
								smileyFaceLbl.setVisible(true);
								prepTimeTextField.setText("");	
							}
							
						}else{
							messageLbl.setForeground(Color.red);
							messageLbl.setText("Something went wrong!");
						}
				}else {
					messageLbl.setForeground(Color.red);
					messageLbl.setText("Preparation time can't be 0. Please fill the blank with a valid number!");
				}
				
			}else{
					smileyFaceLbl.setVisible(false);
					messageLbl.setForeground(Color.red);
					messageLbl.setText("You must fill the blank with a number in order to proceed! ");
					
				}
			}
		});
		
		prepTimeTextField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
			    	prepTimeTextField.setText("");
			    	messageLbl.setText("");
			    	smileyFaceLbl.setVisible(false);
			  }
			});
		
		
		frame.getContentPane().add(titleLbl);
		frame.getContentPane().add(messageLbl);
		
		
		frame.getContentPane().add(smileyFaceLbl);
		
		JLabel minutesLabel = new JLabel("minutes.");
		minutesLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		minutesLabel.setForeground(Color.WHITE);
		minutesLabel.setBounds(339, 88, 75, 17);
		frame.getContentPane().add(minutesLabel);
		frame.setBounds(100, 100, 533, 423);
		WindowListener exitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
            	if (JOptionPane.showConfirmDialog(null, "Are You Sure to Close Application?", "WARNING",
            	        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            	    System.exit(0);
            	} else {
            	    // no option
            	}
            }
        };
        frame.addWindowListener(exitListener);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
