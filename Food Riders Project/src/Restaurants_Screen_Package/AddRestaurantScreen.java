package Restaurants_Screen_Package;

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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.commons.lang.StringUtils;

import Handler_Package.GuiManagement;
import Handler_Package.Handler;
import Handler_Package.Restaurant;
import Login_Screen_Package.Client;
import Login_Screen_Package.Database;


public class AddRestaurantScreen {

	private JFrame frame;
	
	private JTextField nameTextField;
	private JLabel lblAddress;
	private JTextField addressTextField;
	private JLabel lblTelephoneNumber;
	private JTextField telephoneNumTextField;
	private JLabel lblEmail;
	private JTextField emailTextField;
	private JLabel lblOtherComments;
	private JLabel timeDistanceLabel;
	private JTextField timeDistanceTextField;
	private JLabel messageLabel;
	private JTextField textFieldClientUsername;
	private JTextField textFieldClientPassword;

	/**
	 * Launch the application.
	 */
	public void addRestaurant(Handler data, Point aFrameLocation, Restaurant rowData) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRestaurantScreen window = new AddRestaurantScreen(data, aFrameLocation,  rowData);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param rowData 
	 * @param db 
	 */
	public AddRestaurantScreen(Handler data, Point aFrameLocation, Restaurant rowData) {
		initialize(data,aFrameLocation,rowData);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param rowData 
	 * @param db 
	 */
	private void initialize(Handler data, Point aFrameLocation, Restaurant rowData) {
		
		frame = new JFrame();
		frame.setLocation(aFrameLocation);
		frame.getContentPane().setBackground(new Color(165, 42, 42));

		
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Add a Restaurant");
		if (rowData != null) {
			titleLabel.setText("Editing - " + rowData.getName());
		}
		titleLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		titleLabel.setBounds(250, 0, 160, 66);
		frame.getContentPane().add(titleLabel);
		
		JLabel nameLabel = new JLabel("Restaurant Name :");
		nameLabel.setForeground(SystemColor.text);
		nameLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		nameLabel.setBounds(37, 79, 134, 22);
		frame.getContentPane().add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(201, 82, 134, 20);
		frame.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		if (rowData != null) {
			nameTextField.setText(rowData.getName());
		}
		
		lblAddress = new JLabel("Address :");
		lblAddress.setForeground(SystemColor.text);
		lblAddress.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblAddress.setBounds(37, 200, 550, 14);
		frame.getContentPane().add(lblAddress);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(133, 197, 454, 20);
		frame.getContentPane().add(addressTextField);
		addressTextField.setColumns(10);
		if (rowData != null) {
			addressTextField.setText(rowData.getAddress());
		}
		
		lblTelephoneNumber = new JLabel("Telephone Number : ");
		lblTelephoneNumber.setForeground(SystemColor.text);
		lblTelephoneNumber.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblTelephoneNumber.setBounds(34, 141, 153, 14);
		frame.getContentPane().add(lblTelephoneNumber);
		
		telephoneNumTextField = new JTextField();
		telephoneNumTextField.setBounds(201, 140, 134, 20);
		frame.getContentPane().add(telephoneNumTextField);
		telephoneNumTextField.setColumns(10);
		if (rowData != null) {
			telephoneNumTextField.setText(rowData.getTelephoneNum());
		}
		
		lblEmail = new JLabel("E-mail :");
		lblEmail.setForeground(SystemColor.text);
		lblEmail.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblEmail.setBounds(357, 146, 71, 14);
		frame.getContentPane().add(lblEmail);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(441, 140, 151, 20);
		frame.getContentPane().add(emailTextField);
		emailTextField.setColumns(10);
		if (rowData != null) {
			emailTextField.setText(rowData.getEmail());
		}
		
		if (rowData == null) {
			JLabel lblClient = new JLabel("Client Username : ");
			lblClient.setForeground(Color.WHITE);
			lblClient.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
			lblClient.setBounds(37, 247, 153, 14);
			frame.getContentPane().add(lblClient);
			
			textFieldClientUsername = new JTextField();
			textFieldClientUsername.setColumns(10);
			textFieldClientUsername.setBounds(201, 244, 134, 20);
			frame.getContentPane().add(textFieldClientUsername);
			
			textFieldClientPassword = new JTextField();
			textFieldClientPassword.setColumns(10);
			textFieldClientPassword.setBounds(441, 245, 151, 20);
			frame.getContentPane().add(textFieldClientPassword);
			
			JLabel lblPassword = new JLabel("Password :");
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
			lblPassword.setBounds(349, 247, 89, 14);
			frame.getContentPane().add(lblPassword);
		}
		
		lblOtherComments = new JLabel("Other Comments :");
		lblOtherComments.setForeground(SystemColor.text);
		lblOtherComments.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lblOtherComments.setBounds(37, 288, 139, 14);
		frame.getContentPane().add(lblOtherComments);
		
		timeDistanceLabel = new JLabel("Time Distance:");
		timeDistanceLabel.setForeground(SystemColor.text);
		timeDistanceLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		timeDistanceLabel.setBounds(363, 83, 127, 14);
		frame.getContentPane().add(timeDistanceLabel);
		
		timeDistanceTextField = new JTextField();
		timeDistanceTextField.setForeground(Color.LIGHT_GRAY);
		timeDistanceTextField.setText("0");
		timeDistanceTextField.setBounds(509, 82, 30, 20);
		frame.getContentPane().add(timeDistanceTextField);
		timeDistanceTextField.setColumns(10);
		/*if (rowData != null) {
			timeDistanceTextField.setText(rowData.getTimeDistance());
			
		}*/
		
		JTextArea otherCommentsTextArea = new JTextArea();
		otherCommentsTextArea.setBounds(35, 315, 557, 59);
		frame.getContentPane().add(otherCommentsTextArea);
		if (rowData != null) {
			otherCommentsTextArea.setText(rowData.getComments());
		}
		
		messageLabel = new JLabel("");
		messageLabel.setBounds(133, 405, 368, 14);
		frame.getContentPane().add(messageLabel);
		
		
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!(StringUtils.isNumeric(timeDistanceTextField.getText().trim()))) {
					timeDistanceTextField.setBackground(Color.red);
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Unexpected entry in Time Distance. Entry must be numeric! ");
				}else {
				int ID = Restaurant.getIDsetter();
				if (rowData != null) {
					ID = rowData.getId();
				}
				String name = nameTextField.getText().trim();
				int timeDistance = Integer.valueOf(timeDistanceTextField.getText().trim());
				String telephoneNum = telephoneNumTextField.getText().trim();
				String email = emailTextField.getText().trim();
				String address = addressTextField.getText().trim();
				String comments = otherCommentsTextArea.getText().trim();
				String clientUsername = null;
				String clientPassword = null;
				//String clientUsername = db.findClientByRestaurantID(ID).getName(); //arxikopoieisi ston client pou antistoixoun
				//String clientPassword = db.findClientByRestaurantID(ID).getPassword();
				if(rowData == null) {
					clientUsername = textFieldClientUsername.getText().trim();
					clientPassword = textFieldClientPassword.getText().trim();
				}
				String subscriptionDate = "Error Occurred";
			
				if(rowData == null) { //if its an add and not an edit
					subscriptionDate = "Error Occurred";
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //set Current local date as recruitmentDate
					LocalDate localDate = LocalDate.now();
					subscriptionDate = dtf.format(localDate).toString();
				}
				
				if(name.isEmpty() || timeDistance == 0 || telephoneNum.isEmpty() || email.isEmpty() || address.isEmpty()) {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("You must fill all the blanks in order to proceed! ");
					if(name.isEmpty())
						nameTextField.setBackground(Color.red);
					if(timeDistance == 0)
						timeDistanceTextField.setBackground(Color.red);
					if(telephoneNum.isEmpty())
						telephoneNumTextField.setBackground(Color.red);
					if(email.isEmpty())
						emailTextField.setBackground(Color.red);
					if(address.isEmpty())
						addressTextField.setBackground(Color.red);
					
				if(rowData == null && (clientUsername.isEmpty() || clientPassword.isEmpty())) { //check for emptynes of client's textFields only if it is an addRestaurant process
					messageLabel.setForeground(Color.red);
					messageLabel.setText("You must fill all the blanks in order to proceed! ");
					if(clientUsername.isEmpty())
						textFieldClientUsername.setBackground(Color.red);
					if(clientPassword.isEmpty())
						textFieldClientPassword.setBackground(Color.red);
				}
				}else if(!(StringUtils.isNumeric(timeDistanceTextField.getText().trim()))){
					timeDistanceTextField.setBackground(Color.red);
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Unexpected entry in Time Distance. Entry must be numeric! ");
				}else {
					if (rowData != null) { //If it is an edit !
						data.deleteRestaurant(ID);
					}
					Database.addClient(new Client(clientUsername, clientPassword, subscriptionDate, ID));
					data.addRestaurant(new Restaurant(ID, name, address, telephoneNum, email, timeDistance, comments));
					
					frame.dispose();
					Restaurants_Screen restaurantScreen = new Restaurants_Screen(data,GuiManagement.getLatestFrameLocationCoordinates(frame));
					try {
						restaurantScreen.toRestaurantScreen(data,GuiManagement.getLatestFrameLocationCoordinates(frame));
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}	
			}
		});
		
