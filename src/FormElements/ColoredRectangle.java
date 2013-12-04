package FormElements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ColoredRectangle extends JPanel {
	public ColoredRectangle(Rectangle Rect, Color Color) {
		this.setBounds(Rect);
		this.setPreferredSize(new Dimension(Rect.width, Rect.height));
		this.setBackground(Color);
		
		this.repaint();
	}
}
