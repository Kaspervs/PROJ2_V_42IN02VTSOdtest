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
		
		//Initiate DB connection
		DatabaseController DC = DatabaseController.getInstance();
		DC.setDatabase("tdalmaij_db2").setHost("databases.aii.avans.nl").setPassword("Ab12345").setUser("tdalmaij");
		DC.OpenConnection();
	}
	
	public ButtonListners getBtnListner() {
		return this.btnListner;
	}
	
	public Gui getGUI() {
		return this.gui;
	}
}
