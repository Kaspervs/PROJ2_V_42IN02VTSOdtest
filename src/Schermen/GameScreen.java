package Schermen;

import javax.swing.JPanel;

import logics.ChatModel;
import Main.Gui;
import Schermen.chat.ChatScreen;

public class GameScreen extends JPanel {
	//View
	private Gui _gui;
	private ChatScreen chatScreen;
	private ChatModel chatModel;
	public GameScreen(Gui g){
		this._gui = g;
		this.setBounds(0, 0, _gui.getWidth(), _gui.getHeight());
		this.add(initChat());
		this.setBackground(null);
	}
	
	
	public JPanel initChat(){
		chatScreen = new ChatScreen(this);

		chatModel = new ChatModel();
		chatModel.addObserver(chatScreen);
		
		return chatScreen; 
	}
	
	public Gui getGui(){
		return this._gui;
	}
	//TODO add chat here
	//TODO add
}
