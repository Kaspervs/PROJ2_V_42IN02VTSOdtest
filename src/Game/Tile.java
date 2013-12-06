package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import FormElements.GameLetter;
import Main.FontController;

@SuppressWarnings("serial")
public class Tile extends JPanel {
	private GameLetter gl;
	
	public Tile(Color bgcolor) {
		this.setBackground(null);
		this.setBounds(0, 0, 34, 34);
		
		gl = new GameLetter(bgcolor);
		this.add(gl);
	}
	
	public Tile(Color bgcolor, String text) {
		this.setBackground(null);
		this.setBounds(0, 0, 34, 34);
		

		JLabel contentText = new JLabel(text, SwingConstants.CENTER);
		contentText.setForeground(Color.white);
		contentText.setBounds(0,0,34,34);
		contentText.setFont(FontController.getInstance().getFont("seguisb"));
		contentText.setFont(new Font(contentText.getFont().getName(), Font.PLAIN, 18));
		this.add(contentText);
		
		gl = new GameLetter(bgcolor);
		this.add(gl);
	}
}
