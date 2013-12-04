package logics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
			
				if(_manageWords.getNewWordsTF().isEmpty()||_manageWords.getNewWordsTF().contains("Create new word"))
				{
				 this._manageWords.getGui().showMessage("No word entered");
				}
				else if(_manageWords.getNewWordsTF().contains(" "))
				{
					this._manageWords.getGui().showMessage("The word must be written without any spaces.");
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
								//word doesn't exists.
							 //Add word to db
							if(sendWordtoDB(_manageWords.getNewWordsTF().toLowerCase(), "Accepted"))
							{
								_manageWords.getGui().showMessage("Word succesfully added.");
								//empty textfield
								_manageWords.emptyText(); 
							}
							else
							{
								_manageWords.getGui().showMessage("Error trying to add the word.");
							}
							//toevoegen db
						}
						else
						{
							
								_manageWords.getGui().showMessage("The word you entered already exists.");
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
	
	
	private boolean sendWordtoDB(String word, String status){
		//send the word to the database
		
		DatabaseController.getInstance().startPreparedStatement("INSERT INTO woordenboek(`woord`, `status`) VALUES ( ?, ?)");
		PreparedStatement statement = DatabaseController.getInstance().getPreparedStatement();
		try {
			statement.setString(1, word);
			statement.setString(2, status);
			DatabaseController.getInstance().setPreparedStatement(statement);
			DatabaseController.getInstance().runPreparedStatement();
			return true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
	}
}
				
				
		
	

