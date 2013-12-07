package Schermen.gamescreen;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import Schermen.GameScreen;

@SuppressWarnings("serial")
public class Hand extends JPanel {
	private ArrayList<Tile> handTiles = new ArrayList<Tile>();
	private GameScreen gameScreen;
	
	public Hand(GameScreen gameScreen) {
		this.gameScreen = gameScreen;

		this.setBackground(null);
		this.setLayout(null);
		this.setBounds(0, 0, 256, 34);
		this.generateField();
	}
	
	private void generateField() {
		for(int i = 0; i < 7; i++) {
			Tile temp = new Tile(new Color(243,240,235));
			temp.setBounds((int) (37 * i),0,34,34);
			handTiles.add(temp);
			this.add(temp);
		}
	}
}
