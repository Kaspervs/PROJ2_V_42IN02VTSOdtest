package Schermen.chat;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;


@SuppressWarnings("serial")
public class ChatBalloon extends JLabel {
	private StringBuilder sb = new StringBuilder();
	
	private int width = 260;
	private Date _date = new Date();
	private SimpleDateFormat ft = new SimpleDateFormat("HH:mm, dd/MM/yyyy");
	
	public ChatBalloon(String text, Color color, Font font){
		setFont(font);
		setFont(new Font(getFont().getName(), Font.TRUETYPE_FONT, 11));
		setForeground(new Color(255,255,255));// font color
		createBalloon(text, ft.format(_date), color, font.getName());
		
	}
	public ChatBalloon(String text, String date, Color color, Font font){
		setFont(font);
		setFont(new Font(getFont().getName(), Font.TRUETYPE_FONT, 11));
		setForeground(new Color(255,255,255));// font color
		try {
			createBalloon(text, modifyDateLayout(date), color, font.getName());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	
	private String modifyDateLayout(String inputDate) throws ParseException{
	    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(inputDate);
	    return new SimpleDateFormat("HH:mm, dd/MM/yyyy").format(date);
	}
	
	
	private void createBalloon(String text, String date, Color color, String font){
		// invoke HTML renderring in HTML aware components
        sb.append("<html>");

        sb.append("<div style='padding: 4px 7px; margin-bottom:10px; background-color:rgb("+color.getRed()+", "+color.getGreen()+", "+color.getBlue()+"); font-family:'"+font+"'; font-size: 11px;' WIDTH='"+width+"'>");
        	//sb.append("<div style='margin-bottom:4px;'>You:</div> ");
        	sb.append(text);
        	sb.append("<div style='margin-top:4px;'>"+ date +"</div>");
		sb.append("</div>");
		
        sb.append("</html>");
        this.setText(sb.toString());
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		this._date = date;
	}
}
