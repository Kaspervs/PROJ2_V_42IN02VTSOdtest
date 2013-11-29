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
	
	public ChatBalloon(String text, Color color, Font font){
		setFont(font);
		setFont(new Font(getFont().getName(), Font.BOLD, 11));
		createBalloon(text, color, font.getName());
		
	}
	
	private void createBalloon(String text, Color color, String font){
		// invoke HTML renderring in HTML aware components
        sb.append("<html>");

        sb.append("<div style='padding: 4px 7px; margin-bottom:10px; background-color:rgb("+color.getRed()+", "+color.getGreen()+", "+color.getBlue()+"); font-family:'"+font+"'; font-size: 11px;' WIDTH='"+width+"'>");
        	sb.append("<div style='margin-bottom:4px;'>You:</div> ");
        	sb.append(text);
        	sb.append("<div style='margin-top:4px;'>10:24, 11/11/2013</div>");
		sb.append("</div>");
		
        sb.append("</html>");
        this.setText(sb.toString());
	}
}
