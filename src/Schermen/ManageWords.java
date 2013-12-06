package Schermen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logics.LoginLogics;
import logics.ManageWordsLogics;
import FormElements.ColoredRectangle;
import FormElements.MyButton;
import FormElements.ScrollField;
import FormElements.TextFieldSL;
import Main.DatabaseController;
import Main.FontController;
import Main.Gui;


public class ManageWords extends JPanel {
	private Gui _gui;
	private ManageWordsLogics logics = new ManageWordsLogics(this);
	private TextFieldSL tfNewWords, tfSearchField, tfEditWord;
	private ScrollField sf;
	
	public ManageWords(Gui gui){
		
		this._gui = gui;
		this.setBackground(null);
		this.setBounds(0, 0, gui.getWidth(), gui.getHeight());
		
		//Avans Logo
				ImageIcon AvansLogo = new ImageIcon(getClass().getResource("/Assets/Images/Avans-logo.png"));
				JLabel AvansLabel = new JLabel(AvansLogo);
				AvansLabel.setBounds(20,gui.getHeight() - 21 - AvansLogo.getIconHeight(), AvansLogo.getIconWidth(), AvansLogo.getIconHeight());
				this.add(AvansLabel);
				
				//create scrollfield
				
				sf = new ScrollField(new Dimension(600,400));
				sf.setBounds(300,220,600,400);
				
				
				//welkom tekst moderator
				JLabel welkomText = new JLabel("Moderator");
				welkomText.setForeground(Color.white);
				welkomText.setBounds(400,120,350,55);
				welkomText.setFont(FontController.getInstance().getFont("segoeuil"));
				welkomText.setFont(new Font(welkomText.getFont().getName(), Font.PLAIN, 42));
				this.add(welkomText);	
				
				//welkom tekst lbledit
				JLabel lblEditText = new JLabel("Edit");
				lblEditText.setForeground(Color.white);
				lblEditText.setBounds(400,175,200,55);
				lblEditText.setFont(FontController.getInstance().getFont("segoeuil"));
				lblEditText.setFont(new Font(lblEditText.getFont().getName(), Font.BOLD, 25));
				this.add(lblEditText);	
				
				//create search textfield
				tfSearchField = new TextFieldSL("Search");
				tfSearchField.setBounds(650, 140, 210, 30);
				tfSearchField.setFont(FontController.getInstance().getFont("seguisb"));
				tfSearchField.setFont(new Font(tfSearchField.getFont().getName(), Font.BOLD, 20));
				this.add(tfSearchField);
				
				//create button search
				ImageIcon editLogo = new ImageIcon(getClass().getResource("/Assets/Images/edit.png")); //hier moet nog ander plaatje in
				JButton searchButton = new JButton(editLogo);
				searchButton.setBackground(Color.WHITE);
				searchButton.setBounds(870, 140, 30, 30);
				searchButton.setName("btnSearch");
				//addclickevent
				searchButton.addActionListener(logics);
				this.add(searchButton);
				
				//create new words label
				JLabel createWords = new JLabel("Create new words");
				createWords.setForeground(Color.white);
				createWords.setBounds(50,205,260,55);
				createWords.setFont(FontController.getInstance().getFont("segoeuil"));
				createWords.setFont(new Font(createWords.getFont().getName(), Font.BOLD, 20));
				this.add(createWords);	
				
				//new words inputfield
				tfNewWords = new TextFieldSL("Appel");
				tfNewWords.setBounds(50, 250, 170, 30);
				tfNewWords.setFont(FontController.getInstance().getFont("seguisb"));
				tfNewWords.setFont(new Font(tfNewWords.getFont().getName(), Font.BOLD, 16));
				this.add(tfNewWords);
				
				//add new word button
				MyButton btnCreateWord = new MyButton("Create new word");
				btnCreateWord.setBounds(75, 285, 120, 25);
				btnCreateWord.setFont(FontController.getInstance().getFont("seguisb"));
				btnCreateWord.setFont(new Font(btnCreateWord.getFont().getName(), Font.BOLD, 12));
				btnCreateWord.setName("btnCreateWord");
				btnCreateWord.addActionListener(logics);
				this.add(btnCreateWord);
				
				//add label edit words (right side of screen)
				JLabel lblEditWord = new JLabel("Edit word");
				lblEditWord.setForeground(Color.white);
				lblEditWord.setBounds(1000,205,260,55);
				lblEditWord.setFont(FontController.getInstance().getFont("segoeuil"));
				lblEditWord.setFont(new Font(lblEditWord.getFont().getName(), Font.BOLD, 20));
				this.add(lblEditWord);	
				
				//create textfield for edit word
				tfEditWord = new TextFieldSL("");
				tfEditWord.setBounds(1000, 250, 250, 30);
				tfEditWord.setFont(FontController.getInstance().getFont("seguisb"));
				tfEditWord.setFont(new Font(tfEditWord.getFont().getName(), Font.BOLD, 16));
				tfEditWord.setFocusStatus(false);
				this.add(tfEditWord);
				
				//create edit word button update
				MyButton btnUpdate = new MyButton("Update");
				btnUpdate.setBounds(1000, 285, 100, 25);
				btnUpdate.setFont(FontController.getInstance().getFont("seguisb"));
				btnUpdate.setFont(new Font(btnUpdate.getFont().getName(), Font.BOLD, 12));
				btnUpdate.setName("btnUpdate");
				btnUpdate.addActionListener(logics);
				this.add(btnUpdate);
				
				//create  word button delete
				MyButton btnDelete = new MyButton("Delete");
				btnDelete.setBounds(this.getWidth()-130, 285, 100, 25);
				btnDelete.setFont(FontController.getInstance().getFont("seguisb"));
				btnDelete.setFont(new Font(btnDelete.getFont().getName(), Font.BOLD, 12));
				btnDelete.setName("btnDelete");
				btnDelete.addActionListener(logics);
				this.add(btnDelete);
				
				
				
			FillWordList();
		
	}
	
	public void FillWordList(){
				
				
				
				//load words from database
				ResultSet result = DatabaseController.getInstance().runQuery("SELECT woord FROM woordenboek order by woord asc");
				try {
								
					
					while (result.next())
					{
						//create word panel			
						ColoredRectangle wordPanel = new ColoredRectangle(new Rectangle(sf.getWidth(),50), Color.gray);
						//create word label
						JLabel wordLabel = new JLabel(result.getString("woord"));
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
						editButton.setName("btnWordOutList#"+result.getString("woord"));
						//addclickevent
						editButton.addActionListener(logics);
						
						
						//add editlabel to wordpanel
						wordPanel.add(editButton);
						
						wordPanel.setLayout(null);
						//add wordpanel to scollfield
						sf.addElement(wordPanel);  

					}
					
				}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			
				
				this.add(sf);
				
				
		
	}
	
	public void refreshScrollObjects(){
		//remove all elements
		sf.removeAllElements();
		//refill wordlist
		FillWordList();
		
	}
	
	public String getNewWordsTF() {
		return this.tfNewWords.getText();
	}
	
	public void setEditWordTextField(String text){
		this.tfEditWord.setText(text);
	}
	
	public String getEditWordTextField(){
		return tfEditWord.getText();
	}
	
	public void emptyText(){
		tfNewWords.setText("");
	}
	
	public Gui getGui() {
		return this._gui;
	}
	
}