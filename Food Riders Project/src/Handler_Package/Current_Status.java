package Handler_Package;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import MainMenu_Screen_Package.MainMenu;


public class Current_Status implements Runnable {

	private JFrame frame;
	private Point frameLocation;
	
	private JLabel runningOrders;
	private JLabel ordersInQueue; 
	private JLabel totalVehicles;
	private JLabel vehiclesAvailable;
	private JLabel totalStuffNumber;
	private JLabel stuffAvailable;
	private JLabel MoneyIn;
	private JLabel MoneyOut;
	
	private JCheckBox lockCheckBox;
	JButton btnMainMenu ;
	ImageIcon menuImg ;
	
	private Handler data;
	
	
	
	
	
	public Current_Status(Handler aData, Point aFrameLocation) {
		
		data = aData;
		frameLocation = aFrameLocation;
	}
	
	
		public void run() {
			try {
					initialize(data, frameLocation);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
	
	
	
		/**
		 * @wbp.parser.entryPoint
		 */
	private void initialize(Handler aData, Point aFrameLocation) {
		data = aData;
		Current_Status lockedWindow = this;
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.getContentPane().setLayout(null);
		
		JLabel CurrentStatusLbl = new JLabel("Current Business Status");
		CurrentStatusLbl.setForeground(SystemColor.controlText);
		CurrentStatusLbl.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		CurrentStatusLbl.setBounds(145, 11, 218, 52);
		frame.getContentPane().add(CurrentStatusLbl);
		
		JLabel runningOrdersLabel = new JLabel("Running orders :");
		runningOrdersLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		runningOrdersLabel.setForeground(SystemColor.text);
		runningOrdersLabel.setBounds(51, 117, 123, 14);
		frame.getContentPane().add(runningOrdersLabel);
		
		JLabel ordersComplLabel = new JLabel("Orders in queue :");
		ordersComplLabel.setForeground(SystemColor.text);
		ordersComplLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		ordersComplLabel.setBounds(284, 117, 128, 14);
		frame.getContentPane().add(ordersComplLabel);
		
		JLabel totalVehiclesLabel = new JLabel("Total vehicles :");
		totalVehiclesLabel.setForeground(SystemColor.text);
		totalVehiclesLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		totalVehiclesLabel.setBounds(54, 192, 120, 14);
		frame.getContentPane().add(totalVehiclesLabel);
		
		JLabel vehiclesAvailableLabel = new JLabel("Vehicles available : ");
		vehiclesAvailableLabel.setForeground(SystemColor.text);
		vehiclesAvailableLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		vehiclesAvailableLabel.setBounds(284, 193, 144, 12);
		frame.getContentPane().add(vehiclesAvailableLabel);
		
		JLabel totalStaffNumLabel = new JLabel("Total staff number :");
		totalStaffNumLabel.setForeground(SystemColor.text);
		totalStaffNumLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		totalStaffNumLabel.setBounds(37, 274, 156, 14);
		frame.getContentPane().add(totalStaffNumLabel);
		
		JLabel staffAvailableLabel = new JLabel("Staff available :");
		staffAvailableLabel.setForeground(SystemColor.text);
		staffAvailableLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		staffAvailableLabel.setBounds(292, 274, 112, 14);
		frame.getContentPane().add(staffAvailableLabel);
		
		JLabel moneyInLabel = new JLabel("Money In :");
		moneyInLabel.setForeground(SystemColor.text);
		moneyInLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		moneyInLabel.setBounds(69, 351, 92, 12);
		frame.getContentPane().add(moneyInLabel);
		
		JLabel moneyOutLabel = new JLabel("Money Out :");
		moneyOutLabel.setForeground(SystemColor.text);
		moneyOutLabel.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		moneyOutLabel.setBounds(302, 350, 103, 14);
		frame.getContentPane().add(moneyOutLabel);
		
		runningOrders = new JLabel(String.valueOf(data.getRunningOrders().size()));
		runningOrders.setForeground(SystemColor.text);
		runningOrders.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		runningOrders.setBounds(184, 117, 46, 14);
		frame.getContentPane().add(runningOrders);
		
		ordersInQueue = new JLabel(String.valueOf(data.getOrdersInQueue().size()));
		ordersInQueue.setForeground(SystemColor.text);
		ordersInQueue.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		ordersInQueue.setBounds(422, 117, 46, 14);
		frame.getContentPane().add(ordersInQueue);
		
		totalVehicles = new JLabel(String.valueOf(data.getVehicles().size()));
		totalVehicles.setForeground(SystemColor.text);
		totalVehicles.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		totalVehicles.setBounds(177, 194, 53, 14);
		frame.getContentPane().add(totalVehicles);
		
		vehiclesAvailable = new JLabel(String.valueOf(data.getVehiclesAvailable().size()));
		vehiclesAvailable.setForeground(SystemColor.text);
		vehiclesAvailable.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		vehiclesAvailable.setBounds(433, 192, 53, 19);
		frame.getContentPane().add(vehiclesAvailable);
		
		totalStuffNumber = new JLabel(String.valueOf(data.getStaffList().size()));
		totalStuffNumber.setForeground(SystemColor.text);
		totalStuffNumber.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		totalStuffNumber.setBounds(192, 276, 46, 14);
		frame.getContentPane().add(totalStuffNumber);
		
		stuffAvailable = new JLabel(String.valueOf(data.getStaffAvailable().size()));
		stuffAvailable.setForeground(SystemColor.text);
		stuffAvailable.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		stuffAvailable.setBounds(412, 276, 46, 14);
		frame.getContentPane().add(stuffAvailable);
		
		MoneyIn = new JLabel("");
		MoneyIn.setBounds(154, 352, 46, 14);
		frame.getContentPane().add(MoneyIn);
		
		MoneyOut = new JLabel("");
		MoneyOut.setBounds(396, 352, 46, 14);
		frame.getContentPane().add(MoneyOut);
		
		lockCheckBox = new JCheckBox("Remain Open");
		lockCheckBox.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		lockCheckBox.setBackground(SystemColor.textHighlight);
		lockCheckBox.setForeground(SystemColor.text);
		lockCheckBox.setBounds(315, 402, 127, 23);
		frame.getContentPane().add(lockCheckBox);
		
		
		btnMainMenu = new JButton("");
		menuImg = new ImageIcon(this.getClass().getResource("/App_icons_and_images/home.png"));
		btnMainMenu.setIcon(menuImg);
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!(lockCheckBox.isSelected())) {
					frame.dispose();
					MainMenu mainMenu = new MainMenu(data,GuiManagement.getLatestFrameLocationCoordinates(frame));
					mainMenu.showMainMenu(data,GuiManagement.getLatestFrameLocationCoordinates(frame));
				}else {
					MainMenu mainMenu = new MainMenu(data,GuiManagement.getLatestFrameLocationCoordinates(frame));
					mainMenu.setLockedWindow(lockedWindow);
					data.setLockedWindow(lockedWindow);
					mainMenu.showMainMenu(data,GuiManagement.getLatestFrameLocationCoordinates(frame));
					frame.setLocation(GuiManagement.moveFrameOnXAxis(frame, 500));  	
				
			        btnMainMenu.setVisible(false);
			        lockCheckBox.setVisible(false);
			        
			        WindowListener exitListener = new WindowAdapter() {

			            @Override
			            public void windowClosing(WindowEvent e) {    
			               data.setLockedWindow(null);
			               Frame[] jframes = JFrame.getFrames();
			               for(Frame aFrame : jframes) {
			            	   aFrame.dispose();
			               }
			               MainMenu mainMenu = new MainMenu(data,frameLocation);
							mainMenu.showMainMenu(data,frameLocation);
			            }
			        };
			        frame.addWindowListener(exitListener);
			        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
				
				}		
			}
		});
		
		
		
		btnMainMenu.setBounds(196, 382, 64, 60);
		
		frame.getContentPane().add(btnMainMenu);
		frame.setBounds(100, 100, 512, 491);
		frame.setLocation(frameLocation);
		
		WindowListener exitListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	if(!lockCheckBox.isSelected()) {
	            	if (JOptionPane.showConfirmDialog(null, "Are You Sure to Close Application?", "WARNING",
	            	        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
	            	    System.exit(0);
	            	} else {
	            	    // no option
	            	}
            	}
            }
        };
        
        //updateTimer on Current status values
        TimerTask updateStatus = new TimerTask() {
			@Override
			public void run() {
				upDateCurrentStatus();				
			}		
		};
		Timer timer = new Timer(); 	
		
		timer.schedule(updateStatus, 01, 1000);
		
        frame.addWindowListener(exitListener);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	public void upDateCurrentStatus() {
		runningOrders.setText((String.valueOf(data.getRunningOrders().size())));
		ordersInQueue.setText((String.valueOf(data.getOrdersInQueue().size())));
		totalVehicles.setText((String.valueOf(data.getVehicles().size())));
		vehiclesAvailable.setText((String.valueOf(data.getVehiclesAvailable().size())));
		totalStuffNumber.setText((String.valueOf(data.getStaffList().size())));
		stuffAvailable.setText((String.valueOf(data.getStaffAvailable().size())));
		MoneyIn.setText(" " );
		MoneyOut.setText(" ");
		System.out.println("Current Status values have been updated successfully!");
		System.out.println(("New totalStuff: " + String.valueOf(data.getStaffList().size())));
		System.out.println("New total Vehicles number: " + String.valueOf(data.getVehicles().size()));
		
	}
	
	public void revealHomeButtonAgain() {
		 btnMainMenu.setVisible(true);
	     lockCheckBox.setVisible(true);
	}
	
	
	public boolean isDisplayable() {
		if(frame.isVisible()){
			return true;
		
		}else {
			return false;
		}
	}

	public void getFocus() {
		frame.requestFocus();
	}
	
}

