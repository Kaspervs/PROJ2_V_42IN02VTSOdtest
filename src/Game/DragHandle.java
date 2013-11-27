package Game;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import Main.Gui;

public class DragHandle extends JPanel implements MouseMotionListener {
	private Gui gui;
	
	public DragHandle(Gui gui) {
		this.gui = gui;
		this.setBackground(Color.red);
		this.setBounds(0, 0, gui.getWidth(), 25);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		this.gui.setLocation(arg0.getLocationOnScreen());
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}

}
