package Schermen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
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
	private TextFieldSL tfNewWords;
	private ScrollField scrlField;
	
	public ManageWords(Gui gui){
		
		this._gui = gui;
		this.setBackground(null);
		this.setBounds(0, 0, gui.getWidth(), gui.getHeight());
		
		//Avans Logo
				ImageIcon AvansLogo = new ImageIcon(getClass().getResource("/Assets/Images/Avans-logo.png"));
				JLabel AvansLabel = new JLabel(AvansLogo);
				AvansLabel.setBounds(20,gui.getHeight() - 21 - AvansLogo.getIconHeight(), AvansLogo.getIconWidth(), AvansLogo.getIconHeight());
				this.add(AvansLabel);
				
				//welkom tekst
				JLabel welkomText = new JLabel("Manage words");
				welkomText.setForeground(Color.white);
				welkomText.setBounds(500,120,350,55);
				welkomText.setFont(FontController.getInstance().getFont("segoeuil"));
				welkomText.setFont(new Font(welkomText.getFont().getName(), Font.PLAIN, 42));
				this.add(welkomText);	
				
				//create new words label
				JLabel createWords = new JLabel("Create new words");
				createWords.setForeground(Color.white);
				createWords.setBounds(50,205,260,55);
				createWords.setFont(FontController.getInstance().getFont("segoeuil"));
				createWords.setFont(new Font(createWords.getFont().getName(), Font.BOLD, 20));
				this.add(createWords);	
				
				//new words inputfield
				tfNewWords = new TextFieldSL("Create new word");
				tfNewWords.setBounds(50, 250, 170, 30);
				tfNewWords.setFont(FontController.getInstance().getFont("seguisb"));
				tfNewWords.setFont(new Font(tfNewWords.getFont().getName(), Font.BOLD, 12));
				this.add(tfNewWords);
				
				//add new word button
				MyButton btnCreateWord = new MyButton("Create new word");
				btnCreateWord.setBounds(75, 285, 120, 25);
				btnCreateWord.setFont(FontController.getInstance().getFont("seguisb"));
				btnCreateWord.setFont(new Font(btnCreateWord.getFont().getName(), Font.BOLD, 12));
				btnCreateWord.setName("btnCreateWord");
				btnCreateWord.addActionListener(logics);
				this.add(btnCreateWord);
				
				//scrollpanel
				
				ScrollField sf = new ScrollField(new Dimension(200,500));
				sf.setBounds(400,200,200,300);
				
				
				

				
				for(int i = 0; i < 20; i++) {  
					ColoredRectangle temp = new ColoredRectangle(new Rectangle(200,50), Color.red);
					temp.setLayout(null);
					sf.addElement(temp);  
			    } 
				
				this.add(sf);
				
		
	}
	
	public String getNewWordsTF() {
		return this.tfNewWords.getText();
	}
	
	public void emptyText(){
		tfNewWords.setText("");
	}
	
	public Gui getGui() {
		return this._gui;
	}
	
}