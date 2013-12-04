package Schermen;

import javax.swing.JPanel;

import logics.ChatModel;
import Main.Gui;
import Schermen.chat.ChatScreen;
import Schermen.gamescreen.GameField;
import Schermen.gamescreen.Hand;
import Schermen.score.ScoreScreen;

public class GameScreen extends JPanel {
	//View
	private Gui _gui;
	private ChatScreen chatScreen;
	private ChatModel chatModel;
	private GameField gameField;
	private ScoreScreen scoreScreen;
	private Hand gameHand;
	public GameScreen(Gui g){
		this._gui = g;
		this.setBounds(0, 0, _gui.getWidth(), _gui.getHeight());
		this.add(initChat());
		this.setBackground(null);
		initGameField();
		initScoreScreen();
	}
	
	private void initScoreScreen(){
		scoreScreen = new ScoreScreen(this);
		this.add(scoreScreen);
	}
	
	private JPanel initChat(){
		chatScreen = new ChatScreen(this);

		chatModel = new ChatModel();
		chatModel.addObserver(chatScreen);
		
		return chatScreen; 
	}
	
	private void initGameField(){
		gameField = new GameField(this);
		gameField.setBounds(364, 80, 560, 560);
		
		gameHand = new Hand(this);
		gameHand.setBounds(509, 659, 256, 34); 
		
		this.add(gameField);
		this.add(gameHand);
	}
	
	public Gui getGui(){
		return this._gui;
	}
	//TODO add chat here
}
