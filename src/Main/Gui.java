package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Schermen.GameScreen;
import Schermen.Login;
import Schermen.ObserverSelectgame;
import Schermen.WordJudgement;;

@SuppressWarnings("serial")
public class Gui extends JFrame {
	private Main main;
    private Font segoeuil, segoeui, seguisb;
    private JPanel jpanel = new JPanel();
    
	public Gui(Main main) {
		this.main = main;
		
		//Load fonts
		FontController.getInstance().InitFonts();
		
		//Dit hide de frame border
		setUndecorated(true);	
		
		jpanel.setSize(new Dimension(1280,720));
		jpanel.setBackground(null);
		
		this.setTitle("Wordfeud");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(1280,720));
		this.setResizable(false);
		this.setContentPane(jpanel);
		this.setVisible(true);
		this.setLayout(null);
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
		//jpanel.add(new Register(this));
		//jpanel.add(new ObserverSelectgame(this));
		//jpanel.add(new GameScreen(this));
		jpanel.add(new WordJudgement(this));
		
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
		closebtn.setName("CloseApp");
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
