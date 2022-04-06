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
	private JLabel logOutLabel;

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
		frame.getContentPane().setBackground(new Color(165, 42, 42));
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
		headTitleLabel.setBounds(75, 17, 255, 64);
		headTitleLabel.setFont(new Font("SimSun", Font.BOLD | Font.ITALIC, 20));
		headTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(headTitleLabel);

        
			    
//////////////////////Menu's labels set and modification //////////////////////////////
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
		
		JLabel restaurantsLabel = new JLabel("Restaurants");
		restaurantsLabel.setForeground(Color.WHITE);
		restaurantsLabel.setFont(new Font("SimSun", Font.PLAIN, 18));
		restaurantsLabel.setBounds(261, 163, 140, 21);
		restaurantsLabel.addMouseListener(new MouseListener() {
		
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				restaurantsBtn.doClick();
				
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
		
		frame.getContentPane().add(restaurantsLabel);
		
		JLabel ordersLabel = new JLabel("Orders");
		ordersLabel.setForeground(Color.WHITE);
		ordersLabel.setFont(new Font("SimSun", Font.PLAIN, 18));
		ordersLabel.setBounds(39, 291, 140, 21);
		ordersLabel.addMouseListener(new MouseListener() {
		
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ordersBtn.doClick();
				
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
		
		frame.getContentPane().add(ordersLabel);
		
		JLabel staffLabel = new JLabel("Staff");
		staffLabel.setForeground(Color.WHITE);
		staffLabel.setFont(new Font("SimSun", Font.PLAIN, 18));
		staffLabel.setBounds(271, 291, 140, 21);
		staffLabel.addMouseListener(new MouseListener() {
		
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				stuffBtn.doClick();
				
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
		
		frame.getContentPane().add(staffLabel);
		
		JLabel StatisticsLabel = new JLabel("Statistics");
		StatisticsLabel.setForeground(Color.WHITE);
		StatisticsLabel.setFont(new Font("SimSun", Font.PLAIN, 18));
		StatisticsLabel.setBounds(27, 381, 140, 21);
		StatisticsLabel.addMouseListener(new MouseListener() {
		
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				statisticsBtn.doClick();
				
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
		
		frame.getContentPane().add(StatisticsLabel);
		
		JLabel VehiclesLabel = new JLabel("Vehicles");
		VehiclesLabel.setForeground(Color.WHITE);
		VehiclesLabel.setFont(new Font("SimSun", Font.PLAIN, 18));
		VehiclesLabel.setBounds(281, 381, 130, 21);
		VehiclesLabel.addMouseListener(new MouseListener() {
		
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				vehiclesBtn.doClick();
				
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
		
		frame.getContentPane().add(VehiclesLabel);
		
		logOutLabel = new JLabel("Log Out");
		logOutLabel.setForeground(Color.WHITE);
		logOutLabel.setFont(new Font("SimSun", Font.PLAIN, 18));
		logOutLabel.setBounds(185, 436, 106, 21);
		logOutLabel.addMouseListener(new MouseListener() {
		
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				logOutBtn.doClick();
				
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
		
		frame.getContentPane().add(logOutLabel);

		//////////////////////Menu's labels set and modification - END//////////////////////////////

		
		//////////////////////button set and customization code //////////////////////////////
		
		currentStatusBtn = new JButton("");
		
		/////////// button's icon set and customization ///////////
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
		/////////// button's icon set and customization ///////////   
	    
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
		
		restaurantsBtn = new JButton("");
		restaurantsBtn.setBounds(250, 92, 126, 47);
		
		/////////// button's icon set and customization ///////////
		URL urlRestaurants = this.getClass().getResource("restaurantsIcon.png");
		//Icon iconRestaurants = new ImageIcon(urlRestaurants);
		ImageIcon iconRestaurants = new ImageIcon(urlRestaurants);
        Image imgRestaurants = iconRestaurants.getImage();
        Image newImgTRestaurants = imgRestaurants.getScaledInstance(70, 70, java.awt.Image.SCALE_DEFAULT);
        iconRestaurants = new ImageIcon(newImgTRestaurants);       
		restaurantsBtn.setIcon(iconRestaurants);
		restaurantsBtn.setPreferredSize(new Dimension(50, 50));
		restaurantsBtn.setMaximumSize(new Dimension(10, 10));
		restaurantsBtn.setFocusPainted(false);
		restaurantsBtn.setRolloverEnabled(false);
		restaurantsBtn.setOpaque(false);
	    restaurantsBtn.setContentAreaFilled(false);
	    restaurantsBtn.setBorderPainted(false);
	    /////////// button's icon set and customization ///////////
	    
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
		
		ordersBtn = new JButton("");
		ordersBtn.setBounds(39, 222, 126, 47);
		frame.getContentPane().add(ordersBtn);
		
		
		/////////// button's icon set and customization ///////////
		URL urlOrders = this.getClass().getResource("ordersIcon.png");
		//Icon iconOrders = new ImageIcon(urlOrders);
		ImageIcon iconOrders = new ImageIcon(urlOrders);
      	Image imgOrders = iconOrders.getImage();
      	Image newImgTOrders = imgOrders.getScaledInstance(70, 70, java.awt.Image.SCALE_DEFAULT);
      	iconOrders = new ImageIcon(newImgTOrders);       
		ordersBtn.setIcon(iconOrders);
		ordersBtn.setPreferredSize(new Dimension(50, 50));
		ordersBtn.setMaximumSize(new Dimension(10, 10));
		ordersBtn.setFocusPainted(false);
		ordersBtn.setRolloverEnabled(false);
		ordersBtn.setOpaque(false);
	    ordersBtn.setContentAreaFilled(false);
	    ordersBtn.setBorderPainted(false);
	    /////////// button's icon set and customization ///////////
		
		
		stuffBtn = new JButton("");
		stuffBtn.setBounds(260, 205, 126, 75);
		
		/////////// button's icon set and customization ///////////
		URL urlStuff = this.getClass().getResource("ridersIcon.png");
		//Icon iconStuff = new ImageIcon(urlStuff);
		ImageIcon iconStuff = new ImageIcon(urlStuff);
        Image imgStuff = iconStuff.getImage();
        Image newImgTStuff = imgStuff.getScaledInstance(70, 70, java.awt.Image.SCALE_DEFAULT);
        iconStuff = new ImageIcon(newImgTStuff);       
		stuffBtn.setIcon(iconStuff);
		stuffBtn.setPreferredSize(new Dimension(50, 50));
		stuffBtn.setMaximumSize(new Dimension(10, 10));
		stuffBtn.setFocusPainted(false);
		stuffBtn.setRolloverEnabled(false);
		stuffBtn.setOpaque(false);
	    stuffBtn.setContentAreaFilled(false);
	    stuffBtn.setBorderPainted(false);
	    /////////// button's icon set and customization ///////////
		
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
		vehiclesBtn.setBounds(260, 323, 126, 47);
		
		////////// button's icon set and customization ///////////
		URL urlVehicles = this.getClass().getResource("vehiclesIcon.png");
		//Icon iconVehicles = new ImageIcon(urlVehicles);
		ImageIcon iconVehicles = new ImageIcon(urlVehicles);
      	Image imgVehicles = iconVehicles.getImage();
      	Image newImgTVehicles = imgVehicles.getScaledInstance(70, 70, java.awt.Image.SCALE_DEFAULT);
      	iconVehicles = new ImageIcon(newImgTVehicles);       
		vehiclesBtn.setIcon(iconVehicles);
		vehiclesBtn.setPreferredSize(new Dimension(50, 50));
		vehiclesBtn.setMaximumSize(new Dimension(10, 10));
		vehiclesBtn.setFocusPainted(false);
		vehiclesBtn.setRolloverEnabled(false);
		vehiclesBtn.setOpaque(false);
	    vehiclesBtn.setContentAreaFilled(false);
	    vehiclesBtn.setBorderPainted(false);
	    /////////// button's icon set and customization //////////
		
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
		
		statisticsBtn = new JButton("");
		statisticsBtn.setBounds(39, 323, 126, 47);
		frame.getContentPane().add(statisticsBtn);
		
		/////////// button's icon set and customization ///////////
		URL urlStatistics = this.getClass().getResource("ordersIcon.png");
		//Icon iconStatistics = new ImageIcon(urlStatistics);
		ImageIcon iconStatistics = new ImageIcon(urlStatistics);
      	Image imgStatistics = iconStatistics.getImage();
      	Image newImgTStatistics = imgStatistics.getScaledInstance(70, 70, java.awt.Image.SCALE_DEFAULT);
      	iconStatistics = new ImageIcon(newImgTStatistics);       
		statisticsBtn.setIcon(iconStatistics);
		statisticsBtn.setPreferredSize(new Dimension(50, 50));
		statisticsBtn.setMaximumSize(new Dimension(10, 10));
		statisticsBtn.setFocusPainted(false);
		statisticsBtn.setRolloverEnabled(false);
		statisticsBtn.setOpaque(false);
	    statisticsBtn.setContentAreaFilled(false);
	    statisticsBtn.setBorderPainted(false);
	    /////////// button's icon set and customization ///////////
		
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
		
		logOutBtn = new JButton("");
		logOutBtn.setBounds(156, 391, 106, 44);
		
		/////////// button's icon set and customization ///////////
		URL urlLogOut = this.getClass().getResource("logOutIcon.png");
		//Icon iconLogOut = new ImageIcon(urlLogOut);
		ImageIcon iconLogOut = new ImageIcon(urlLogOut);
      	Image imgLogOut = iconLogOut.getImage();
      	Image newImgTLogOut = imgLogOut.getScaledInstance(40, 40, java.awt.Image.SCALE_DEFAULT);
      	iconLogOut = new ImageIcon(newImgTLogOut);       
		logOutBtn.setIcon(iconLogOut);
		logOutBtn.setPreferredSize(new Dimension(50, 50));
		logOutBtn.setMaximumSize(new Dimension(10, 10));
		logOutBtn.setFocusPainted(false);
		logOutBtn.setRolloverEnabled(false);
		logOutBtn.setOpaque(false);
	    logOutBtn.setContentAreaFilled(false);
	    logOutBtn.setBorderPainted(false);
	    /////////// button's icon set and customization ///////////
		
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
