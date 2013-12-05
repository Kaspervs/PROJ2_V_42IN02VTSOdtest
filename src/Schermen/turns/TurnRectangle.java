package Schermen.turns;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JLabel;

import utils.ImageTool;
import FormElements.ColoredRectangle;

@SuppressWarnings("serial")
public class TurnRectangle extends ColoredRectangle{

	private JLabel avatar;
	private String url = "/Assets/Images/default-avatar.png";
	
	public TurnRectangle(Rectangle rect, Color color){
		super(rect, color);
		avatar = ImageTool.getImageLabel(url, 49, 49);
		avatar.setLocation(8, 4);
		this.add(avatar);
	}
}
