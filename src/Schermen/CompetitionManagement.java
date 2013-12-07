package Schermen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logics.CompetitionLogic;
import FormElements.ColoredRectangle;
import FormElements.ImageLabel;
import FormElements.MyButton;
import FormElements.ScrollField;
import Main.FontController;
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
	//private ScrollField sF = new ScrollField(new Dimension(500,500));
	private ScrollField sf = new ScrollField(new Dimension(500,500));

	public CompetitionManagement(Gui gui){
		sf = new ScrollField(new Dimension(600,400));
        sf.setBounds(300,220,600,400);
      //create word panel                        
        ColoredRectangle wordPanel = new ColoredRectangle(new Rectangle(sf.getWidth(),50), Color.gray);
        //create word label
        JLabel wordLabel = new JLabel("dsf");
        wordLabel.setForeground(Color.white);
        wordLabel.setBounds(0,0,550,50);
        wordLabel.setFont(FontController.getInstance().getFont("segoeuil"));
        wordLabel.setFont(new Font(wordLabel.getFont().getName(), Font.BOLD, 20));
        //add label to panel
        wordPanel.add(wordLabel);
        
        //create edit buttonimage
        ImageIcon editLogo = new ImageIcon(getClass().getResource("/Assets/Images/edit.png"));
        JButton editButton = new JButton(editLogo);
        editButton.setBackground(Color.gray);
        editButton.setBounds(wordPanel.getWidth()-(editLogo.getIconWidth()+10),wordPanel.getHeight() - 15 - editLogo.getIconHeight(), editLogo.getIconWidth()+2, editLogo.getIconHeight()+2);
        editButton.setName("btnWordOutList#"+"dsf");
        //addclickevent
        //editButton.addActionListener(logics);
        
        
        //add editlabel to wordpanel
        wordPanel.add(editButton);
        
        wordPanel.setLayout(null);
        //add wordpanel to scollfield
        sf.addElement(wordPanel);  
        
        this.add(sf);
        
        
        
		/*this.competitionLogics = new CompetitionLogic(this);
		alImageLabel = new ArrayList<ImageLabel>();
		this._gui = gui;
		this.setBackground(null);
		this.setBounds(0, 0, gui.getWidth(), gui.getHeight());
		this.setLayout(null);
		setFriends();
		//sF.add(test);

		//Create layout
		this.add(createTitle("New Game"));
		createFriendsList(this,"Friends");*/
		//int i = 0;
		/*for(String friend : friends){
			JPanel field = new JPanel();
			//ImageIcon icon = new ImageIcon(getClass().getResource("/Assets/Images/default-avatar.png"));
			ImageLabel il = new ImageLabel(gui, new ImageIcon(getClass().getResource("/Assets/Images/default-avatar.png")), friend);
			//il.setLocation(425, 230+i);
			competitionLogics.initMouseListener(il);
			alImageLabel.add(il);
			field.add(il);
			//this.add(il);
			ColoredRectangle j = new ColoredRectangle(new Rectangle(30,30), Color.white);
			sF.addElement(j);
			//i += 65;
		}
		this.add(sF);*/
		/*this.add(createButton("Add", "btnAdd", new Rectangle(425, 650, 55, 27)));
		this.add(createButton("Edit", "btnEdit", new Rectangle(485, 650, 55, 27)));
		this.add(createButton("Create", "btnCreate", new Rectangle(600, 650, 55, 27)));
		this.add(createButton("Back", "btnBack", new Rectangle(660, 650, 55, 27)));
		this.add(createButton("Logout", "btnLogout", new Rectangle(750, 670, 55, 27)));
		
		sF.setBounds(425,250,350,300);
		sF.setBackground(Color.BLACK);
		JPanel test = new JPanel();
		test.setBounds(5, 5, 5, 5);
		test.setLocation(5,5);
		test.setBackground(Color.green);
		sF.addElement(test);
		this.add(sF);*/
	}
	
	public Gui get_gui() {
		return _gui;
	}
	
	public void set_gui(Gui _gui) {
		this._gui = _gui;
	}
	
	public void setAlImageLabel(ArrayList<ImageLabel> alImageLabel) {
		this.alImageLabel = alImageLabel;
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
