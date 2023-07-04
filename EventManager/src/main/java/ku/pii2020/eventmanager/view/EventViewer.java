/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.eventmanager.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

/**
 *
 * @author Natalie Sharp - K2041275
 */
public class EventViewer extends JFrame
{
    //Attributes
    private static EventViewer instance;
    private static leftSidePanel leftSide = new leftSidePanel();
    public static rightSide rightSide = new rightSide();
    private JMenuItem load = new JMenuItem("Load");
    private JMenuItem save = new JMenuItem("Save");
    private JMenuItem clearOrg = new JMenuItem("Clear Organiser");
    private JMenuItem quit = new JMenuItem("Quit");
    /**
     *
     * @return Instance of the Event Viewer. Ensures there is only one event viewer at all times. 
     */
    public static EventViewer getInstance()
    {
        //If there isn't a EventViewer yet create one
        if (instance == null)
        {
            instance = new EventViewer();
        }
        //Otherwise return the only instance that will be made
        return instance;
    }
    
    /**
     *
     */
    public EventViewer()
    {
        this.setLayout(new BorderLayout());
        setResizable(false);
        
        //Create menubar
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        file.add(load);
        file.add(save);
        file.add(clearOrg);
        file.add(quit);
        menubar.add(file);
        this.setJMenuBar(menubar);
        leftSide.setSize(300, 1000);
        this.add(leftSide, BorderLayout.WEST);
        this.add(rightSide, BorderLayout.CENTER);
        //JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftSide,rightSide);
       // this.add(splitPane, BorderLayout.CENTER);
        
        this.setTitle("Data Viewer"); //sets title of object
        this.setBounds(120,20,1000,600); //sets size and location of dataviewer
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes program when it is closed
        this.setVisible(true); //makes the dataviewer visible 
    }
    
    public rightSide getRightSide() 
    {
        return rightSide;
    }

    public void setRightSide(rightSide rightSide) {
        EventViewer.rightSide = rightSide;
    }
    
    public static leftSidePanel getLeftSide() {
        return leftSide;
    }

    public static void setLeftSide(leftSidePanel leftSide) {
        EventViewer.leftSide = leftSide;
    }
    
    public JMenuItem getLoad() {
        return load;
    }

    public void setLoad(JMenuItem load) {
        this.load = load;
    }
    
    public JMenuItem getSave() {
        return save;
    }

    public void setSave(JMenuItem save) {
        this.save = save;
    }
    
    public JMenuItem getQuit() {
        return quit;
    }

    public void setQuit(JMenuItem quit) {
        this.quit = quit;
    }
    
    public JMenuItem getClearOrg() {
        return clearOrg;
    }

    public void setClearOrg(JMenuItem clearOrg) {
        this.clearOrg = clearOrg;
    }
    

    
    
    
    
}
