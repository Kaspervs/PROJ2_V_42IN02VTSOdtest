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
				//Login verrifieren
//				ResultSet result = DatabaseController.getInstance().runQuery("SELECT * FROM account WHERE naam='"+l.getUsernameFieldText()+"' AND wachtwoord='"+l.getPasswordFieldText()+"'");
//				try {
//					boolean loggedIn = false;
//					while(result.next()) {
//						loggedIn = true;
//					}
//					
//					if(loggedIn)
//						this.l.getGui().changeScreen(new ObserverSelectgame(this.l.getGui()));
//					else
//						this.l.getGui().showMessage("The username and password you entered don't match to any known account.", "Login Incorrect");
//						
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}

				break;
		}
	}
}
