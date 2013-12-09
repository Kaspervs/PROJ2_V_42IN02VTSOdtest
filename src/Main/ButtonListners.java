package Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Schermen.CritisizeWords;
import Schermen.ManageWords;
import Schermen.ObserverSelectgame;
import Schermen.WordJudgement;


public class ButtonListners implements ActionListener  {
	private Main main;
	
	
	public ButtonListners(Main main) {
		this.main = main;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource(); 
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(source);
		
		
		switch (source.getName()) {
			case "manageWordsbtn":
				this.main.getGUI().changeScreen(new ManageWords(this.main.getGUI()));
				
				break;
			case "critisizeWordsbtn":
				this.main.getGUI().changeScreen(new CritisizeWords(this.main.getGUI()));
				break;
			case "CloseFrame":
				frame.dispose();
				break;
			case "CloseApp":
				System.exit(0);
				break;
			case "Logout":
				this.main.getGUI().showMessage("Dit is een test bericht die eigenlijk veel te lang is voor een logout message, maar puur bedoelt is om wordwrap te testen!", "Mededeling");
				break;
		}
	}

}
