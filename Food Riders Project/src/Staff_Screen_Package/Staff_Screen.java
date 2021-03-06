package Staff_Screen_Package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import Handler_Package.GuiManagement;
import Handler_Package.Handler;
import Handler_Package.Staff;
import MainMenu_Screen_Package.MainMenu;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;
import java.awt.Color;

public class Staff_Screen {

	private JFrame frame;
	
	private JButton addBtn;
	private JButton btnEpeksergasia ;
	private JButton btnDiagrafi;

	
	/**
	 * Launch the application.
	 */
	public void toStaffScreen(Handler aData, Point aFrameLocation) throws ClassNotFoundException, InstantiationException, IllegalAccessException, 
												UnsupportedLookAndFeelException {
		Handler data = aData;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff_Screen window = new Staff_Screen(data,aFrameLocation);
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
	 */
	public Staff_Screen(Handler aData, Point aFrameLocation) {
		initialize(aData,aFrameLocation);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Handler aData, Point aFrameLocation) {
		
		Handler data = aData;
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(165, 42, 42));
		frame.setBounds(100, 100, 750, 405);
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Staff - FoodRiders");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 66, 700, 164);
		frame.getContentPane().add(scrollPane);
		
		//Filling up the JTable
		ArrayList<Staff> staffList = new ArrayList<>();
		staffList = data.getStaffList();
		
		String col[] = {"ID","Name","Position","Birth Date","Recruitment Date" ,"Telephone Number"};	
		
		DefaultTableModel model = new DefaultTableModel(col, 0) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false (non editable cells by double-clicking on them)
		       return false;
		    }
		};
		JTable table = new JTable(model);
		
		for(int i = 0 ; i < staffList.size(); i++) {
			System.out.println(staffList.get(i).getPosition());
			System.out.println(staffList.get(i).getRecruitmentDate());
			System.out.println(i);
			model.addRow(new Object[]{staffList.get(i).getId(),staffList.get(i).getName(),staffList.get(i).getPosition(),
									  staffList.get(i).getDateOfBirth(),staffList.get(i).getRecruitmentDate(),
									  staffList.get(i).getTelephoneNumber()});
		}
		scrollPane.setViewportView(table);
		
		//Buttons
		addBtn = new JButton("Add");
		addBtn.setBounds(25, 250, 153, 25);
		frame.getContentPane().add(addBtn);
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStaffScreen addStaffScreen  =  new AddStaffScreen(data,GuiManagement.getLatestFrameLocationCoordinates(frame), null);
				frame.dispose();
				addStaffScreen.addStaff(data,GuiManagement.getLatestFrameLocationCoordinates(frame),null);
				
			}
		});
		
		btnDiagrafi = new JButton("Delete");
		btnDiagrafi.setBounds(572, 250, 153, 25);
		frame.getContentPane().add(btnDiagrafi);
		
		btnDiagrafi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 0; //ID column
				int row = table.getSelectedRow();
				int id = -1;
				if(!table.getSelectionModel().isSelectionEmpty()) {
					int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + table.getModel().getValueAt(row, 1), "Delete?",  JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						id = (int) table.getModel().getValueAt(row, column);
						if(!data.deleteStaff(id)) { //IF this staff member is unavailable
							JOptionPane.showMessageDialog(frame, "Sorry, this staff member is currently on the road.");
						}else {
							((DefaultTableModel)table.getModel()).removeRow(row);
						}
						
					}
				}
			}
		});
		
		btnEpeksergasia = new JButton("Edit");
		btnEpeksergasia.setBounds(306, 250, 161, 25);
		frame.getContentPane().add(btnEpeksergasia);
		btnEpeksergasia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				//pass in addStaffScreen the data of the selected row
				
				if(!table.getSelectionModel().isSelectionEmpty()) {
					Staff rowData = new Staff((int) table.getModel().getValueAt(row,  0),  //ID
											(String) table.getModel().getValueAt(row, 1), //NAME
											(String) table.getModel().getValueAt(row, 2), //POSITION
											(String) table.getModel().getValueAt(row, 3), //DATE OF BIRTHE
											(String) table.getModel().getValueAt(row, 4),
											(String) table.getModel().getValueAt(row, 5));//RECRUITMENT DATE
					AddStaffScreen addStaffScreen  =  new AddStaffScreen(data,GuiManagement.getLatestFrameLocationCoordinates(frame),rowData);
					frame.dispose();
					addStaffScreen.addStaff(data,GuiManagement.getLatestFrameLocationCoordinates(frame),rowData);
				}
				
			}
		});
		
		JButton button = new JButton("");
		ImageIcon menuImg = new ImageIcon(this.getClass().getResource("/App_icons_and_images/home.png"));
		button.setIcon(menuImg);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainMenu mainMenu = new MainMenu(data,GuiManagement.getLatestFrameLocationCoordinates(frame));
				mainMenu.setLockedWindow(data.getLockedWindow());
				mainMenu.showMainMenu(data,GuiManagement.getLatestFrameLocationCoordinates(frame));
				
			}
		});
		button.setBounds(351, 297, 64, 60);
		
		JLabel lblBusinessStaff = new JLabel("Business'  Staff");
		lblBusinessStaff.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblBusinessStaff.setBounds(307, 13, 142, 44);
		frame.getContentPane().add(lblBusinessStaff);
		
	}
}
