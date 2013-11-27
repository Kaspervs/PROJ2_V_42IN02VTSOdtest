package Main;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DragHandle extends JPanel implements MouseListener, MouseMotionListener {
	private JFrame gui;
	private Point mouseStartLocation, windowStartLocation;
	
	public DragHandle(JFrame gui) {
		this.gui = gui;
		this.setBackground(null);
		this.setBounds(gui.getContentPane().getInsets().left, gui.getContentPane().getInsets().top, (gui.getWidth()- gui.getContentPane().getInsets().right - gui.getContentPane().getInsets().left), 25 - gui.getContentPane().getInsets().top);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.mouseStartLocation != null) {
			Point offset = new Point(e.getXOnScreen() - this.mouseStartLocation.x, e.getYOnScreen() - this.mouseStartLocation.y);
			Point NmouseL = new Point(windowStartLocation.x + offset.x, windowStartLocation.y + offset.y);
			this.gui.setLocation(NmouseL);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.mouseStartLocation = e.getLocationOnScreen();
		this.windowStartLocation = this.gui.getLocation();
	}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
