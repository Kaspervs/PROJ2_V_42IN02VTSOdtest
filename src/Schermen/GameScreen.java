package Schermen;

import javax.swing.JPanel;

import Main.Gui;
import Schermen.chat.ChatScreen;

public class GameScreen extends JPanel {
	//View
	private Gui _gui;
	private ChatScreen chatScreen;
	
	public GameScreen(Gui g){
		this._gui = g;
		this.setBounds(0, 0, _gui.getWidth(), _gui.getHeight());
		this.add(initChat());
	}
	
	
	public JPanel initChat(){
		chatScreen = new ChatScreen(this);
		
		return chatScreen; 
	}
	
	public Gui getGui(){
		return this._gui;
	}
	//TODO add chat here
	//TODO add
}
