package Schermen;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import FormElements.MyButton;
import FormElements.TextFieldSL;
import Main.FontController;
import Main.Gui;

public class Register extends JPanel {
	public Register(Gui gui) {
		this.setBackground(null);
		this.setBounds(0, 0, gui.getWidth(), gui.getHeight());
		
		//Login tekst
		JLabel loginText = new JLabel("Create account");
		loginText.setForeground(Color.white);
		loginText.setBounds(426,120,268,55);
		loginText.setFont(FontController.getInstance().getFont("segoeuil"));
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
		usernameField.setFont(FontController.getInstance().getFont("seguisb"));
		usernameField.setFont(new Font(usernameField.getFont().getName(), Font.BOLD, 12));
		this.add(usernameField);
		
		//Password Field
		TextFieldSL passwordField = new TextFieldSL("Password");
		passwordField.setBounds(536, 220, 260, 30);
		passwordField.setFont(FontController.getInstance().getFont("seguisb"));
		passwordField.setFont(new Font(passwordField.getFont().getName(), Font.BOLD, 12));
		this.add(passwordField);
		
		//Back button
		MyButton backButton = new MyButton("Back");
		backButton.setBounds(538, 292, 101, 27);
		backButton.setFont(FontController.getInstance().getFont("seguisb"));
		backButton.setFont(new Font(backButton.getFont().getName(), Font.BOLD, 12));
		this.add(backButton);
		
		//Create account Button
		MyButton createAccBtn = new MyButton("Create Account");
		createAccBtn.setBounds(693, 292, 101, 27);
		createAccBtn.setFont(FontController.getInstance().getFont("seguisb"));
		createAccBtn.setFont(new Font(createAccBtn.getFont().getName(), Font.BOLD, 12));
		this.add(createAccBtn);
	}
}
