package Schermen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import FormElements.ImageLabel;
import Main.Gui;

public class CompetitionManagement extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Gui _gui;
	private Rectangle bounds = new Rectangle(20, 20, 20, 20);
	private ArrayList<String> friends = new ArrayList<String>();
	private ImageIcon icon;
	
	public CompetitionManagement(Gui gui){
		this._gui = gui;
		this.setBackground(null);
		this.setBounds(0, 0, gui.getWidth(), gui.getHeight());
		
		setFriends();
		
		//Create layout
		this.add(createTitle("New Game"));
		createFriendsList(this,"Friends");
		/*for(String friend : friends){
			//this.add(createBalloon(friend,Color.white));
			//this.add(new AvatarInformationButton(friend).getThis());
			JLabel test = new JLabel("adsf");
			AvatarInformationButton lol = new AvatarInformationButton("asdfdf");
			lol.setBounds(426,220,268,55);
			this.add(lol);
		}*/
		/*ImageLabel label = new ImageLabel(new ImageIcon(getClass().getResource("/Assets/Images/default-avatar.png")));
	    label.setLocation(29, 37);
	    label.setText("sdaf");
	    this.add(label);
	    */
	    
	    
	  
	    
	    icon = new ImageIcon("/Assets/Images/default-avatar.png");

	    JLabel test = new JLabel() {
	      public void paintComponent(Graphics g) {
	        g.drawImage(icon.getImage(), 0, 0, null);
	        super.paintComponent(g);
	      }
	    };

	    test.setOpaque(false);
	    this.add( test );
	    //test.setText("Text1");

	}
	
	public Gui getGui(){
		return this._gui;
	}
	
	private void setFriends(){
		this.friends.add("Henk");
		this.friends.add("Seline");
	}
	
	private JLabel createTitle(String text) {
		JLabel title = new JLabel(text);
		title.setForeground(Color.white);
		title.setBounds(426,120,268,55);
		title.setFont(_gui.segoeuil());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 42));
		return title;
	}
	
	private void createFriendsList(JPanel panel, String text){
		JLabel title = new JLabel(text);
		title.setForeground(Color.white);
		title.setBounds(426,170,268,55);
		title.setFont(_gui.segoeuil());
		title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
		panel.add(title);
		
		return;
	}	
}
