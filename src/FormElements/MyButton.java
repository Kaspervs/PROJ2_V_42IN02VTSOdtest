package FormElements;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class MyButton extends JButton {
	public MyButton(String text) {
		this.setText(text);
        Border thickBorder = new LineBorder(new Color(0.533333f,0.533333f,0.533333f), 2);
        this.setBorder(thickBorder);
        this.setBackground(new Color(0.08984375f,0.08984375f,0.08984375f));
        this.setForeground(Color.WHITE);
        this.setContentAreaFilled(false);
        this.setFocusable(false);
	}
}
