package Game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import FormElements.GameLetter;

@SuppressWarnings("serial")
public class Tile extends JPanel {
	private GameLetter gl;
	
	public Tile(Color bgcolor) {
		this.setBackground(null);
		this.setBounds(0, 0, 34, 34);
		
		gl = new GameLetter(bgcolor);
		this.add(gl);
	}
}
