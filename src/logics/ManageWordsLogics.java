package logics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Main.DatabaseController;
import Schermen.Login;
import Schermen.ManageWords;
import Schermen.ObserverSelectgame;

public class ManageWordsLogics implements ActionListener{
	private ManageWords _manageWords;

	public ManageWordsLogics(ManageWords m){ 
		this._manageWords = m;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource(); 
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(source);
		switch (source.getName()) {
		
		
			case "btnCreateWord":
				//kijken of wel een woord is en geen lege text
				if(_manageWords.getNewWordsTF().isEmpty())
				{
				
				}
				else
				{
					//kijken of woord nog niet bestaat
					ResultSet result = DatabaseController.getInstance().runQuery("SELECT * FROM woordenboek WHERE woord='"+_manageWords.getNewWordsTF()+ "'");
					try {
						boolean Exist = false;
						while(result.next()) {
							Exist = true;
						}
						if(Exist==false)
						{
								//hier woord toevoegen aan db.
						}
						else
						{
								//this.l.getGui().showMessage("The username and password you entered don't match to any known account.", "Login Incorrect");
						}
						
						
					}
					catch (SQLException e1) {
						// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				}
				break;
			case "waanders":
				break;
			default:
				break;
			
		
		}
				
	}
}
				
				
		
	

