package Schermen.turns;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.FontController;

public class TurnPanel extends JPanel {

	private JLabel head;
	private int startHeight = 0;
	private int padding = 20;
	private int maximumRects = 2;
	private ArrayList<TurnRectangle> turnRectangles = new ArrayList<TurnRectangle>();
	
	public TurnPanel(String headTxt){
		setSize(new Dimension(260,130));
		setBackground(null);
		this.add(initHead(headTxt));
		
		startHeight = head.getHeight();
	}
	
	private JLabel initHead(String txt){
		Font font = FontController.getInstance().getSegoeLight();
		head = new JLabel(txt);
		head.setForeground(Color.white);
		head.setSize(260, 47);
		head.setFont(font);
		head.setFont(new Font(head.getFont().getName(), Font.TRUETYPE_FONT, 42));
		return head;
	}
	
	public void addTurnRectangle(TurnRectangle tr){
		if(turnRectangles.size() == maximumRects) return;
		turnRectangles.add(tr);
		
		this.add(tr);
		int y = startHeight + (padding * turnRectangles.size()) + (tr.getHeight() * (turnRectangles.size()-1));
		tr.setLocation(0, y);
		setSize(260, y+tr.getHeight() + padding);
	}
}
