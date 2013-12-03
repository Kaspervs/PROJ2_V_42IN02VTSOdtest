package FormElements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameLetter extends JPanel{
	private String Content = "";
	private Color bgColor;
	
	public GameLetter(Color background) {
		this.bgColor = background;
		this.setBackground(null);
		this.setBounds(0, 0, 34, 34);
	}
	
	@Override
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(this.bgColor);
		g2d.fillRoundRect(0, 0, 34, 34, 6, 6);
		g = g2d;
	}


	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}
}
