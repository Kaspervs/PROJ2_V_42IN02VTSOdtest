package logics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Main.DatabaseController;
import Schermen.ObserverSelectgame;
import Schermen.PlayerManagement;
import Schermen.Register;

public class PlayerManagementLogics implements ActionListener {

	private PlayerManagement A;
	
	public PlayerManagementLogics(PlayerManagement A){
		this.A = A;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource(); 
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(source);
		
		
		switch (source.getName()) {
		/**
		 * Login code
		 */
			case "saveAccBtn":
				
				ResultSet result = DatabaseController.getInstance().runQuery("SELECT * FROM account WHERE wachtwoord='"+A.getPasswordA()+"'");
				try {
					boolean loggedIn = false;
					while(result.next()) {
						loggedIn = true;
					}
					
					if(loggedIn)
						this.A.getGui().changeScreen(new ObserverSelectgame(this.A.getGui()));
					else
						this.A.getGui().showMessage("The username and password you entered don't match to any known account.", "Login Incorrect");
						
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				break;
			case "backBtn":
				this.A.getGui().changeScreen(new Register(this.A.getGui()));
				break;
		}
	}
	
}
