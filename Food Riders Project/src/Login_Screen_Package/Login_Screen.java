package Login_Screen_Package;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;

import Client_Package.Client_Screen;
import Handler_Package.GuiManagement;
import Handler_Package.Handler;
import MainMenu_Screen_Package.MainMenu;


public class Login_Screen implements GuiManagement {

	private JFrame frame;
      //Frame's location 
	
	private JTextField username_textField;
	private JPasswordField passwordField;
	
	private JButton login_btn;

	/**
	 * Launch the application.
	 * @param aFrameLocation 
	 */
	public void showLoginScreen(Handler aData, Point aFrameLocation) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		//UIManager.put("OptionPane.background",new ColorUIResource(165,42,42));
		//UIManager.put("Panel.background",new ColorUIResource(165,42,42));
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Screen window = new Login_Screen(aData,aFrameLocation);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param aFrameLocation 
	 * @param db 
	 * @throws MalformedURLException 
	 */
	public Login_Screen(Handler aData, Point aFrameLocation) throws MalformedURLException {
		initialize(aData,aFrameLocation);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param db 
	 * @param db 
	 * @throws MalformedURLException 
	 */
	private void initialize(Handler aData, Point aFrameLocation) throws MalformedURLException {
		
		Handler data = aData;
		
		frame = new JFrame();

		
		frame.getContentPane().setBackground(new Color(165, 42, 42));
		frame.getContentPane().setLayout(null);
		
		JLabel title_label = new JLabel("FoodRiders");
		title_label.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 30));
		title_label.setBounds(109, 44, 173, 40);
		frame.getContentPane().add(title_label);
		
		JLabel username_label = new JLabel("Username : ");
		username_label.setForeground(Color.WHITE);
		username_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		username_label.setBounds(146, 115, 88, 29);
		frame.getContentPane().add(username_label);
		
		username_textField = new JTextField();
		username_textField.setBounds(126, 154, 130, 20);
		frame.getContentPane().add(username_textField);
		username_textField.setColumns(10);
		
		JLabel password_label = new JLabel("Password :");
		password_label.setForeground(Color.WHITE);
		password_label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password_label.setBounds(156, 192, 78, 29);
		frame.getContentPane().add(password_label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(126, 232, 130, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel message_label = new JLabel("");
		message_label.setBackground(new Color(165, 42, 42));
		message_label.setForeground(new Color(0, 0, 0));
		message_label.setBounds(10, 263, 367, 45);
		frame.getContentPane().add(message_label);
		
		login_btn = new JButton("Login");
		login_btn.setBounds(145, 319, 89, 23);
		frame.getContentPane().add(login_btn);
		
		
		URL url = this.getClass().getResource("ghostRider.gif");
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);
		label.setBounds(-30, 132, 456, 355);
		frame.getContentPane().add(label);
		
		frame.getRootPane().setDefaultButton(login_btn); // Allowing the â€œEnterâ€� key to press the login button
		
		//ActionListeners 
		
		
		
		login_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = username_textField.getText().trim();
				String password = String.valueOf(passwordField.getPassword());
				
				if(username.isEmpty() || password.isEmpty()) {
					message_label.setForeground(Color.red);
					message_label.setText("You must fill all the blanks in order to proceed! ");
					if(username.isEmpty())
						username_textField.setBackground(Color.red);
					if(password.isEmpty())
						passwordField.setBackground(Color.red);
						
				
				}else if(Database.checkData(username, password)) {
						
					
					if(Database.getLoginType()==1) {
						frame.dispose();
						MainMenu mainMenu = new MainMenu(data, GuiManagement.getLatestFrameLocationCoordinates(frame));
						URL url = getClass().getResource("/Login_Screen_Package/LogInSound.wav");
						AudioClip clip = Applet.newAudioClip(url);
						clip.play();
						mainMenu.showMainMenu(data, GuiManagement.getLatestFrameLocationCoordinates(frame));
					}else if(Database.getLoginType()==2) {
						frame.dispose();
						
						if (Database.findClientByUsername(username) != null){
							try {
								Client_Screen clientScreen = new Client_Screen(data, Database.findClientByUsername(username));
								clientScreen.showClientScreen(data,Database.findClientByUsername(username));
							} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
									| UnsupportedLookAndFeelException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}else{
							message_label.setForeground(Color.red);
							message_label.setText("Something went wrong!");
						}
						
						URL url = getClass().getResource("/Login_Screen_Package/LogInSound.wav");
						AudioClip clip = Applet.newAudioClip(url);
						clip.play();
					}else {
						message_label.setText("An error has been occurred with your account. Please contact us for more information. ");
					}
						
				
				
				}else {
					message_label.setForeground(Color.red);
					message_label.setText("Incorrect username or password.Please check your details and try again!");
				}
				
				
			}
		});
		
		username_textField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
			    username_textField.setBackground(Color.white);
			    passwordField.setBackground(Color.white);
			    message_label.setText("");
			  }
			});
		passwordField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
			    username_textField.setBackground(Color.white);
			    passwordField.setBackground(Color.white);
			    message_label.setText("");
			  }
			});
		
	
		
		frame.setBounds(100, 100, 403, 450);
		frame.setLocation(aFrameLocation);
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
