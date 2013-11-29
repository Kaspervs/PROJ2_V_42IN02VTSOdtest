package Schermen.chat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import utils.ImageTool;
import FormElements.TextFieldSL;
import Schermen.GameScreen;

public class ChatScreen extends JPanel implements Observer{
	//View
	private GameScreen _parent;
	private Rectangle bounds = new Rectangle(1000, 74, 260, 600);
	private JLabel avatar1, avatar2;
	private Dimension avatarDimension = new Dimension(57,57);
	
	private TextFieldSL inputField = null;
	private static final String AVATAR = "/Assets/Images/default-avatar.png";
	
	private JScrollPane sp;
	private JPanel  textArea = new JPanel();
	private List chatBalloons = new ArrayList<ChatBalloon>();
	
	private Color color1 = new Color(38,115,236);
	private	Color color2 = new Color(31,174,255);
	
	private Font segoeUI_sb;
	
	private JScrollBar verticalScrollBar;
	private int scrollSpeed = 16;
	
	public ChatScreen(GameScreen p){
		this._parent = p;
		this.segoeUI_sb = _parent.getGui().seguisb();
		
		this.setBounds(bounds);
		
		this.setBackground(Color.RED);
		
		setAvatars();
		sp = createScrollPane();
		
		this.inputField = createInputField();
		inputFieldListener();
		
		this.add(sp);
		this.add(inputField);
		
		System.out.println("dimensions : "+textArea.getBounds());
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	private void setAvatars(){
		this.avatar1 = getAvatar(AVATAR);
		this.avatar2 = getAvatar(AVATAR);
		this.avatar2.setLocation(203, 0);
		this.add(avatar1);
		this.add(avatar2);
	}
	
	private JLabel getAvatar(String url){
		//Default avatar
		File f = null;
		BufferedImage bImg = null;
		Image img = null;
		ImageIcon imgIcon = null;
		JLabel label = null;
		try {
			// get File
			f = new File(getClass().getResource(url).toURI());
			// read the file to an image
			bImg = ImageIO.read(f);
			//Resize the buffered image 
			img = ImageTool.resize(ImageTool.toImage(bImg), avatarDimension.width, avatarDimension.height);
			//set to icon
			imgIcon = new ImageIcon(img);
			//put it into a jlabel
			label = new JLabel(imgIcon);
			//set bounds
			label.setBounds(0, 0, imgIcon.getIconWidth(), imgIcon.getIconHeight());
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
		return label;
	}
	
	private JScrollPane createScrollPane() {
		JScrollPane jsp = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		verticalScrollBar = new JScrollBar(JScrollBar.VERTICAL){
			@Override
			public boolean isVisible(){
				return true;
			}
		};
		
		jsp.setVerticalScrollBar(verticalScrollBar);
		jsp.getVerticalScrollBar().setUnitIncrement(scrollSpeed);
		jsp.setAlignmentX(LEFT_ALIGNMENT);
		jsp.setBorder(null);
		Rectangle r = new Rectangle(0, 110, 260, 408);
		jsp.setBounds(r);
		
		textArea.setBounds(r);
		textArea.setLayout(new BoxLayout(textArea, BoxLayout.PAGE_AXIS));
		//textArea.setLineWrap(true);
		//textArea.setWrapStyleWord(true);
		textArea.setBackground(Color.gray);
		
		//add jpanel to the viewport of the scrollpane
		jsp.setViewportView(textArea);
				
		return jsp;
	}
	
	
	
	
	private void createTextBalloon(String txt){
		ChatBalloon cb = new ChatBalloon(txt, color2, segoeUI_sb);
		chatBalloons.add(cb);
		textArea.add(cb);
		sp.revalidate();

		verticalScrollBar.setValue(verticalScrollBar.getMaximum());
	}
	
	private TextFieldSL createInputField(){
		//Username Field
		TextFieldSL f = new TextFieldSL("Chatterdy Chat :D");
		Rectangle b = new Rectangle(0, 528, 260, 30);
		f.setBounds(b);
		f.setFont(segoeUI_sb);
		f.setFont(new Font(f.getFont().getName(), Font.BOLD, 11));
		f.setForeground(new Color(33,33,33));
		f.setBackground(new Color(210,210,210));
		return f;
	}
	
	private void inputFieldListener(){
		inputField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {}
			
			
			@Override
			public void keyReleased(KeyEvent arg0) {}
			
			
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				
				if(e.getSource() == inputField && keyCode == KeyEvent.VK_ENTER){
					TextFieldSL s = (TextFieldSL) e.getSource();
					String text = s.getText().toString().trim();
					System.out.println("Enter: "+ text);
					//send the text to the database
					//create text balloon
					if(!text.isEmpty()) {
						createTextBalloon(text);
						s.setText("");
					}
					//TODO send the text to the database
				}
			}
		});
	}
}
