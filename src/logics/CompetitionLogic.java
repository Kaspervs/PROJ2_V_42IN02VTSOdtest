package logics;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import FormElements.ImageLabel;
import Schermen.CompetitionManagement;

public class CompetitionLogic implements ActionListener {
	private CompetitionManagement cm;
	
	public CompetitionLogic(CompetitionManagement cm){
		this.cm = cm;
	}
	
	public void initMouseListener(final ImageLabel il){
		il.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				ImageLabel source = (ImageLabel) e.getSource(); 
		        for(int i=0; i<cm.getAlImageLabel().size(); i++){
		        	cm.getAlImageLabel().get(i).cR.setBackground(new Color(0,0,0), true);
		        }
		        source.cR.setBackground(new Color(0,114,198), true);
		        source.getParent().repaint();
			}

			public void mouseEntered(MouseEvent arg0){}

			public void mouseExited(MouseEvent arg0) {}

			public void mousePressed(MouseEvent arg0) {}

			public void mouseReleased(MouseEvent arg0) {}
			
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource(); 
		
		switch (source.getName()) {
                case "btnAdd":
                        System.out.println("add");
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