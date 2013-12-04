package Schermen.chat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

import logics.ChatModel;
import utils.ImageTool;
import FormElements.TextFieldSL;
import Schermen.GameScreen;

@SuppressWarnings("serial")
public class ChatScreen extends JPanel implements Observer{
	//View
	private GameScreen _parent;
	private Rectangle bounds = new Rectangle(1000, 74, 260, 600);
	private JLabel avatar1, avatar2;
	private Dimension avatarDimension = new Dimension(57,57);
	
	private TextFieldSL inputField = null;
	private static final String AVATAR = "/Assets/Images/default-avatar.png";
	
	private JScrollPane sp;
	private JPanel  textArea;
	private ArrayList<ChatBalloon> chatBalloons = new ArrayList<ChatBalloon>();
	
	private Color color1 = new Color(38,115,236);
	private	Color color2 = new Color(31,174,255);
	
	private Font segoeUI_sb;
	
	private JScrollBar verticalScrollBar;
	private int scrollSpeed = 16;
	
	
	
	public ChatScreen(GameScreen p){
		this._parent = p;
		this.segoeUI_sb = _parent.getGui().seguisb();
		
		this.setBounds(bounds);
		
		this.setBackground(null);
		
		setAvatars();
		sp = createScrollPane();
		
		textArea = createTextArea();
		//add jpanel to the viewport of the scrollpane
		sp.setViewportView(textArea);
		
		this.inputField = createInputField();
		inputFieldListener();
		
		this.add(sp);
		this.add(inputField);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		emptyChatBox();
		ChatModel model = (ChatModel) arg0;
		updateMessages(model.getMessages(), model.getDates(), model.getNames());
	}
	
	private void updateMessages(ArrayList<String> m, ArrayList<String> d, ArrayList<String> n){
		if(m.isEmpty() || d.isEmpty() || n.isEmpty()) return;
		String fn = n.get(0); // First name
		Color cc = color1; // starting color
		
		for(int i=0; i < m.size(); i++){
			cc = !fn.equals(n.get(i)) ? color2 : color1; // if the first name not equals the next name, switch colors
			createTextBalloon(m.get(i), cc, d.get(i));
		}
	}
	
	private void emptyChatBox(){
		for(int i=0; i < chatBalloons.size(); i++){
			textArea.remove(i);
		}
		chatBalloons = new ArrayList<ChatBalloon>();
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

		Rectangle r = new Rectangle(0, 110, 260, 408);
		
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
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false);
		jsp.setBackground(null);
		jsp.setBounds(r);
		
		return jsp;
	}
	
	
	private JPanel createTextArea(){
		JPanel p = new JPanel();
		p.setBounds(sp.getBounds());
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		p.setOpaque(false);
		return p;
	}
	
	
	private void createTextBalloon(String txt, Color color){
		//create new Textballoon
		ChatBalloon cb = new ChatBalloon(txt, color, segoeUI_sb);
		chatBalloons.add(cb);
		
		textArea.add(cb);
		sp.revalidate();
		setVerticalScrollBarValue();
	}
	
	
	private void createTextBalloon(String txt, Color color, String date){
		//create new Textballoon
		ChatBalloon cb = new ChatBalloon(txt, date, color, segoeUI_sb);
		chatBalloons.add(cb);
		
		textArea.add(cb);
		sp.revalidate();
		setVerticalScrollBarValue();
	}
	
	
	private void setVerticalScrollBarValue(){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				int margin = 10;
				int val = verticalScrollBar.getMaximum() + (margin * chatBalloons.size());
				verticalScrollBar.setValue(val);
			}
		});
	}
	
	private TextFieldSL createInputField(){
		//Username Field
		TextFieldSL f = new TextFieldSL("Chatterdy Chat :D");
		Rectangle b = new Rectangle(0, 528, 260, 30);
		f.setBounds(b);
		f.setFont(segoeUI_sb);
		f.setFont(new Font(f.getFont().getName(), Font.BOLD, 11));
		f.setForeground(new Color(33,33,33));
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
						//the local player will get color1
						createTextBalloon(text, color1);
						s.setText("");
					}
					//TODO send the text to the database
				}
			}
		});
	}
}
