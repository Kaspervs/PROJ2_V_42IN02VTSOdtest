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
	private String oldWord = "";
	
	public ManageWordsLogics(ManageWords m){ 
		this._manageWords = m;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource(); 
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(source);
		switch (source.getName()) {
			case "btnCreateWord":
				createWord();
				break;
			case "btnUpdate":
				updateWord();
				break;
			case "btnDelete":
				deleteWord();
				break;
			case "btnSearch":
				
				searchWord();
				break;
			default:
				editWord(source.getName());
				break;
			
		
		}
				
	}
	
	private void searchWord(){
		//get word from textfield
		
		String searchWord = _manageWords.getStringSearchField();
	
		_manageWords.refreshScrollObjects("SELECT woord FROM woordenboek WHERE woord like '%"+searchWord+ "%'");
			
			
	}
	
	private void deleteWord(){
		//delete word
		try {
			if(oldWord.length()==0 || _manageWords.getEditWordTextField().length()==0)
			{
				this._manageWords.getGui().showMessage("No word to delete");
			}
			else
			{
				
			DatabaseController.getInstance().startPreparedStatement("DELETE FROM woordenboek WHERE woord=(?)");
			PreparedStatement statement = DatabaseController.getInstance().getPreparedStatement();
		
				statement.setString(1, oldWord);
				DatabaseController.getInstance().setPreparedStatement(statement);
				DatabaseController.getInstance().runPreparedStatement();
				this._manageWords.getGui().showMessage("Succefully deleted: "+ oldWord, "Succeded");
				_manageWords.refreshScrollObjects("SELECT woord FROM woordenboek order by woord asc");
				oldWord="";
				_manageWords.setEditWordTextField("");
			}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				this._manageWords.getGui().showMessage("Delete command did not function");
			}
	}
	
	private void editWord(String word){
		
		//Check if word is from editbutton of wordlist
		if(word.startsWith("btnWordOutList"))
		{
			String[] splittedString = word.split("#");
			_manageWords.setEditWordTextField(splittedString[1].toString());
			oldWord = splittedString[1].toString();
		}
	}
	
	private void updateWord(){
		//put new word in  local var
		String newWord = _manageWords.getEditWordTextField();
		
		if(checkWord(newWord))
		{
			
			if(oldWord.length()==0)
			{
				this._manageWords.getGui().showMessage("Must edit word with edit button. You can't just type any word in here.");
			}
			else
			{
				
				try {
					//prepare query
				DatabaseController.getInstance().startPreparedStatement("UPDATE woordenboek SET woord=(?) where woord=(?)");
				PreparedStatement statement = DatabaseController.getInstance().getPreparedStatement();
				
					statement.setString(1, newWord);
					statement.setString(2, oldWord);
					DatabaseController.getInstance().setPreparedStatement(statement);
					DatabaseController.getInstance().runPreparedStatement();
					
					//empty old word
					oldWord = "";
					//empty textfield
					_manageWords.setEditWordTextField("");
					//Show succes message
					this._manageWords.getGui().showMessage("Word succesfully edited.", "Succeded");
					_manageWords.refreshScrollObjects("SELECT woord FROM woordenboek order by woord asc");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					this._manageWords.getGui().showMessage("Error editing word.");
				}
			}
		}
	}
	
	private boolean sendWordtoDB(String word, String status){
		//send the word to the database
		try {
		DatabaseController.getInstance().startPreparedStatement("INSERT INTO woordenboek(`woord`, `status`) VALUES ( ?, ?)");
		PreparedStatement statement = DatabaseController.getInstance().getPreparedStatement();
	
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
	
	private boolean checkWord(String word){
		//kijken of wel een woord is en geen lege text
		
				if(word.isEmpty())
				{
				 this._manageWords.getGui().showMessage("No word entered");
				}
				else if(word.contains(" "))
				{
					this._manageWords.getGui().showMessage("The word must be written without any spaces.");
				}
				else
				{
					//kijken of woord nog niet bestaat
					
					try {
						ResultSet result = DatabaseController.getInstance().runQuery("SELECT * FROM woordenboek WHERE woord='"+word+ "'");
						boolean Exist = false;
						
						while(result.next()) {
							Exist = true;
						}
						if(Exist==false)
						{
								return true; //word does not exists.
						}
						else
						{
							
								_manageWords.getGui().showMessage("The word you entered already exists.");
								return false; //word does exists.
						}
						
						
					}
					catch (SQLException e1) {
						// TODO Auto-generated catch block
					e1.printStackTrace();
					
					}
				}
				
				return false;
		
	}
	
	private void createWord(){
		

				if(checkWord(_manageWords.getNewWordsTF().toLowerCase()))
				{
						
					 //Add word to db
					if(sendWordtoDB(_manageWords.getNewWordsTF().toLowerCase(), "Accepted"))
					{
						_manageWords.getGui().showMessage("Word succesfully added.","Succeded");
						//empty textfield
						_manageWords.emptyText(); 
						//wordlist refreshen
						_manageWords.refreshScrollObjects("SELECT woord FROM woordenboek order by woord asc");
					}
					else
					{
						_manageWords.getGui().showMessage("Error trying to add the word.");
					}
					
				}
				
				
				
			
			
	}
		

}
				
				
		
	

