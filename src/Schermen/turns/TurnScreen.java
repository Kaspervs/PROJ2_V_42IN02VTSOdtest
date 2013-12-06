package Schermen.turns;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Schermen.GameScreen;

@SuppressWarnings("serial")
public class TurnScreen extends JPanel {
	//View
	private GameScreen _parent;
	private Rectangle bounds = new Rectangle(20, 67, 260, 533);
	private TurnPanel ytp;
	private TurnPanel ttp;
	private ArrayList<Integer> colors =new ArrayList<Integer>(Arrays.asList(0x2D74AE,0x15992A,0xB81B1B, 0xC37920));
	private int countRects = 0; 
	
	public TurnScreen(GameScreen p){
		_parent = p;
		setBackground(null);
		setBounds(bounds);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		this.add(initYourTurnPanel());
		addTurnRect(ytp);
		addTurnRect(ytp);
		
		this.add(initTheirTurnPanel());
		addTurnRect(ttp);
		addTurnRect(ttp);
	}
	
	private void addTurnRect(TurnPanel p){
		Rectangle b = new Rectangle(0, 0, 260, 57);
		Color color = new Color(colors.get(countRects));
		TurnRectangle tr = new TurnRectangle(b, color);
		
		p.addTurnRectangle(tr);
		countRects++;
	}

	public JPanel initYourTurnPanel(){
		ytp = new TurnPanel("Your turn");
		return ytp;
	}
	
	public JPanel initTheirTurnPanel(){
		ttp = new TurnPanel("Their turn");
		ttp.setLocation(0, ytp.getHeight());
		return ttp;
	}
	
	public TurnPanel getYourTurnPanel() {
		return ytp;
	}

	public TurnPanel getTheirTurnPanel() {
		return ttp;
	}
}
