package Schermen;

import javax.swing.JPanel;

import logics.ChatModel;
import Main.Gui;
import Schermen.chat.ChatScreen;
import Schermen.gamescreen.GameField;
import Schermen.gamescreen.Hand;
import Schermen.score.ScoreScreen;
import Schermen.turns.TurnScreen;

public class GameScreen extends JPanel {
	//View
	private Gui _gui;
	private ChatScreen chatScreen;
	private ChatModel chatModel;
	private GameField gameField;
	private ScoreScreen scoreScreen;
	private TurnScreen turnScreen;
	private Hand gameHand;
	
	public GameScreen(Gui g){
		this._gui = g;
		this.setBounds(0, 0, _gui.getWidth(), _gui.getHeight());
		this.setBackground(null);
		//this.add(initChat());
		this.add(initScoreScreen());
		this.add(initTurnScreen());
		initGameField();
	}
	
	private JPanel initScoreScreen(){
		scoreScreen = new ScoreScreen(this);
		return scoreScreen;
	}
	
	private JPanel initChat(){
		chatScreen = new ChatScreen(this);

		chatModel = new ChatModel();
		chatModel.addObserver(chatScreen);
		
		return chatScreen; 
	}
	
	private JPanel initTurnScreen(){
		turnScreen = new TurnScreen(this);
		return turnScreen;
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
