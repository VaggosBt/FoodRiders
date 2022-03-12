package Main;

import java.awt.Point;
import java.net.MalformedURLException;

import javax.swing.UnsupportedLookAndFeelException;

import Handler_Package.Handler;
import Login_Screen_Package.Login_Screen;

public class Main{

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, 
												  UnsupportedLookAndFeelException, MalformedURLException {
		Handler data = new Handler();// Data handler object that is being send across all the entire program.
		Point frameLocation = new Point(800,400);
		
		Login_Screen window = new Login_Screen(data, frameLocation);
		window.showLoginScreen(data,frameLocation);  
	}

}