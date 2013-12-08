package FormElements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ColoredRectangle extends JPanel {
	private Color color;
	
	public ColoredRectangle(Rectangle Rect, Color Color) {
		this.color = Color;
		this.setBounds(Rect);
		this.setPreferredSize(new Dimension(Rect.width, Rect.height));
		this.setBackground(Color);
		
		this.repaint();
	}
	
	public Color getColor() {
		return color;
	}

	public void setBackground(Color bg, boolean doRepaint){
        this.setBackground(bg);
        /*if(doRepaint){
                this.repaint();
        }*/
	}
}
