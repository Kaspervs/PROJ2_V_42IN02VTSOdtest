package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Schermen.CompetitionManagement;


@SuppressWarnings("serial")
public class Gui extends JFrame {
	private Main main;
    private Font segoeuil, segoeui, seguisb;
    private JPanel jpanel = new JPanel();
    
	public Gui(Main main) {
		this.main = main;
		
		//Load fonts
        try {
			//Light
        	segoeuil = Font.createFont( Font.TRUETYPE_FONT, new FileInputStream("bin/Assets/Fonts/segoeuil.ttf") );
			//Semi bold
	        seguisb = Font.createFont( Font.TRUETYPE_FONT, new FileInputStream("bin/Assets/Fonts/seguisb.ttf") );
	        //Normal
	        segoeui = Font.createFont( Font.TRUETYPE_FONT, new FileInputStream("bin/Assets/Fonts/segoeui.ttf") );
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		//Dit hide de frame border
		setUndecorated(true);	
		
		jpanel.setSize(new Dimension(1280,720));
		jpanel.setBackground(null);
		
		this.setTitle("Wordfeud");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(1280,720));
		this.setResizable(false);
		this.setContentPane(jpanel);
		this.setVisible(true);
		this.setLayout(null);
		//this.setBackground(new Color(0.11372549019607843137254901960784f, 0.11372549019607843137254901960784f, 0.11372549019607843137254901960784f));
		this.setBackground(new Color(29,29,29));
		//Center screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(
				new Point(
						(int) ((screenSize.width  - this.getSize().getWidth()) / 2),
						(int) ((screenSize.height - this.getSize().getHeight()) / 2)
				)
		);	
		this.setupForm();
		
		//Create loginscreen
		//jpanel.add(new Login(this));
		jpanel.add(new CompetitionManagement(this));
		//jpanel.add(new Register(this));
		//jpanel.add(new ObserverSelectgame(this));
		//jpanel.add(new GameList(this));
		//jpanel.add(new GameScreen(this));
		
		this.repaint();
	}
	
	private void setupForm() {
		//Load close button image icon
		ImageIcon icon = new ImageIcon(getClass().getResource("/Assets/Images/close_small.png"));
		JButton closebtn = new JButton("", icon);
		closebtn.setBounds(this.getWidth() - 5 - icon.getIconWidth(), 5, icon.getIconWidth(), icon.getIconHeight());
		closebtn.setBackground(null);
		closebtn.setBorder(null);
		closebtn.setContentAreaFilled(false);
		jpanel.add(closebtn);
		closebtn.setName("CloseFrame");
		closebtn.addActionListener(main.getBtnListner()); 
		
		//Create draghandle
		jpanel.add(new DragHandle(this));
		
	}
	
	public void changeScreen(JPanel content) {
		jpanel.removeAll();
		setupForm();
		jpanel.add(content);
		jpanel.repaint();
	}
	
	/**
	 * Segoe UI Light
	 * @return Font
	 */
	public Font segoeuil() {
		return this.segoeuil;
	}
	
	/**
	 * Segoe UI Normal
	 * @return Font
	 */
	public Font segoeui() {
		return this.segoeui;
	}
	
	/**
	 * Segoe UI Semi Bold
	 * @return Font
	 */
	public Font seguisb() {
		return this.seguisb;
	}
	
	public Main getMain() {
		return this.main;
	}
	
	public void showMessage(String Message) {
		new Alert(this, Message);
	}
	
	public void showMessage(String Message, String Title) {
		new Alert(this, Message, Title);
		
	}
	
	
}
