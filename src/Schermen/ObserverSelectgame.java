package Schermen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

import FormElements.ColoredRectangle;
import FormElements.MyButton;
import FormElements.ScrollField;
import Main.FontController;
import Main.Gui;

@SuppressWarnings("serial")
public class ObserverSelectgame extends JPanel {

	public ObserverSelectgame(Gui gui) {
		this.setBackground(null);
		this.setBounds(0, 0, gui.getWidth(), gui.getHeight());
		
		//Observer tekst
		JLabel observerText = new JLabel("Observer");
		observerText.setForeground(Color.white);
		observerText.setBounds(363,120,268,55);
		observerText.setFont(FontController.getInstance().getFont("segoeuil"));
		observerText.setFont(new Font(observerText.getFont().getName(), Font.PLAIN, 42));
		this.add(observerText);
		
		//Select Game tekst
		JLabel selectGameText = new JLabel("Select game");
		selectGameText.setForeground(Color.white);
		selectGameText.setBounds(363,184,125,29);
		selectGameText.setFont(FontController.getInstance().getFont("seguisb"));
		selectGameText.setFont(new Font(selectGameText.getFont().getName(), Font.BOLD, 22));
		this.add(selectGameText);
		
		//Logout Button
		MyButton logoutBtn = new MyButton("Logout");
		logoutBtn.setBounds(867, 566, 101, 27);
		logoutBtn.setFont(FontController.getInstance().getFont("seguisb"));
		logoutBtn.setFont(new Font(logoutBtn.getFont().getName(), Font.BOLD, 12));
		logoutBtn.setName("Logout");
		this.add(logoutBtn);
		
		logoutBtn.addActionListener(gui.getMain().getBtnListner());
	}

}
