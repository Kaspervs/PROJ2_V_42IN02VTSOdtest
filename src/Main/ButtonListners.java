package Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Schermen.Login;


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
			case "CloseFrame":
				frame.dispose();
				break;
			case "CloseApp":
				System.exit(0);
				break;
			case "Logout":
				this.main.getGUI().showMessage("Logged out", "Logged out");
				this.main.getGUI().changeScreen(new Login(this.main.getGUI()));

				break;
		}
	}

}
