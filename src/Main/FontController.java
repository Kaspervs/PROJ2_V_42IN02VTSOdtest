package Main;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.FileInputStream;
import java.io.IOException;

public class FontController {
	   private static FontController instance = null;
	   private Font segoeuil, segoeui, seguisb;
	   
	   protected FontController() {}
	   
	   public static FontController getInstance() {
	      if(instance == null) {
	         instance = new FontController();
	      }
	      return instance;
	   }
	   
	   public void InitFonts() {
	        try {
				//Light
	        	segoeuil = Font.createFont( Font.TRUETYPE_FONT, new FileInputStream("bin/Assets/Fonts/segoeuil.ttf") );
				//Semi bold
		        seguisb = Font.createFont( Font.TRUETYPE_FONT, new FileInputStream("bin/Assets/Fonts/seguisb.ttf") );
		        //Normal
		        segoeui = Font.createFont( Font.TRUETYPE_FONT, new FileInputStream("bin/Assets/Fonts/segoeui.ttf") );
			} catch (FontFormatException | IOException e) {
				e.printStackTrace();
			}
	   }
	   
	   public Font getFont(String FontName) {
		   switch (FontName) {
		   		case "segoeui":
		   			return this.segoeui;
		   		case "segoeuil":
		   			return this.segoeuil;
		   		case "seguisb":
		   			return this.seguisb;
		   }
		   return new Font("", 0, 0);	//Lame hack, empty font
	   }
	   
	   public Font getSegoeUI(){
		   return this.segoeui;
	   }
	   public Font getSegoeLight(){
		   return this.segoeuil;
	   }
	   public Font getSegoeSemiBold(){
		   return this.seguisb;
	   }
}
