package Schermen.turns;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;

import utils.ImageTool;
import FormElements.ColoredRectangle;
import Main.FontController;

@SuppressWarnings("serial")
public class TurnRectangle extends ColoredRectangle{

	private JLabel text;
	private JLabel avatar;
	private String url = "/Assets/Images/default-avatar.png";
	private Font font; 
	private int gameID = 0;
	public TurnRectangle(Rectangle rect, Color color){
		super(rect, color);
		font = FontController.getInstance().getSegoeSemiBold();
		avatar = ImageTool.getImageLabel(url, 49, 49);
		avatar.setLocation(8, 4);
		this.add(avatar);
		this.add(initText());
	}
	
	private JLabel initText(){
		text = new JLabel();
		setLabelText("Thomas", 12, 9, 3);
		text.setBounds(new Rectangle(65, 6, 187, 42));
		text.setFont(font);
		text.setFont(new Font(text.getFont().getName(), Font.TRUETYPE_FONT, 11));
		text.setForeground(Color.white);
		return text;
	}
	
	public void setLabelText(String name, int playedGames, int wins, int loses){
		text.setText("<html>Playing with "+name+"<br>Played "+playedGames+" games,<br>"+wins+" wins and "+loses+" loses</html>");
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
}
