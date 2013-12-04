package Schermen;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logics.LoginLogics;
import FormElements.MyButton;
import FormElements.TextFieldSL;
import Main.DatabaseController;
import Main.FontController;
import Main.Gui;

@SuppressWarnings("serial")
public class Login extends JPanel {
	private Gui _gui;
	private LoginLogics logics = new LoginLogics(this);
	private TextFieldSL username, password;
	
	public Login(Gui gui) {
		this._gui = gui;
		this.setBackground(null);
		this.setBounds(0, 0, gui.getWidth(), gui.getHeight());
		
		//Create layout
		this.add(createAvansLogo());
		this.add(createJavaLogo());
		this.add(createLoginTekst());
		this.add(createDefaultAvatar());
		username = createUsernameField();
		password = createPasswordField();
		this.add(username);
		this.add(password);
		this.add(createRegisterButton());
		this.add(createLoginBtn());
	}
	
	public LoginLogics getLogics() {
		return this.logics;
	}
	
	public Gui getGui() {
		return this._gui;
	}
	
	public String getUsernameFieldText() {
		return this.username.getText();
	}
	
	public String getPasswordFieldText() {
		return this.password.getText();
	}
	
	private MyButton createLoginBtn(){
		MyButton loginBtn = new MyButton("Login");
		loginBtn.setBounds(693, 292, 101, 27);
		loginBtn.setFont(FontController.getInstance().getFont("seguisb"));
		loginBtn.setFont(new Font(loginBtn.getFont().getName(), Font.BOLD, 12));
		loginBtn.setName("loginBtn");
		loginBtn.addActionListener(logics);
		return loginBtn;
	}
	
	private MyButton createRegisterButton(){
		MyButton createAccBtn = new MyButton("Create account");
		createAccBtn.setBounds(538, 292, 101, 27);
		createAccBtn.setFont(FontController.getInstance().getFont("seguisb"));
		createAccBtn.setFont(new Font(createAccBtn.getFont().getName(), Font.BOLD, 12));
		//TODO add click listener
		return createAccBtn;
	}
	
	private TextFieldSL createPasswordField() {
		TextFieldSL passwordField = new TextFieldSL("Password");
		passwordField.setBounds(536, 220, 260, 30);
		passwordField.setFont(FontController.getInstance().getFont("seguisb"));
		passwordField.setFont(new Font(passwordField.getFont().getName(), Font.BOLD, 12));
		return passwordField;
	}
	
	private TextFieldSL createUsernameField() {
		TextFieldSL usernameField = new TextFieldSL("Username");
		usernameField.setBounds(536, 180, 260, 30);
		usernameField.setFont(FontController.getInstance().getFont("seguisb"));
		usernameField.setFont(new Font(usernameField.getFont().getName(), Font.BOLD, 12));
		return usernameField;
	}
	
	private JLabel createDefaultAvatar() {
		ImageIcon avatar = new ImageIcon(getClass().getResource("/Assets/Images/default-avatar.png"));
		JLabel avatarLabel = new JLabel(avatar);
		avatarLabel.setBounds(426,180, avatar.getIconWidth(), avatar.getIconHeight());	
		return avatarLabel;
	}
	
	private JLabel createJavaLogo() {
		ImageIcon JavaLogo = new ImageIcon(getClass().getResource("/Assets/Images/appbar.language.java.text.png"));
		JLabel JavaLabel = new JLabel(JavaLogo);
		JavaLabel.setBounds(_gui.getWidth() - JavaLogo.getIconWidth() - 20,_gui.getHeight() - 21 - JavaLogo.getIconHeight(), JavaLogo.getIconWidth(), JavaLogo.getIconHeight());
		return JavaLabel;
	}
	
	private JLabel createAvansLogo() {
		ImageIcon AvansLogo = new ImageIcon(getClass().getResource("/Assets/Images/Avans-logo.png"));
		JLabel AvansLabel = new JLabel(AvansLogo);
		AvansLabel.setBounds(20,_gui.getHeight() - 21 - AvansLogo.getIconHeight(), AvansLogo.getIconWidth(), AvansLogo.getIconHeight());
		return AvansLabel;
	}
	
	private JLabel createLoginTekst() {
		JLabel loginText = new JLabel("Login");
		loginText.setForeground(Color.white);
		loginText.setBounds(426,120,268,55);
		loginText.setFont(FontController.getInstance().getFont("segoeuil"));
		loginText.setFont(new Font(loginText.getFont().getName(), Font.PLAIN, 42));
		return loginText;
	}

}
