package Schermen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logics.CompetitionLogic;
import FormElements.ImageLabel;
import FormElements.MyButton;
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
	private CompetitionLogic competitionLogics;
	private ArrayList<ImageLabel> alImageLabel;
	
	public CompetitionManagement(Gui gui){
		this.competitionLogics = new CompetitionLogic(this);
		alImageLabel = new ArrayList<ImageLabel>();
		this._gui = gui;
		this.setBackground(null);
		this.setBounds(0, 0, gui.getWidth(), gui.getHeight());
		this.setLayout(null);
		setFriends();
		
		//Create layout
		this.add(createTitle("New Game"));
		createFriendsList(this,"Friends");
		int i = 0;
		for(String friend : friends){
			ImageIcon iconi = new ImageIcon(getClass().getResource("/Assets/Images/default-avatar.png"));
			ImageLabel il = new ImageLabel(gui, iconi, friend);
			il.setLocation(425, 230+i);
			competitionLogics.initMouseListener(il);
			alImageLabel.add(il);
			this.add(il);
			i += 65;
		}
		this.add(createButton("Add", "btnAdd", new Rectangle(425, 650, 55, 27)));
		this.add(createButton("Edit", "btnEdit", new Rectangle(485, 650, 55, 27)));
		this.add(createButton("Create", "btnCreate", new Rectangle(600, 650, 55, 27)));
		this.add(createButton("Back", "btnBack", new Rectangle(660, 650, 55, 27)));
		this.add(createButton("Logout", "btnLogout", new Rectangle(750, 670, 55, 27)));
	}
	
	 public ArrayList<ImageLabel> getAlImageLabel() {
		return alImageLabel;
	}

	private MyButton createButton(String text, String name, Rectangle bounds){
		 MyButton button = new MyButton(text);
		 button.setBounds(bounds);
		 button.setFont(new Font(button.getFont().getName(), Font.BOLD, 12));
		 button.setName(name);
		 button.addActionListener(this.getcompetitionLogics());
		 return button;
	 }
	
	public CompetitionLogic getcompetitionLogics() {
		return competitionLogics;
	}

	public Gui getGui(){
		return this._gui;
	}
	
	private void setFriends(){
		this.friends.add("Henk");
		this.friends.add("Seline");
		this.friends.add("Thommes");
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
