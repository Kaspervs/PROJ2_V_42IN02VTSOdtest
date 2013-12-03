package Schermen.gamescreen;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import Game.Tile;
import Schermen.GameScreen;

@SuppressWarnings("serial")
public class GameField extends JPanel {
	private ArrayList<Tile> gameTiles = new ArrayList<Tile>();
	private GameScreen gameScreen;
	
	public GameField(GameScreen gameScreen) {
		this.gameScreen = gameScreen;

		this.setBackground(null);
		this.setLayout(null);
		this.setBounds(0, 0, 558, 558);
		this.generateField();
	}
	
	private void generateField() {
		for(int i = 0; i < 225; i++) {
			Tile temp = new Tile(new Color(44,47,54));
			temp.setBounds((int) (37 * (i - (Math.floor(i / 15) * 15))),(int) (Math.floor(i / 15) * 37),36,36);
			gameTiles.add(temp);
			this.add(temp);
		}
	}
}
