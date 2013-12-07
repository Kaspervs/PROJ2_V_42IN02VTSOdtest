package logics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import FormElements.ImageLabel;
import Schermen.CompetitionManagement;
import Schermen.NewGame;

public class CompetitionLogic implements ActionListener {
	private CompetitionManagement cm;
	
	public CompetitionLogic(CompetitionManagement cm){
		this.cm = cm;
	}
	
	public void initMouseListener(final ImageLabel il){
		il.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e){}

			public void mouseExited(MouseEvent e) {}

			public void mousePressed(MouseEvent e) {
				
			}

			public void mouseReleased(MouseEvent e) {
				ImageLabel source = (ImageLabel) e.getSource(); 
				for(int i=0; i<cm.getAlImageLabel().size(); i++){
					if(e.getSource() != cm.getAlImageLabel().get(i)){
						cm.getAlImageLabel().get(i).cR.setBackground(new Color(0,0,0), true);
						cm.getAlImageLabel().get(i).setTriggered(false);
					}
				}
				if(source.isTriggered()){
					source.cR.setBackground(Color.gray, true);
					source.setTriggered(false);
				}else{
					source.cR.setBackground(new Color(0,114,198), true);
					source.setTriggered(true);
				}
				source.getParent().repaint();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource(); 
		
		switch (source.getName()) {
                case "btnAdd":
                        cm.get_gui().changeScreen(new NewGame());
                        break;
                case "btnEdit":
                	System.out.println("edit");
                	break;
                case "btnCreate":
                	System.out.println("create");
                	break;
                case "btnBack":
                	System.out.println("back");
                	break;
                case "btnLogout":
                	System.out.println("logout");
                	break;
        }
	}
}