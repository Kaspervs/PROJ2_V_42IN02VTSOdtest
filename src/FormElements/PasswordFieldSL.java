package FormElements;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PasswordFieldSL extends JPasswordField implements FocusListener {
	private boolean firstFocus = false;
	private String originalText;
	
	public PasswordFieldSL(String text) {
		this.originalText = text;
		
		this.setText(text);
		this.setBorder(null);
		this.setForeground(Color.WHITE);
        this.setBackground(new Color(0.82352941176470588235294117647059f,0.82352941176470588235294117647059f,0.82352941176470588235294117647059f));
        this.setBorder(BorderFactory.createCompoundBorder(this.getBorder(), BorderFactory.createEmptyBorder(5, 10, 5, 5)));
        this.addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
		if(!firstFocus) {
			this.firstFocus = true;
			this.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(this.getPassword().equals("")) {
			this.setText(this.originalText);
			this.firstFocus = false;
		}
	}
}
