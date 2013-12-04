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


public class ManageWords extends JPanel {
	private Gui _gui;
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
		
	}
	
}