package FormElements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.ImageTool;
import Main.Gui;

@SuppressWarnings("serial")
public class ImageLabel extends JPanel {
	public ImageLabel(Gui gui, ImageIcon icon, String string) {
		this.setBackground(null);
		this.setLayout(null);
		this.setBounds(0, 0, 260, 57);
		
		icon = ImageTool.resize(icon, new Dimension(40,40));
		
		JLabel JavaLabel = new JLabel(icon);
		JavaLabel.setBounds(4,4, 49,49);
		this.add(JavaLabel);

		JLabel loginText = new JLabel(string);
		loginText.setForeground(Color.white);
		loginText.setBounds(69, 8, 181, 30);
		loginText.setFont(gui.segoeuil());
		loginText.setFont(new Font(loginText.getFont().getName(), Font.PLAIN, 24));
		
		this.add(loginText);
		this.add(new ColoredRectangle(new Rectangle(260,57), new Color(0,114,198)));
	}
		
}