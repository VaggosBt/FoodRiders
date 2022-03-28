package MainMenu_Screen_Package;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;

import Handler_Package.Current_Status;
import Handler_Package.GuiManagement;
import Handler_Package.Handler;
import Login_Screen_Package.Login_Screen;
import Restaurants_Screen_Package.Restaurants_Screen;
import Staff_Screen_Package.Staff_Screen;
// import Statistics.StatisticsGUI;
import Statistics.StatisticsGUI;
import Vehicles_Screen_Package.Vehicles_Screen;
import java.awt.Color;

public class MainMenu {

	private JFrame frame;
	private Point frameLocation;
	
	private JLabel headTitleLabel;
	
	private JButton currentStatusBtn;
	private JButton restaurantsBtn;
	private JButton ordersBtn;
	private JButton stuffBtn;
	private JButton vehiclesBtn;
	private JButton statisticsBtn;
	private JButton logOutBtn;
	
	
	private  JLabel currentStatusLabel;
	
	private Current_Status lockedWindow = null;

	/**
	 * Launch the application.
	 */
	public void showMainMenu(Handler aData, Point aFrameLocation) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu(aData, aFrameLocation);
					window.setLockedWindow(lockedWindow);
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
	/**
	 * @wbp.parser.constructor
	 */

	public MainMenu(Handler aData, Point aFrameLocation) {
		initialize(aData, aFrameLocation);
	}
 
	
	/**
	 * Initialize the contents of the frame.
	 * @param db 
	 */
	
	
	
	private void initialize(Handler aData, Point aFrameLocation) {
		
		Handler data = aData;
		frameLocation = aFrameLocation; 
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBackground(SystemColor.textHighlight);
		frame.setResizable(false);
		frame.setTitle("Food Riders");
		frame.setBounds(100, 100, 425, 494);
		frame.setLocation(frameLocation);
		
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
		frame.getContentPane().setLayout(null);
		
		headTitleLabel = new JLabel("Administration Mode");
		headTitleLabel.setBounds(110, 11, 200, 64);
		headTitleLabel.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 20));
		headTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(headTitleLabel);
	
        
		currentStatusBtn = new JButton("");
		/////////////////////////////////////////////////////////////////
		URL url = this.getClass().getResource("statusIcon.gif");
		//Icon icon = new ImageIcon(url);
		ImageIcon icon = new ImageIcon(url);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(70, 70, java.awt.Image.SCALE_DEFAULT);
        icon = new ImageIcon(newImg);
        
		currentStatusBtn.setIcon(icon);
		currentStatusBtn.setPreferredSize(new Dimension(50, 50));
		currentStatusBtn.setMaximumSize(new Dimension(10, 10));
		currentStatusBtn.setFocusPainted(false);
		currentStatusBtn.setRolloverEnabled(false);
		currentStatusBtn.setOpaque(false);
	    currentStatusBtn.setContentAreaFilled(false);
	    currentStatusBtn.setBorderPainted(false);
		
	    currentStatusLabel = new JLabel("Current Status");
		currentStatusLabel.setFont(new Font("SimSun", Font.PLAIN, 18));
		currentStatusLabel.setForeground(Color.WHITE);
		currentStatusLabel.setBounds(49, 163, 140, 21);
		currentStatusLabel.addMouseListener(new MouseListener() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				currentStatusBtn.doClick();
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
	
			}
			@Override
			public void mouseExited(MouseEvent e) {
	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
	
			}
		});
		
		frame.getContentPane().add(currentStatusLabel);
		

		/////////////////////////////////////////////////////////////////
	    
	    
		currentStatusBtn.setBounds(39, 64, 140, 88);
		currentStatusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				if(!(lockedWindow == null)) {    //an to lockedWindow DEN einai null, tote ayto shmainei oti yparxei hdh ena Current Status window hdh anoixto, 
					lockedWindow.getFocus();     //opote se periptvsw epistrofhs sto currentStatus apo to menu, den anoigei deytero, alla pairnei to focus xana to hdh anoixto
					lockedWindow.revealHomeButtonAgain();
					System.out.println("Not null");  
				}else {
					Current_Status curr_stat = new Current_Status(data, GuiManagement.getLatestFrameLocationCoordinates(frame)); //se antitheth periptwsh, anoigei ena neo gui se neo thread
					Thread t1 = new Thread(curr_stat);
					t1.start();
				}
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 0, 0, 0);
		frame.getContentPane().add(separator);
		frame.getContentPane().add(currentStatusBtn);
		
		restaurantsBtn = new JButton("Restaurants");
		restaurantsBtn.setBounds(250, 92, 126, 47);
		restaurantsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Restaurants_Screen restaurants = new Restaurants_Screen(data,GuiManagement.getLatestFrameLocationCoordinates(frame));
				try {
					restaurants.toRestaurantScreen(data,GuiManagement.getLatestFrameLocationCoordinates(frame));
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		frame.getContentPane().add(restaurantsBtn);
		
		ordersBtn = new JButton("Orders");
		ordersBtn.setBounds(39, 222, 126, 47);
		frame.getContentPane().add(ordersBtn);
		
		stuffBtn = new JButton("Staff");
		stuffBtn.setBounds(250, 222, 126, 47);
		stuffBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Staff_Screen staffScreen = new Staff_Screen(data,frameLocation);
				try {
					staffScreen.toStaffScreen(data,GuiManagement.getLatestFrameLocationCoordinates(frame));
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(stuffBtn);
		
		vehiclesBtn = new JButton("Vehicles");
		vehiclesBtn.setBounds(250, 323, 126, 47);
		vehiclesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Vehicles_Screen vehiclesScreen = new Vehicles_Screen(data,frameLocation);
				try {
					vehiclesScreen.toVehiclesScreen(data,aFrameLocation);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(vehiclesBtn);
		
		statisticsBtn = new JButton("Statistics");
		statisticsBtn.setBounds(39, 323, 126, 47);
		frame.getContentPane().add(statisticsBtn);
		statisticsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				StatisticsGUI statisticsScreen = new StatisticsGUI(data,frameLocation);	
				statisticsScreen.toStatisticsScreen(data,frameLocation);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});   
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 0, 0, 0);
		frame.getContentPane().add(separator_1);
		
		logOutBtn = new JButton("Log out");
		logOutBtn.setBounds(157, 411, 106, 44);
		logOutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Login_Screen loginScreen;
				try {
					loginScreen = new Login_Screen(data,GuiManagement.getLatestFrameLocationCoordinates(frame));
					try {
						URL url = getClass().getResource("/MainMenu_Screen_Package/skypeLogOutSound.wav");
						AudioClip clip = Applet.newAudioClip(url);
						clip.play();
						loginScreen.showLoginScreen(data,GuiManagement.getLatestFrameLocationCoordinates(frame));
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				
			}
		});
		frame.getContentPane().add(logOutBtn);
		
		
	}

	public Current_Status getLockedWindow() {
		return lockedWindow;
	}
	public void setLockedWindow(Current_Status aLockedWindow) {
		lockedWindow = aLockedWindow;
	}
}
