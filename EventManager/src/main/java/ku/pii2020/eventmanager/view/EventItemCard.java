/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.eventmanager.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.time.LocalTime;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import ku.pii2020.eventmanager.model.Event;
import ku.pii2020.eventmanager.model.EventItems;

/**
 *
 * @author Student
 */
public class EventItemCard extends JPanel 
{
    JPanel eventItemPanel = new JPanel();
    private JCheckBox checker = new JCheckBox();
    static ButtonGroup checkBoxGroup = new ButtonGroup();
    private EventCard eventCard;
    private EventItems eventItem;
    private JTextArea Itemtitle = new JTextArea();
    private JTextArea Itemtime = new JTextArea();
    //Make a list of eventitems for every item in event
    
    public EventItemCard(String title, LocalTime time, EventCard ec)
    {
        this.eventCard = ec;
        checkBoxGroup.add(checker);
        eventItemPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(eventItemPanel);
        eventItemPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        eventItemPanel.setLayout(new FlowLayout());
        eventItemPanel.setPreferredSize(new Dimension(580,50));
        eventItemPanel.setBackground(Color.white);
        this.add(checker);
        if (title!=null)
        {
            this.getItemtitle().setText("Event Title: "+title);
        }
        if (time!=null)
        {
            this.getItemtime().setText("Event Time: "+time.toString());
        }
        
        eventItemPanel.add(Itemtime);
        eventItemPanel.add(Itemtitle);
        
        
        
    }
    
    public JTextArea getItemtitle() {
        return Itemtitle;
    }

    public void setItemtitle(JTextArea Itemtitle) {
        this.Itemtitle = Itemtitle;
    }
    
    public JTextArea getItemtime() {
        return Itemtime;
    }

    public void setItemtime(JTextArea Itemtime) {
        this.Itemtime = Itemtime;
    }
    
    public EventItems getEventItem() {
        return eventItem;
    }

    public void setEventItem(EventItems eventItem) {
        this.eventItem = eventItem;
    }
    
    public JCheckBox getChecker() {
        return checker;
    }

    public void setChecker(JCheckBox checker) {
        this.checker = checker;
    }
}
