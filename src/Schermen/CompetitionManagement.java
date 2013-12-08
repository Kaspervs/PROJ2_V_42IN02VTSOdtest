package Schermen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logics.CompetitionLogics;
import FormElements.ImageLabel;
import FormElements.MyButton;
import FormElements.ScrollField;
import Main.Gui;

public class CompetitionManagement extends JPanel {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        private Gui _gui;
        private ArrayList<String> friends = new ArrayList<String>();
        private CompetitionLogics competitionLogics;
        private ArrayList<ImageLabel> alImageLabel;
        private ScrollField sf = new ScrollField(new Dimension(500,500));

        public CompetitionManagement(Gui gui){

                this.competitionLogics = new CompetitionLogics(this);
                alImageLabel = new ArrayList<ImageLabel>();
                this._gui = gui;
                this.setBackground(null);
                this.setBounds(0, 0, gui.getWidth(), gui.getHeight());
                this.setLayout(null);
                setFriends();
                
                //Create layout
                this.add(createTitle("New Game"));
               	createFriendsList(this,"Friends");

                sf = new ScrollField(new Dimension(350,300));
		        sf.setBounds(425,250,350,300);
		        sf.setLayout(null);

                for(String friend : friends){
                        ImageLabel il = new ImageLabel(gui, new ImageIcon(getClass().getResource("/Assets/Images/default-avatar.png")), friend);
                        il.setLayout(null);
                        competitionLogics.initMouseListener(il);
                        alImageLabel.add(il);
                        sf.addElement(il);
                }
                this.add(sf);
                this.add(createButton("Add", "btnAdd", new Rectangle(425, 650, 55, 27)));
                this.add(createButton("Edit", "btnEdit", new Rectangle(485, 650, 55, 27)));
                this.add(createButton("Create", "btnCreate", new Rectangle(600, 650, 55, 27)));
                this.add(createButton("Back", "btnBack", new Rectangle(660, 650, 55, 27)));
                this.add(createButton("Logout", "btnLogout", new Rectangle(750, 670, 55, 27)));
        }
        
        public Gui get_gui() {
                return _gui;
        }
        
        public void set_gui(Gui _gui) {
                this._gui = _gui;
        }
        
        public void setAlImageLabel(ArrayList<ImageLabel> alImageLabel) {
                this.alImageLabel = alImageLabel;
        }
        
         public ArrayList<ImageLabel> getAlImageLabel() {
                return alImageLabel;
        }

        private MyButton createButton(String text, String name, Rectangle bounds){
                 MyButton button = new MyButton(text);
                 button.setBounds(bounds);
                 button.setFont(new Font(button.getFont().getName(), Font.BOLD, 12));
                 button.setName(name);
                 button.addActionListener(this.getcompetitionLogics());
                 return button;
         }
        
        public CompetitionLogics getcompetitionLogics() {
                return competitionLogics;
        }
        
        private void setFriends(){
                this.friends.add("Henk");
                this.friends.add("Seline");
                this.friends.add("Thommes");
        }
        
        private JLabel createTitle(String text) {
                JLabel title = new JLabel(text);
                title.setForeground(Color.white);
                title.setBounds(426,120,268,55);
                //title.setFont(_gui.segoeuil());
                title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 42));
                return title;
        }
        
        private void createFriendsList(JPanel panel, String text){
                JLabel title = new JLabel(text);
                title.setForeground(Color.white);
                title.setBounds(426,170,268,55);
                //title.setFont(_gui.segoeuil());
                title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
                panel.add(title);
                
                return;
        }        
}