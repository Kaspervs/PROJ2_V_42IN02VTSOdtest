package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Alert extends JFrame {
	private String message,title;
	private Gui gui;
	
	public Alert(Gui gui, String Message) {
		this.message = Message;
		this.title = "Alert";
		this.gui = gui;
		this.showAllert();
	}
	
	public Alert(Gui gui, String Message, String Title) {
		this.message = Message;
		this.title = Title;
		this.gui = gui;
		this.showAllert();
	}
	
	private void showAllert() {
		setUndecorated(true);	
		
		JPanel jpanel = new JPanel();
		jpanel.setSize(new Dimension(400,250));
		jpanel.setBackground(null);
		
		this.setTitle("Wordfeud");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(400,250));
		this.setResizable(false);
		this.setContentPane(jpanel);
		this.setVisible(true);
		this.setLayout(null);
		this.setBackground(new Color(0.11372549019607843137254901960784f, 0.11372549019607843137254901960784f, 0.11372549019607843137254901960784f));
		
		//Border
        Border thickBorder = new LineBorder(new Color(0.533333f,0.533333f,0.533333f), 2);
        jpanel.setBorder(thickBorder);
		
		//Center screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(
				new Point(
						(int) ((screenSize.width  - this.getSize().getWidth()) / 2),
						(int) ((screenSize.height - this.getSize().getHeight()) / 2)
				)
		);	
		
		//Load close button image icon
		ImageIcon icon = new ImageIcon(getClass().getResource("/Assets/Images/close_small.png"));
		JButton closebtn = new JButton("", icon);
		closebtn.setBounds(this.getWidth() - 5 - icon.getIconWidth(), 5, icon.getIconWidth(), icon.getIconHeight());
		closebtn.setBackground(null);
		closebtn.setBorder(null);
		closebtn.setContentAreaFilled(false);
		jpanel.add(closebtn);
		closebtn.setName("CloseFrame");
		closebtn.addActionListener(this.gui.getMain().getBtnListner()); 
		
		//Title tekst
		JLabel errorTitle = new JLabel(title);
		errorTitle.setForeground(Color.white);
		errorTitle.setBounds(10,20,380,55);
		errorTitle.setFont(this.gui.segoeuil());
		errorTitle.setFont(new Font(errorTitle.getFont().getName(), Font.PLAIN, 42));
		jpanel.add(errorTitle);
		
		//Message tekst
		JTextArea errorMessage = new JTextArea(message);
		errorMessage.setEditable(false);
		errorMessage.setLineWrap(true);
		errorMessage.setOpaque(false);
		errorMessage.setWrapStyleWord(true);
		errorMessage.setForeground(Color.white);
		errorMessage.setBounds(10,85,380,155);
		errorMessage.setFont(this.gui.segoeui());
		errorMessage.setFont(new Font(errorMessage.getFont().getName(), Font.PLAIN, 14));
		jpanel.add(errorMessage);

		
		//Create draghandle
		jpanel.add(new DragHandle(this));
		
		
		this.repaint();
	}
}
