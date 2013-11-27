package Schermen;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import FormElements.MyButton;
import FormElements.TextFieldSL;
import Main.DatabaseController;
import Main.Gui;

@SuppressWarnings("serial")
public class Login extends JPanel {

	private Gui _gui;
	public Login(Gui gui) {
		DatabaseController DC = DatabaseController.getInstance();
		DC.setDatabase("tdalmaij_db2").setHost("databases.aii.avans.nl").setPassword("Ab12345").setUser("tdalmaij");

		//Hier wat andere code

		ResultSet result = DC.runQuery("SELECT * FROM account");
		try {
		while(result.next()) {

		}
		} catch (SQLException e) {
		e.printStackTrace();
		}

		
		
		this._gui = gui;
		this.setBackground(null);
		this.setBounds(0, 0, gui.getWidth(), gui.getHeight());
		
		//Avans Logo
		ImageIcon AvansLogo = new ImageIcon(getClass().getResource("/Assets/Images/Avans-logo.png"));
		JLabel AvansLabel = new JLabel(AvansLogo);
		AvansLabel.setBounds(20,gui.getHeight() - 21 - AvansLogo.getIconHeight(), AvansLogo.getIconWidth(), AvansLogo.getIconHeight());
		this.add(AvansLabel);
		
		//Java Logo
		ImageIcon JavaLogo = new ImageIcon(getClass().getResource("/Assets/Images/appbar.language.java.text.png"));
		JLabel JavaLabel = new JLabel(JavaLogo);
		JavaLabel.setBounds(gui.getWidth() - JavaLogo.getIconWidth() - 20,gui.getHeight() - 21 - JavaLogo.getIconHeight(), JavaLogo.getIconWidth(), JavaLogo.getIconHeight());
		this.add(JavaLabel);
		
		//Login tekst
		JLabel loginText = new JLabel("Login");
		loginText.setForeground(Color.white);
		loginText.setBounds(426,120,268,55);
		loginText.setFont(gui.segoeuil());
		loginText.setFont(new Font(loginText.getFont().getName(), Font.PLAIN, 42));
		this.add(loginText);
		
		//Default avatar
		ImageIcon avatar = new ImageIcon(getClass().getResource("/Assets/Images/default-avatar.png"));
		JLabel avatarLabel = new JLabel(avatar);
		avatarLabel.setBounds(426,180, avatar.getIconWidth(), avatar.getIconHeight());
		this.add(avatarLabel);
		
		//Username Field
		TextFieldSL usernameField = new TextFieldSL("Username");
		usernameField.setBounds(536, 180, 260, 30);
		usernameField.setFont(gui.seguisb());
		usernameField.setFont(new Font(usernameField.getFont().getName(), Font.BOLD, 12));
		this.add(usernameField);
		
		//Password Field
		JPasswordField passwordField = new JPasswordField("Password");
		passwordField.setBounds(536, 220, 260, 30);
		passwordField.setFont(gui.seguisb());
		passwordField.setFont(new Font(passwordField.getFont().getName(), Font.BOLD, 12));
		this.add(passwordField);
		
		//Create Account Button
		MyButton createAccBtn = new MyButton("Create account");
		createAccBtn.setBounds(538, 292, 101, 27);
		createAccBtn.setFont(gui.seguisb());
		createAccBtn.setFont(new Font(createAccBtn.getFont().getName(), Font.BOLD, 12));
		this.add(createAccBtn);
		
		//Login Button
		this.add(createLoginBtn());
	}
	
	public MyButton createLoginBtn(){
		MyButton loginBtn = new MyButton("Login");
		loginBtn.setBounds(693, 292, 101, 27);
		loginBtn.setFont(_gui.seguisb());
		loginBtn.setFont(new Font(loginBtn.getFont().getName(), Font.BOLD, 12));
		//TODO add click listener
		return loginBtn;
	}

}
