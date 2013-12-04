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
import java.sql.PreparedStatement;
//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Date;

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
import Main.DatabaseController;


@SuppressWarnings("serial")
public class ChatScreen extends JPanel implements Observer{
	//View
	private GameScreen _parent;
	private Rectangle bounds = new Rectangle(1000, 184, 260, 600);

	private TextFieldSL inputField = null;

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
		if(chatBalloons.size() == 0) return;
		
		textArea.removeAll();
		
		chatBalloons = new ArrayList<ChatBalloon>();
	}
	
	private JScrollPane createScrollPane() {
		JScrollPane jsp = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		Rectangle r = new Rectangle(0, 0, 260, 408);
		
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
		Rectangle b = new Rectangle(0, 416, 260, 30);
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
					
					//create text balloon
					if(!text.isEmpty()) {
						//the local player will get color1
						createTextBalloon(text, color1);
						s.setText("");
						sendTextToDatabase(text);
					}
					//TODO send the text to the database
				}
			}
		});
	}
	
	private void sendTextToDatabase(String text){
		//send the text to the database
		//timestamp
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timestamp = sdf.format(date);
		//ResultSet rs = DatabaseController.getInstance().runQuery("Insert into chatregel values 'marijntje42', 511,'"+ timestamp+"','"+text+ "'");
		DatabaseController.getInstance().startPreparedStatement("INSERT INTO chatregel (`Account_naam`, `Spel_ID`, `datetime`, `bericht`) VALUES ( ?, ?, ?, ?)");
		PreparedStatement statement = DatabaseController.getInstance().getPreparedStatement();
		try {
			statement.setString(1, "marijntje42");
			statement.setInt(2, 511);
			statement.setString(3, timestamp);
			statement.setString(4, text);
			DatabaseController.getInstance().setPreparedStatement(statement);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DatabaseController.getInstance().runPreparedStatement();
	}
}
