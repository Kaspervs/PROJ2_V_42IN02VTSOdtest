package FormElements;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageLabel extends JLabel {
	private Color backgroundColor = Color.white;
	private StringBuilder sb = new StringBuilder();

  public ImageLabel(String img) {
    this(new ImageIcon(img));
  }

  public ImageLabel(ImageIcon icon) {
    setIcon(icon);
    // setMargin(new Insets(0,0,0,0));
    setIconTextGap(0);
    // setBorderPainted(false);
    setBorder(null);
    setText("dsafsadf");
    setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
    this.repaint();
  }
  
	private StringBuilder createBalloonHTML(String text, Color color){
		String backgroundColor="background-color:rgb("+color.getRed()+", "+color.getGreen()+", "+color.getBlue()+");";
		int width = 260;
		
		sb.delete(0, sb.length());
		sb.append("<html>");
		
		sb.append("<div style='padding: 4px 7px; margin-bottom:10px; "+backgroundColor+" font-size: 11px;' WIDTH='"+width+"'>");
		        //sb.append("<div style='margin-bottom:4px;'>You:</div> ");
		        sb.append(text);
		        sb.append("</div>");
		        
		sb.append("</html>");
		return sb;
	}
	
	private void toggleBalloonColor(JLabel balloon, String text){
		balloon.setText(createBalloonHTML(text,Color.red).toString());
	}

}