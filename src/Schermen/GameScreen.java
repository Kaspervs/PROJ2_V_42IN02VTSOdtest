package Schermen;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logics.ChatModel;
import Main.Gui;
import Schermen.chat.Chat;
import Schermen.gamescreen.GameField;
import Schermen.gamescreen.Hand;
import Schermen.gamescreen.TileDnDController;
import Schermen.score.ScoreScreen;
import Schermen.turns.TurnScreen;

public class GameScreen extends JPanel {
	//View
	private Gui _gui;
	private Chat chatScreen;
	private ChatModel chatModel;
	private GameField gameField;
	private ScoreScreen scoreScreen;
	private TurnScreen turnScreen;
	private Hand gameHand;
	private JLabel backButton;
	private ImageIcon backBtnImage = new ImageIcon(GameScreen.class.getResource("/Assets/Images/backBtn.png"));
	private TileDnDController tileController;
	
	public GameScreen(Gui g){
		this._gui = g;
		this.setBounds(0, 0, _gui.getWidth(), _gui.getHeight());
		this.setLayout(null);
		this.setBackground(null);
		//this.add(initChat());
		this.add(initScoreScreen());
		this.add(initTurnScreen());
		this.add(addBackButton());
		
		initGameField();
	}
	
	private JPanel initScoreScreen(){
		scoreScreen = new ScoreScreen(this);
		return scoreScreen;
	}
	
	private JPanel initChat(){
		chatScreen = new Chat(this);

		chatModel = new ChatModel();
		chatModel.addObserver(chatScreen);
		
		return chatScreen; 
	}
	
	private JPanel initTurnScreen(){
		turnScreen = new TurnScreen(this);
		return turnScreen;
	}
	
	private JLabel addBackButton(){
		backButton = new JLabel();
		backButton.setIcon(backBtnImage);
		backButton.setBounds(20, 26, 35, 35);
		backButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("return to Game overzicht");
				//_gui.changeScreen(new ObserverSelectgame(_gui));
			}
		});
		return backButton;		
	}
	
	
	
	
	private void initGameField(){
		gameField = new GameField(this);
		gameField.setBounds(364, 80, 560, 560);
		
		gameHand = new Hand(this);
		gameHand.setBounds(509, 659, 256, 34); 
		
		tileController = TileDnDController.getInstance();
		tileController.initTileController(this);

		this.add(gameHand);

		this.add(tileController);

		this.add(gameField);
	}
	
	public Gui getGui(){
		return this._gui;
	}
	
	public GameField getGameField(){
		return this.gameField;
	}
}
