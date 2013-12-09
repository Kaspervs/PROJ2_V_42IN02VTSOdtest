package Schermen;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import logics.PlayerManagementLogics;
import FormElements.MyButton;
import FormElements.PasswordFieldSL;
import Main.Gui;

public class PlayerManagement extends JPanel {
	private Gui _gui;
	private PlayerManagementLogics logics = new PlayerManagementLogics(this);
	JPasswordField PasswordA;
	JPasswordField PasswordB;
	JPasswordField PasswordC;

	public PlayerManagement(Gui gui) {
		this._gui = gui;
		this.setBackground(null);
		this.setBounds(0, 0, gui.getWidth(), gui.getHeight());

		this.add(backButton());
		this.add(createSaveButton());

		PasswordA = createPasswordAField();
		PasswordB = createPasswordBField();
		PasswordC = createPasswordCField();
		
		this.add(PasswordA);
		this.add(PasswordB);
		this.add(PasswordC);
		
		this.add(PAFieldText());
		this.add(PBFieldText());
		this.add(PCFieldText());
		this.add(createPMText());
	}
	
	public Gui getGui() {
		return this._gui;
	}
	  
	
	public JPasswordField getPasswordA() {
		return PasswordA;
	}

	public void setPasswordA(JPasswordField passwordA) {
		PasswordA = passwordA;
	}

	public JPasswordField getPasswordB() {
		return PasswordB;
	}

	public void setPasswordB(JPasswordField passwordB) {
		PasswordB = passwordB;
	}

	public JPasswordField getPasswordC() {
		return PasswordC;
	}

	public void setPasswordC(JPasswordField passwordC) {
		PasswordC = passwordC;
	}

	private MyButton backButton(){
		MyButton backBtn = new MyButton("Back");
		backBtn.setBounds(420, 320, 101, 27);
		backBtn.setFont(_gui.seguisb());
		backBtn.setFont(new Font(backBtn.getFont().getName(), Font.BOLD, 12));
		backBtn.setName("backBtn");
		backBtn.addActionListener(logics);
		return backBtn;
	}
	
	private MyButton createSaveButton(){
		MyButton saveAccBtn = new MyButton("Save Data");
		saveAccBtn.setBounds(693, 320, 101, 27);
		saveAccBtn.setFont(_gui.seguisb());
		saveAccBtn.setFont(new Font(saveAccBtn.getFont().getName(), Font.BOLD, 12));
		saveAccBtn.setName("saveAccBtn");
		saveAccBtn.addActionListener(logics);
		return saveAccBtn;
	}
	
	private JPasswordField createPasswordAField() {
		JPasswordField passwordAField = new PasswordFieldSL("");
		passwordAField.setBounds(536, 200, 260, 30);
		passwordAField.setFont(_gui.seguisb());
		passwordAField.setBackground(Color.black);
		passwordAField.setFont(new Font(passwordAField.getFont().getName(), Font.BOLD, 12));
		return passwordAField;
	}
	
	private JPasswordField createPasswordBField() {
		JPasswordField passwordBField = new PasswordFieldSL("");
		passwordBField.setBounds(536, 235, 260, 30);
		passwordBField.setFont(_gui.seguisb());
		passwordBField.setBackground(Color.black);
		passwordBField.setFont(new Font(passwordBField.getFont().getName(), Font.BOLD, 12));
		return passwordBField;
	}
	
	private JPasswordField createPasswordCField() {
		JPasswordField passwordCField = new PasswordFieldSL("");
		passwordCField.setBounds(536, 270, 260, 30);
		passwordCField.setFont(_gui.seguisb());
		passwordCField.setBackground(Color.black);
		passwordCField.setFont(new Font(passwordCField.getFont().getName(), Font.BOLD, 12));
		return passwordCField;
	}
	
	private JLabel PAFieldText(){
		JLabel PAfield = new JLabel("Current Password");
		PAfield.setForeground(Color.white);
		PAfield.setBounds(420,190,268,55);
		PAfield.setFont(_gui.segoeuil());
		PAfield.setFont(new Font(PAfield.getFont().getName(), Font.PLAIN, 12));
		return PAfield;
	}
	private JLabel PBFieldText(){
		JLabel PBfield = new JLabel("New Password");
		PBfield.setForeground(Color.white);
		PBfield.setBounds(420,225,268,55);
		PBfield.setFont(_gui.segoeuil());
		PBfield.setFont(new Font(PBfield.getFont().getName(), Font.PLAIN, 12));
		return PBfield;
	}
	private JLabel PCFieldText(){
		JLabel PCfield = new JLabel("Confirm Password");
		PCfield.setForeground(Color.white);
		PCfield.setBounds(420,260,268,55);
		PCfield.setFont(_gui.segoeuil());
		PCfield.setFont(new Font(PCfield.getFont().getName(), Font.PLAIN, 12));
		return PCfield;
	}
	
	
	private JLabel createPMText() {
		JLabel managementText = new JLabel("Player Management");
		managementText.setForeground(Color.white);
		managementText.setBounds(420,120,500,55);
		managementText.setFont(_gui.segoeuil());
		managementText.setFont(new Font(managementText.getFont().getName(), Font.PLAIN, 42));
		return managementText;
	}


}