		nameTextField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
			    nameTextField.setBackground(Color.white);
			    timeDistanceTextField.setBackground(Color.white);
			    telephoneNumTextField.setBackground(Color.WHITE);
			    emailTextField.setBackground(Color.WHITE);
			    addressTextField.setBackground(Color.white);
			    messageLabel.setText("");
			  }
			});
		timeDistanceTextField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  nameTextField.setBackground(Color.white);
				    timeDistanceTextField.setBackground(Color.white);
				    telephoneNumTextField.setBackground(Color.WHITE);
				    emailTextField.setBackground(Color.WHITE);
				    addressTextField.setBackground(Color.white);
				    messageLabel.setText("");
			  }
			});
		
		telephoneNumTextField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  nameTextField.setBackground(Color.white);
				    timeDistanceTextField.setBackground(Color.white);
				    telephoneNumTextField.setBackground(Color.WHITE);
				    emailTextField.setBackground(Color.WHITE);
				    addressTextField.setBackground(Color.white);
				    messageLabel.setText("");
			  }
			});
		
		emailTextField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  nameTextField.setBackground(Color.white);
				    timeDistanceTextField.setBackground(Color.white);
				    telephoneNumTextField.setBackground(Color.WHITE);
				    emailTextField.setBackground(Color.WHITE);
				    addressTextField.setBackground(Color.white);
				    messageLabel.setText("");
			  }
			});
		
		addressTextField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  nameTextField.setBackground(Color.white);
				    timeDistanceTextField.setBackground(Color.white);
				    telephoneNumTextField.setBackground(Color.WHITE);
				    emailTextField.setBackground(Color.WHITE);
				    addressTextField.setBackground(Color.white);
				    messageLabel.setText("");
			  }
			});
		
		
		
		btnApply.setBounds(503, 401, 89, 23);
		frame.getContentPane().add(btnApply);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Restaurants_Screen restScreen = new Restaurants_Screen(data,GuiManagement.getLatestFrameLocationCoordinates(frame));
				try {
					restScreen.toRestaurantScreen(data,aFrameLocation);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnCancel.setBounds(37, 401, 89, 23);
		frame.getContentPane().add(btnCancel);
	
		frame.setBounds(100, 100, 641, 480);
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
