package Schermen;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import FormElements.MyButton;
import FormElements.PasswordFieldSL;
import Main.Gui;

public class PlayerManagement extends JPanel {
	private Gui _gui;
	JPasswordField PasswordA;
	JPasswordField PasswordB;
	JPasswordField PasswordC;

	public PlayerManagement(Gui gui) {
		this._gui = gui;
		this.setBackground(null);
		this.setBounds(0, 0, gui.getWidth(), gui.getHeight());
		
	
	}
	
	private MyButton backButton(){
		MyButton backBtn = new MyButton("Back");
		backBtn.setBounds(693, 292, 101, 27);
		backBtn.setFont(_gui.seguisb());
		backBtn.setFont(new Font(backBtn.getFont().getName(), Font.BOLD, 12));
		backBtn.setName("backBtn");
		//backBtn.addActionListener(logics);
		return backBtn;
	}
	
	private MyButton createSaveButton(){
		MyButton saveAccBtn = new MyButton("Save Data");
		saveAccBtn.setBounds(538, 292, 101, 27);
		saveAccBtn.setFont(_gui.seguisb());
		saveAccBtn.setFont(new Font(saveAccBtn.getFont().getName(), Font.BOLD, 12));
		saveAccBtn.setName("saveAccBtn");
		//saveAccBtn.addActionListener(logics);
		return saveAccBtn;
	}
	
	private JPasswordField createPasswordAField() {
		JPasswordField passwordAField = new PasswordFieldSL("Password");
		passwordAField.setBounds(536, 220, 260, 30);
		passwordAField.setFont(_gui.seguisb());
		passwordAField.setBackground(Color.black);
		passwordAField.setFont(new Font(passwordAField.getFont().getName(), Font.BOLD, 12));
		return passwordAField;
	}
	
	private JPasswordField createPasswordBField() {
		JPasswordField passwordBField = new PasswordFieldSL("Password");
		passwordBField.setBounds(536, 220, 260, 30);
		passwordBField.setFont(_gui.seguisb());
		passwordBField.setBackground(Color.black);
		passwordBField.setFont(new Font(passwordBField.getFont().getName(), Font.BOLD, 12));
		return passwordBField;
	}
	
	private JPasswordField createPasswordCField() {
		JPasswordField passwordCField = new PasswordFieldSL("Confirm assword");
		passwordCField.setBounds(536, 220, 260, 30);
		passwordCField.setFont(_gui.seguisb());
		passwordCField.setBackground(Color.black);
		passwordCField.setFont(new Font(passwordCField.getFont().getName(), Font.BOLD, 12));
		return passwordCField;
	}

}
