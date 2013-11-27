package Main;

public class Main {
	private Gui gui;
	private ButtonListners btnListner;
	
	public Main() {
		//Turn on font AA
		System.setProperty("awt.useSystemAAFontSettings","on");
		System.setProperty("swing.aatext", "true");
		  
		btnListner = new ButtonListners(this);
		this.gui = new Gui(this);
	}
	
	public ButtonListners getBtnListner() {
		return this.btnListner;
	}
	
	public Gui getGUI() {
		return this.gui;
	}
}
