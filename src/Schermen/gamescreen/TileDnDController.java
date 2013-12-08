package Schermen.gamescreen;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Main.FontController;
import Schermen.GameScreen;

public class TileDnDController extends JPanel {
	
	private GameScreen _parent;
	private static TileDnDController INSTANCE = null;
	private Tile dragTile;
	
	protected TileDnDController() {}
	
	public static TileDnDController getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new TileDnDController();
		}
		return INSTANCE;
	}
	
	public void initTileController(GameScreen p){
		this._parent = p;
		this.setOpaque(false);
		this.setBounds(_parent.getBounds());
		this.setLayout(null);
		addMouseHandler();
		
	}
	//TODO clone the clicked Tile
	//TODO draghandler on the cloned Tile

	private void addMouseHandler(){
		
		/*SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {*/
				INSTANCE.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseMoved( final MouseEvent e) {
						Thread thread = new Thread( new Runnable() {
							
							@Override
							public void run() {
								if(dragTile == null) return;
								if(dragTile.isDrag() == true){
									
									dragTile.setLocation(getMiddlePoint(e.getPoint()));
								}
							}
						});
						thread.start();
					}
				});
				
			/*}
		});*/
	}
	
	private Point getMiddlePoint(Point p){
		return new Point(p.x - (dragTile.getWidth()/2), p.y - (dragTile.getHeight()/2));
	}

	
	public void addTile(Tile t){
		if(t == null) return;
		try {
			this.dragTile = (Tile) t.clone();
			this.add(dragTile);
			dragTile.setDrag(true);

			System.out.println("tile : "+t);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void removeTile(){
		this.removeAll();
		this.dragTile = null;
	}
}
