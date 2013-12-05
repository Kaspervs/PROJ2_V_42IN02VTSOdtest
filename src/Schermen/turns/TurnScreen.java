package Schermen.turns;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JPanel;

import Schermen.GameScreen;

public class TurnScreen extends JPanel {
	//View
	private GameScreen _parent;
	private Rectangle bounds = new Rectangle(20, 67, 260, 533);
	
	public TurnScreen(GameScreen p){
		_parent = p;
		setBounds(bounds);
		addTurnRect();
	}
	
	private void addTurnRect(){
		Rectangle b = new Rectangle(0, 0, 260, 57);
		Color color = new Color(0x2D74AE);
		TurnRectangle tr = new TurnRectangle(b, color);
		this.add(tr);
	}
	
}
