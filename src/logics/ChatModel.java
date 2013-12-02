package logics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Main.DatabaseController;
import Schermen.ObserverSelectgame;
import Schermen.chat.ChatScreen;

public class ChatModel extends Observable {
	//Model
	
	private ResultSet oldMessages = null;
	private Date date;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Timestamp lastTime;
	private String startDate;
	private ArrayList<String> messages = new ArrayList<String>();
	private ArrayList<String> dates = new ArrayList<String>();
	private ArrayList<String> names = new ArrayList<String>();
	
	
	public ChatModel(){
		setStartDate();
		getChatMessages();
	}
	
	private void setStartDate(){
		try{
			date = sdf.parse("2013-01-01 00:00:00");
			startDate = sdf.format(date);
		}catch(ParseException e){
			e.printStackTrace();
		}
	}
	
	private void getChatMessages(){
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) 
			{
				getResultSet();
			}
		};
		Timer timer = new Timer(1000, taskPerformer);
		timer.setRepeats(true);
		timer.start();
	}
	
	private void getResultSet(){
		ResultSet rs = DatabaseController.getInstance().runQuery("SELECT * FROM chatregel AS cr"+ 
				" WHERE cr.Spel_ID = 511 "+ 
				" AND cr.datetime >= '"+startDate+"' ORDER BY cr.datetime ASC");
		
		if(rs == null) return;
		
		try{
			int rowcount = 0;
			int oldRowcount = 0;
			
			if (rs.last()) {
				rowcount = rs.getRow();
				rs.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
			}
			
			//if oldMessages not is null and has a last item
			if(oldMessages != null && oldMessages.last())
				oldRowcount = oldMessages.getRow(); // get row count
			
			
			//see if the new row count is different
			if(rowcount == oldRowcount) return;
				
			//Empty arrays
			messages = new ArrayList<String>();
			dates = new ArrayList<String>();
			
			while(rs.next()){
				//Add the date to the ArrayList
				String date = rs.getString("datetime");
				dates.add(date);
				
				//Add the message to the ArrayList
				String message = rs.getString("bericht");
				messages.add(message);
				
				//Add user name
				String name = rs.getString("Account_naam");
				names.add(name);
			}
			
			//Refresh the ChatBox
			change();
			
			//Set the Last ResultSet for the next time to compare the new one
			oldMessages = rs;
			
			
		}catch(SQLException ex){
			ex.printStackTrace(System.out);
		}
	}
	
	public void addObserver (Observer observer)
    {
        super.addObserver(observer);
 	  	observer.update(this,null);
    }
	
	public void change(){
		setChanged();
		notifyObservers();
	}
	
	public ArrayList<String> getMessages(){
		return this.messages;
	}

	public ArrayList<String> getDates() {
		return dates;
	}
	
	public ArrayList<String> getNames() {
		return names;
	}
	
}
