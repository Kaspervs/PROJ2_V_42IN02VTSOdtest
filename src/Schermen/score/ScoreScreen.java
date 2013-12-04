package Schermen.score;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.ImageTool;
import Schermen.GameScreen;

public class ScoreScreen extends JPanel {
	//View
	private GameScreen _parent;
	private Rectangle bounds = new Rectangle(1000, 20, 260, 164);
	private JLabel avatar1, avatar2;
	private Dimension avatarDimension = new Dimension(57,57);
	private static final String AVATAR = "/Assets/Images/default-avatar.png";
	
	public ScoreScreen(){
		this.setBounds(bounds);
		System.out.println(" Score ");
		this.setBackground(Color.red);
		setAvatars();
	}
	
	private void setAvatars(){
		this.avatar1 = getAvatar(AVATAR);
		this.avatar1.setLocation(0, 54);
		
		this.avatar2 = getAvatar(AVATAR);
		this.avatar2.setLocation(203, 54);
		this.add(avatar1);
		this.add(avatar2);
	}
	
	private JLabel getAvatar(String url){
		//Default avatar
		File f = null;
		BufferedImage bImg = null;
		Image img = null;
		ImageIcon imgIcon = null;
		JLabel label = null;
		try {
			// get File
			f = new File(getClass().getResource(url).toURI());
			// read the file to an image
			bImg = ImageIO.read(f);
			//Resize the buffered image 
			img = ImageTool.resize(ImageTool.toImage(bImg), avatarDimension.width, avatarDimension.height);
			//set to icon
			imgIcon = new ImageIcon(img);
			//put it into a jlabel
			label = new JLabel(imgIcon);
			//set bounds
			label.setBounds(0, 0, imgIcon.getIconWidth(), imgIcon.getIconHeight());
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
		return label;
	}
}
