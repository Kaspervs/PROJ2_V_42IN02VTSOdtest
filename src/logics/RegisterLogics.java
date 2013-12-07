package logics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.mysql.jdbc.PreparedStatement;

import Main.DatabaseController;
import Schermen.Login;
import Schermen.Register;

public class RegisterLogics implements ActionListener{
	private Register r;
	
	public RegisterLogics(Register r) {
		this.r = r;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource(); 
		
		switch (source.getName()) {
			case "createAccBtn":
				ResultSet result = DatabaseController.getInstance().runQuery("SELECT * FROM account WHERE naam='"+r.getUsernameFieldText()+"'");
			try {
				if (!result.next() ) {
					if (r.getUsernameFieldText() != null) {
						if (r.getPasswordFieldText() != null){
							DatabaseController.getInstance().insertQuery("INSERT INTO account (naam,wachtwoord) VALUES ('"+r.getUsernameFieldText()+"','"+r.getPasswordFieldText()+"')");
							this.r.getGui().showMessage("Account created, you can log in now.");
							this.r.getGui().changeScreen(new Login(this.r.getGui()));
						}
						else
							this.r.getGui().showMessage("Password cannot be empty.");
					}
					else
						this.r.getGui().showMessage("Username cannot be empty");
				}
				else
					this.r.getGui().showMessage("The username already exists");
			} 
				catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}						
				break;
				
			case "backBtn":
				this.r.getGui().changeScreen(new Login(this.r.getGui()));
				break;

		}
	}
}
	

