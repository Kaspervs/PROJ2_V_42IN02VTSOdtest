package logics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import FormElements.ImageLabel;
import FormElements.MyButton;
import Main.DatabaseController;
import Schermen.CompetitionManagement;
import Schermen.ObserverSelectgame;

public class CompetitionLogic implements ActionListener {
	private CompetitionManagement cm;
	private ArrayList<MyButton> btnList;
	
	public CompetitionLogic(CompetitionManagement cm){
		this.cm = cm;
		this.btnList = new ArrayList<MyButton>();
	}
	
	public void initMouseListener(final ImageLabel il){
		il.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				toggleColor(il);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void toggleColor(ImageLabel iL){
		if(!iL.isTriggered()){
				iL.cR.setBackground(new Color(0,114,198));
		}else{
				iL.cR.setBackground(new Color(0,0,0));
		}
		iL.setTriggered(!iL.isTriggered());
		iL.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource(); 
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(source);
        
        switch (source.getName()) {
                case "btnAdd":
                        System.out.println("add");
                        break;
        }
	}
}