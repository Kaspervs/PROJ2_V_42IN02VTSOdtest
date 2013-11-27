package Schermen.chat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class ChatBalloon extends JLabel {
	private StringBuilder sb = new StringBuilder();
	
	private int width = 260;
	private int height = 100;
	private Dimension size = new Dimension(width, height);
	
	public ChatBalloon(String text, Color color, String font){

		setBackground(Color.green);
		createBalloon(text, color, font);
		
		System.out.println("width: "+getWidth());
	}
	
	private void createBalloon(String text, Color color, String font){
		// invoke HTML renderring in HTML aware components
        sb.append("<html>");
        // start (the body &) an ordered list
        // sb.append("<div style='padding: 4px 7px; background-color:rgb("+color.getRed()+", "+color.getGreen()+", "+color.getBlue()+");width:100%; ' >"
        sb.append("<p style='padding: 4px 7px; background-color:rgb("+color.getRed()+", "+color.getGreen()+", "+color.getBlue()+"); font-family:"+font+"; font-size: 11px; width:200px;' >"
        		//+ "<ul style='list-style-type:none;'>"
        		//+ "<li style='font-family: " + 
              //  font + "; font-size: 20px;'>"+
        		+text//+"</li>"
				//+ "</ul>"
				+ "</p>");                
        
        sb.append("</html>");
        this.setText(sb.toString());
	}
}
