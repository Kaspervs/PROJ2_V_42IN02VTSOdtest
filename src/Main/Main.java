package Main;

public class Main {
	private Gui gui;
	private ButtonListners btnListner;
	private DatabaseController DC;
	
	public Main() {
		//Turn on font AA
		System.setProperty("awt.useSystemAAFontSettings","on");
		System.setProperty("swing.aatext", "true");
		
		//Initiate DB connection
		DC = DatabaseController.getInstance();
		DC.setDatabase("tdalmaij_db2").setHost("databases.aii.avans.nl").setPassword("Ab12345").setUser("tdalmaij");
		DC.OpenConnection();
		  
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
