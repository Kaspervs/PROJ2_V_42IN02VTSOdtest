package FormElements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ColoredRectangle extends JPanel {
	public ColoredRectangle(Rectangle Rect, Color Color) {
		this.setBounds(Rect);
		this.setBackground(Color);
		
		this.repaint();
	}
	
	public void setBackground(Color bg, boolean doRepaint){
		this.setBackground(bg);
		/*if(doRepaint){
			this.repaint();
		}*/
	}
}
