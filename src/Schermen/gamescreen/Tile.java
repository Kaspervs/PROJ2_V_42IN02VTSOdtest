package Schermen.gamescreen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import FormElements.GameLetter;
import Main.FontController;

@SuppressWarnings("serial")
public class Tile extends JPanel implements MouseListener, Cloneable {
	private GameLetter gl;
	private String text;
	private final static String EMPTY_VALUE = "--";
	private final static String START_VALUE = "*";
	
	private boolean isDrag = false;
	
	public Tile(Color bgcolor) {
		this.setBackground(null);
		this.setBounds(0, 0, 34, 34);
		
		gl = new GameLetter(bgcolor);

		this.add(gl);
	}
	
	public Tile(Color bgcolor, String txt) {
		this.setBackground(null);
		this.setBounds(0, 0, 34, 34);
		this.text = txt.equals(EMPTY_VALUE) || txt.equals(START_VALUE) ? "" : txt;
		
		JLabel contentText = new JLabel(text, SwingConstants.CENTER);
		contentText.setForeground(Color.white);
		contentText.setBounds(0,0,34,34);
		contentText.setFont(FontController.getInstance().getFont("seguisb"));
		contentText.setFont(new Font(contentText.getFont().getName(), Font.PLAIN, 18));
		this.add(contentText);
		gl = new GameLetter(bgcolor);
		this.add(gl);
	}

	public boolean isDrag() {
		return isDrag;
	}

	public void setDrag(boolean isDrag) {
		this.isDrag = isDrag;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("click");
	}

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("point : "+e.getPoint());
		TileDnDController.getInstance().addTile(this);
		System.out.println("press");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//setDrag(false);
	//	TileController.getInstance().removeTile();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
