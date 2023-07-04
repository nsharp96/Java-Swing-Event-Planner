/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.eventmanager.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Natalie Sharp - K2041275
 */
public class leftSidePanel extends JPanel
{
    //Attributes:
    private JPanel information = new JPanel();
    private JPanel organisers = new JPanel();
    private JTextArea organiserField = new JTextArea();
    private JScrollPane organiserScroll = new JScrollPane(organiserField);
    private JPanel events = new JPanel();
    private JTextArea eventsField = new JTextArea();
    private JScrollPane eventsScroll = new JScrollPane(eventsField);
    private JPanel users = new JPanel();
    
    
    leftSidePanel()
    {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);
        setBorder(new EmptyBorder(10,10,10,10));
        
        information.setBackground(Color.LIGHT_GRAY);
        JTextArea welcome = new JTextArea("Welcome to the Event Manager Application!"
                + System.lineSeparator()+ ""
                + System.lineSeparator()+ "Within this Application you can:"
                + System.lineSeparator()+ "- Create Events"
                + System.lineSeparator()+ "- Assign Agenaitems to the Events"
                + System.lineSeparator()+ "- Assign an Organiser to the Events"
                + System.lineSeparator()+ ""
                + System.lineSeparator()+ "Have fun!"
                + System.lineSeparator()+ ""
                + System.lineSeparator()+ "Remember to save your Event Manager"
                + System.lineSeparator()+ "to a file at the end so that you "
                + System.lineSeparator()+ "can open it up again another time!");
        welcome.setMargin(new Insets(10, 10, 10, 10));
        welcome.setBackground(Color.LIGHT_GRAY);
        welcome.setForeground(Color.black);
        information.add(welcome);
        this.add(information,BorderLayout.NORTH);
        welcome.setEditable(false);

        JPanel bottom = new JPanel();
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.Y_AXIS));
        
        organisers.setLayout(new BorderLayout());
        organisers.setBackground(Color.LIGHT_GRAY);
        Border border = new LineBorder(Color.pink, 2, true);
        organisers.setBorder(new TitledBorder(border,"Organisers"));
        organiserField.setEditable(false);
        
        
        
        
        events.setLayout(new BorderLayout());
        events.setBackground(Color.LIGHT_GRAY);
        events.setBorder(new TitledBorder(border,"Event Items"));
        organisers.add(organiserScroll);
        events.add(eventsScroll);
        eventsField.setEditable(false);
        
        bottom.add(organisers);
        bottom.add(events);

        this.add(bottom,BorderLayout.CENTER);
    }
    
    public JTextArea getOrganiserField() {
        return organiserField;
    }

    public void setOrganiserField(JTextArea organiserField) {
        this.organiserField = organiserField;
    }

    public JTextArea getEventsField() {
        return eventsField;
    }

    public void setEventsField(JTextArea eventsField) {
        this.eventsField = eventsField;
    }

    
}
