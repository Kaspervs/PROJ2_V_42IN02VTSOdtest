package logics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import FormElements.ColoredRectangle;
import FormElements.ImageLabel;
import Schermen.CompetitionManagement;

public class CompetitionLogic {
	private CompetitionManagement cm;
	
	public CompetitionLogic(CompetitionManagement cm){
		this.cm = cm;
	}
	
	public void initLabelMouseListener(final ImageLabel il){
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
	
	/*public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == avgBtn) {
	        computeAverage();
	        panel.repaint();
	    }
	}*/
}