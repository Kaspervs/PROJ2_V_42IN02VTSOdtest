package FormElements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Scrollbar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ScrollField extends JPanel {
	private JPanel cp = new JPanel();
	private Dimension size;
	private int scrollSpeed = 16;
	private int spacerHeight = 10;
	
	public ScrollField(Dimension size) {
		this.size = size;
		
		this.setBackground(null);
		this.setLayout(null);
		this.setBounds(0, 0, size.width, size.height);
		
		
		cp.setBounds(0, 0, size.width, size.height);
		cp.setLayout(new BoxLayout(this.cp, BoxLayout.PAGE_AXIS));
		cp.setBackground(null);
		
		JScrollPane scrollPanel = new JScrollPane(cp);
		
		JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL) {

			  @Override
			  public boolean isVisible() {
			    return true;
			  }
		};
		
		scrollPanel.setBackground(null);
		scrollPanel.getViewport().setBackground(null);
		scrollPanel.setBounds(0, 0, size.width, size.height);
		scrollPanel.setVerticalScrollBar(scrollBar);  
		scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setBorder(null);
		scrollPanel.getVerticalScrollBar().setUnitIncrement(scrollSpeed);
		this.add(scrollPanel);
	}
	
	public void addElement(JComponent panel) {
		this.cp.add(panel);
		
		JPanel filler = new JPanel();
		filler.setSize(this.size.width,this.spacerHeight);
		filler.setBackground(null);
		this.cp.add(filler);
		
		this.cp.revalidate();
	}
	
	public void setNewSpacerHeight(int spacerheight) {
		this.spacerHeight = spacerheight;
	}
	
	public void setScrollSpeeld(int scrollspeed) {
		this.scrollSpeed = scrollspeed;
	}
}
