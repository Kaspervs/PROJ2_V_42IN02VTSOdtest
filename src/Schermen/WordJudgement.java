package Schermen;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logics.LoginLogics;
import FormElements.MyButton;
import FormElements.TextFieldSL;
import Main.DatabaseController;
import Main.FontController;
import Main.Gui;


public class WordJudgement extends JPanel {
	private Gui _gui;
	public WordJudgement(Gui gui){
		
		this._gui = gui;
		this.setBackground(null);
		this.setBounds(0, 0, gui.getWidth(), gui.getHeight());
		
		//Avans Logo
				ImageIcon AvansLogo = new ImageIcon(getClass().getResource("/Assets/Images/Avans-logo.png"));
				JLabel AvansLabel = new JLabel(AvansLogo);
				AvansLabel.setBounds(20,gui.getHeight() - 21 - AvansLogo.getIconHeight(), AvansLogo.getIconWidth(), AvansLogo.getIconHeight());
				this.add(AvansLabel);
				
				//wordjugdement tekst
				JLabel welkomText = new JLabel("Wordjudgement");
				welkomText.setForeground(Color.white);
				welkomText.setBounds(500,120,350,55);
				welkomText.setFont(FontController.getInstance().getFont("segoeuil"));
				welkomText.setFont(new Font(welkomText.getFont().getName(), Font.PLAIN, 42));
				this.add(welkomText);
				
				//Button Managewords
				
				MyButton manageWordsbtn = new MyButton("Manage words");
				manageWordsbtn.setBounds(693, 292, 101, 27);
				manageWordsbtn.setFont(FontController.getInstance().getFont("seguisb"));
				manageWordsbtn.setFont(new Font(manageWordsbtn.getFont().getName(), Font.BOLD, 12));
				manageWordsbtn.setName("manageWordsbtn");
				manageWordsbtn.addActionListener(_gui.getMain().getBtnListner());
				this.add(manageWordsbtn);
	}
	
}
