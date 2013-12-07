package Schermen.gamescreen;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import Main.DatabaseController;
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
		ResultSet rs = DatabaseController.getInstance().runQuery("SELECT * FROM tegel WHERE Bord_naam='Standard'");
			
		try {
			while(rs.next()){
				Tile temp = new Tile(this.getColorForTileType(rs.getString("TegelType_soort")), rs.getString("TegelType_soort"));
				temp.setBounds((int) (37 * (rs.getInt("X") - 1)),(int) (37 * (rs.getInt("Y") - 1)),36,36);
				gameTiles.add(temp);
				this.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Color getColorForTileType(String type) {
		switch (type) {
			case "*": 
				return new Color(85,61,87);
			case "DL": 
				return new Color(121,161,109);
			case "DW": 
				return new Color(195,121,32);
			case "TL": 
				return new Color(31,142,161);
			case "TW": 
				return new Color(142,77,39);
			default:
				return new Color(44,47,54);
		}
	}
}
